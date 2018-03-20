package com.example.demo.bean;

public class T {
    private Integer id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static T newT(Integer id, String name){
        T t = new T();
        t.setId(id);
        t.setName(name);
        return t;
    }

}
