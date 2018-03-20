package com.example.demo.service;

import java.util.List;
import java.util.function.Consumer;

public class TSEntity {
    private boolean isSun = false;
    private String fatherName;
    private String sunName;

    private Consumer<TSEntity> sun;
    private Consumer<TSEntity> father;
    private boolean sunThrow;
    private Boolean fatherCatch;
    private boolean fatherThrow;

    private boolean canCallFather;
    private boolean canCallSun;
    private Boolean sunCanSeeFather;
    private Boolean fatherCanSeeSun;
    private List<String> result;

    @Override
    public String toString() {
        return "TSEntity{" +
                "fatherName='" + fatherName + '\'' +
                ", sunName='" + sunName + '\'' +
                ", sunThrow=" + sunThrow +
                ", fatherCatch=" + fatherCatch +
                ", fatherThrow=" + fatherThrow +
                ", canCallFather=" + canCallFather +
                ", canCallSun=" + canCallSun +
                ", sunCanSeeFather=" + sunCanSeeFather +
                ", fatherCanSeeSun=" + fatherCanSeeSun +
                ", result=" + result +
                '}';
    }

    public Consumer<TSEntity> getFather() {
        return father;
    }

    public void setFather(Consumer<TSEntity> father) {
        this.father = father;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getSunName() {
        return sunName;
    }

    public void setSunName(String sunName) {
        this.sunName = sunName;
    }

    public boolean isSun() {
        return isSun;
    }

    public void setSun(boolean sun) {
        isSun = sun;
    }

    public boolean isCanCallFather() {
        return canCallFather;
    }

    public void setCanCallFather(boolean canCallFather) {
        this.canCallFather = canCallFather;
    }

    public boolean isCanCallSun() {
        return canCallSun;
    }

    public void setCanCallSun(boolean canCallSun) {
        this.canCallSun = canCallSun;
    }

    public Boolean getSunCanSeeFather() {
        return sunCanSeeFather;
    }

    public void setSunCanSeeFather(Boolean sunCanSeeFather) {
        this.sunCanSeeFather = sunCanSeeFather;
    }

    public Boolean getFatherCanSeeSun() {
        return fatherCanSeeSun;
    }

    public void setFatherCanSeeSun(Boolean fatherCanSeeSun) {
        this.fatherCanSeeSun = fatherCanSeeSun;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public Consumer<TSEntity> getSun() {
        return sun;
    }

    public void setSun(Consumer<TSEntity> sun) {
        this.sun = sun;
    }

    public boolean isSunThrow() {
        return sunThrow;
    }

    public void setSunThrow(boolean sunThrow) {
        this.sunThrow = sunThrow;
    }

    public Boolean isFatherCatch() {
        return fatherCatch;
    }

    public void setFatherCatch(Boolean fatherCatch) {
        this.fatherCatch = fatherCatch;
    }

    public boolean isFatherThrow() {
        return fatherThrow;
    }

    public void setFatherThrow(boolean fatherThrow) {
        this.fatherThrow = fatherThrow;
    }
}
