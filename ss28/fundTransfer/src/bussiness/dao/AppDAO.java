package bussiness.dao;

import bussiness.model.Account;

import java.util.List;

public interface AppDAO<T>{
    List<Account> getAllAccount(T t);

    boolean save(T t);

    boolean delete(T t);

    boolean update(T t);
}
