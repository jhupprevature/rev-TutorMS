package com.revature.beans;

public class StringAndNumber {
    
    private String string;
    private Integer number;
    
    public StringAndNumber(String string, Integer number) {
        super();
        this.string = string;
        this.number = number;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "StringAndNumber [string=" + string + ", number=" + number + "]";
    }
    
}
