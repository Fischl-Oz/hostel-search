package com.fischl.DAOs.interfaces;

import java.util.ArrayList;

public interface IDao<T,IDT> {
    public boolean add(T item);
    public boolean update(T item);
    public boolean delete(IDT id);
    public ArrayList<T> getAll();
    public T getById(IDT id);
}
