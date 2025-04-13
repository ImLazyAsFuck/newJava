package bussiness.dao.departmentDAO;

import bussiness.dao.BaseDAO;
import bussiness.model.departmentModel.Department;

public interface DepartmentDAO extends BaseDAO<Department>{
    Department findDepartmentByName(String departmentName);
}
