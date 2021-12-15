package com.spring.app.interfaces;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    T get_by_id(long id);
    void remove(long id);
    T insert(T obj);
}
