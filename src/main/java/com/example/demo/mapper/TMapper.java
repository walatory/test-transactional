package com.example.demo.mapper;

import com.example.demo.bean.T;

import java.util.List;

public interface TMapper {

    Integer init1();

    Integer init2();

    Integer insert(T t);

    List<String> select();
}
