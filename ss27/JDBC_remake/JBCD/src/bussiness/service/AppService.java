package src.bussiness.service;

import java.util.List;

public interface AppService<T>{
    List<T> getAllStudent();

    boolean save(T t);

    boolean update(T t);

    boolean delete(T t);
}
