# drop database if exists java_jdbc_practice;
create database java_jdbc_practice;
use java_jdbc_practice;

drop table if exists user;
create table user(
    u_id int primary key auto_increment,
    u_name varchar(50) not null unique,
    u_password varchar(50) not null
);

create table department(
    d_id int primary key auto_increment,
    d_name varchar(100) not null,
    d_description varchar(255),
    d_status bit default(1)
);

create table employee(
    e_id varchar(5) primary key,
    e_name varchar(150) not null unique,
    e_email varchar(50) not null unique,
    e_phone varchar(10) not null unique,
    e_gender enum('MALE', 'FEMALE', 'OTHER'),
    e_salary_level int check ( e_salary_level > 0 ),
    e_salary decimal(15, 2) check ( e_salary > 0 ),
    e_birth_date date,
    e_address varchar(100) not null,
    e_status enum('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE'),
    d_id int not null,
    foreign key (d_id) references department(d_id)
);

delimiter //
create procedure login(in_u_name varchar(50), in_u_password varchar(20))
begin
    select count(u_id) from user u
    where u_name = in_u_name and u_password = in_u_password;
end;
delimiter //


DELIMITER //

CREATE PROCEDURE find_all_department(
    IN page INT,
    IN page_size INT
)
BEGIN
    DECLARE offset_value INT;
    IF page <= 0 OR page_size <= 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'page and page_size must be positive!';
    END IF;
    SET offset_value = (page - 1) * page_size;
    SELECT
        d.d_id AS "Department ID",
        d.d_name AS "Department Name",
        d.d_description AS "Department Description"
    FROM department d
    LIMIT page_size OFFSET offset_value;
END //

DELIMITER ;


delimiter //
create procedure find_department_by_name(in_d_name varchar(100))
begin
    select
        d.d_id,
        d.d_name,
        d.d_description,
        d.d_status
    from department d
    where d.d_name = in_d_name;
end;
delimiter //

