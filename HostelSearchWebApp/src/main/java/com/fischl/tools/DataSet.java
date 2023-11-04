package com.fischl.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataSet<T> {
    private ArrayList<T> list;
    DataSet() {
        list = new ArrayList<>();
    }
    DataSet(ArrayList<T> list) {
        this.list = list;
    }
    public ArrayList<T> toList() {
        return list;
    }
    public T SingleOrDefault(Predicate<? super T> condition) {
        Stream<T> stream = list.stream();
        List<T> matchingObjects = stream.filter(condition).collect(Collectors.toList());

        if (matchingObjects.size() == 1) {
            return matchingObjects.get(0); // Return the single matching object
        } else {
            return null; // Return null if there are zero or more than one matching objects
        }
    }
    public T FirstOrDefault(Predicate<? super T> condition) {
        Stream<T> stream = list.stream();
        return stream.filter(condition).findFirst().orElse(null);
    }
    public ArrayList<T> Where(Predicate<? super T> condition) {
        Stream<T> stream = list.stream();
        return (ArrayList<T>) stream.filter(condition).collect(Collectors.toList());
    }
}