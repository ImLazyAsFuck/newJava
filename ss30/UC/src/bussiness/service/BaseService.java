package bussiness.service;

import java.util.List;

public interface BaseService<T>{
    List<T> findAll(int page, int pageSize);
    boolean save(T t);
    boolean update(T t);
    boolean delete(T t);
}