DELIMITER //
CREATE PROCEDURE create_department(
    IN in_d_name VARCHAR(100),
    IN in_d_description VARCHAR(255),
    IN in_d_status BIT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Failed to create department. Please check your input!';
        END;
    INSERT INTO department (d_name, d_description, d_status)
    VALUES (in_d_name, in_d_description, in_d_status);
END //
DELIMITER ;


delimiter //
create procedure update_department(in_d_id int,in_d_name varchar(100), in_d_description varchar(255), in_d_status bit)
begin
    update department
    set d_name = in_d_name,
        d_description = in_d_description,
        d_status = in_d_status
    where d_id = in_d_id;
end;
delimiter //

delimiter //
create procedure delete_department(in_d_id int)
begin
    delete from department
    where d_id = in_d_id
      and not exists (
        select 1
        from employee e
        where e.d_id = in_d_id
    );
end;
delimiter //

DELIMITER //
CREATE PROCEDURE find_all_employee(IN page INT, IN pageSize INT)
BEGIN
    declare offset_value int;
    IF pageSize <= 0 OR page <= 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'page and pageSize must be positive!';
    END IF;
    set offset_value = (page - 1) * pageSize;
    SELECT
        e.e_id,
        e.e_name,
        e.e_email,
        e.e_phone,
        e.e_gender,
        e.e_salary_level,
        e.e_salary,
        e.e_birth_date,
        e.e_address,
        e.e_status,
        e.d_id
    FROM employee e
    LIMIT pageSize OFFSET offset_value;
END //
DELIMITER ;

delimiter //
create procedure find_employee_by_name(in_e_name varchar(150))
begin
    select
        e.e_id,
        e_name,
        e_email,
        e_phone,
        e_gender,
        e_salary_level,
        e_salary,
        e_birth_date,
        e_address,
        e_status,
        d_id
    from employee e
    where e.e_name = in_e_name;
end;
delimiter //

DELIMITER //

CREATE PROCEDURE find_employee_by_age(
    IN in_min_age INT,
    IN in_max_age INT,
    IN page INT,
    IN page_size INT
)
BEGIN
    DECLARE offset_value INT;
    IF in_min_age < 0 OR in_max_age < 0 OR in_min_age > in_max_age THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Invalid age range!';
    END IF;
    IF page <= 0 OR page_size <= 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'page and page_size must be positive!';
    END IF;
    SET offset_value = (page - 1) * page_size;
    SELECT
        e.e_id,
        e.e_name,
        e.e_email,
        e.e_phone,
        e.e_gender,
        e.e_salary_level,
        e.e_salary,
        e.e_birth_date,
        e.e_address,
        e.e_status,
        e.d_id
    FROM employee e
    WHERE TIMESTAMPDIFF(YEAR, e.e_birth_date, CURDATE())
              BETWEEN in_min_age AND in_max_age
    LIMIT page_size OFFSET offset_value;
END //

DELIMITER ;


delimiter //
create procedure sort_employee_desc_by_salary()
begin
    select
        e.e_id,
        e_name,
        e_email,
        e_phone,
        e_gender,
        e_salary_level,
        e_salary,
        e_birth_date,
        e_address,
        e_status,
        d_id
    from employee e
    order by e.e_salary desc;
end;
delimiter //

delimiter //
create procedure sort_employee_asc_by_name()
begin
    select
        e.e_id,
        e_name,
        e_email,
        e_phone,
        e_gender,
        e_salary_level,
        e_salary,
        e_birth_date,
        e_address,
        e_status,
        d_id
    from employee e
    order by e.e_name asc;
end;
delimiter //

delimiter //
create procedure create_employee(
    in_e_id varchar(5),
    in_e_name varchar(150),
    in_e_email varchar(50),
    in_e_phone varchar(10),
    in_e_gender enum('MALE', 'FEMALE', 'OTHER'),
    in_e_salary_level int,
    in_e_salary decimal(15, 2),
    in_e_birth_date date,
    in_e_address varchar(100),
    in_e_status enum('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE'),
    in_d_id int
)
begin
    if exists (select 1 from department where d_id = in_d_id and d_status = 1) then
        insert into employee
        set e_id = in_e_id,
            e_name = in_e_name,
            e_email = in_e_email,
            e_phone = in_e_phone,
            e_gender = in_e_gender,
            e_salary_level = in_e_salary_level,
            e_salary = in_e_salary,
            e_birth_date = in_e_birth_date,
            e_address = in_e_address,
            e_status = in_e_status,
            d_id = in_d_id;
    else
        signal sqlstate '45000'
            set message_text = 'Cannot add employee to an inactive department!';
    end if;
end;
delimiter //

delimiter //
create procedure update_employee(
    in_e_id varchar(5),
    in_e_name varchar(150),
    in_e_email varchar(50),
    in_e_phone varchar(10),
    in_e_gender enum('MALE', 'FEMALE', 'OTHER'),
    in_e_salary_level int,
    in_e_salary decimal(15, 2),
    in_e_birth_date date,
    in_e_address varchar(100),
    in_e_status enum('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE'),
    in_d_id int
)
begin
    if exists (select 1 from department where d_id = in_d_id and d_status = 1) then
        update employee
        set e_name = in_e_name,
            e_email = in_e_email,
            e_phone = in_e_phone,
            e_gender = in_e_gender,
            e_salary_level = in_e_salary_level,
            e_salary = in_e_salary,
            e_birth_date = in_e_birth_date,
            e_address = in_e_address,
            e_status = in_e_status,
            d_id = in_d_id
        where e_id = in_e_id;
    else
        signal sqlstate '45000'
            set message_text = 'Cannot update employee to an inactive department!';
    end if;
end;
delimiter //

delimiter //
create procedure delete_employee(in_e_id varchar(5))
begin
    update employee
    set e_status = 'INACTIVE'
    where e_id = in_e_id;
end;
delimiter //

delimiter //
create procedure count_employees_by_department(out count int)
begin
    select
        d.d_id,
        d.d_name,
        count(e.e_id) as count
    from department d
             left join employee e on d.d_id = e.d_id
    group by d.d_id, d.d_name;
end;
delimiter //

delimiter //
create procedure count_total_employees(out count int)
begin
    select count(e_id) into count
    from employee;
end;
delimiter //

delimiter //
create procedure department_with_most_employees()
begin
    select
        d.d_id,
        d.d_name,
        count(e.e_id) as employee_count
    from department d
             left join employee e on d.d_id = e.d_id
    group by d.d_id, d.d_name
    order by employee_count desc
    limit 1;
end;
delimiter //

delimiter //
create procedure department_with_highest_salary()
begin
    select
        d.d_id,
        d.d_name,
        sum(e.e_salary) as total_salary
    from department d
             left join employee e on d.d_id = e.d_id
    group by d.d_id, d.d_name
    order by total_salary desc
    limit 1;
end;
delimiter //