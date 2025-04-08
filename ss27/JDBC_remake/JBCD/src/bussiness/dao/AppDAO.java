package src.bussiness.dao;

import java.util.List;

public interface AppDAO<T>{
    List<T> getAllStudent();

    boolean save(T t);

    boolean update(T t);

    boolean delete(T t);
}
