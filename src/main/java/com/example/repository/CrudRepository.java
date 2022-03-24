package com.example.repository;

import java.util.List;

public interface CrudRepository<T> {

    public void create();

    public List<T> findAll();

    public List<T> findById();

    public void update();

    public void delete();

}
