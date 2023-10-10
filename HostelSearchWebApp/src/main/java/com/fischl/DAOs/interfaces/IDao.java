package com.fischl.DAOs.interfaces;

import java.util.ArrayList;

public interface IDao<T,IDT> {
    public void add(T item);
    public void update(T item);
    public void delete(IDT id);
    public ArrayList<T> getAll();
    public T getById(IDT id);
}
