package com.revature.services;

import java.util.Comparator;

import com.revature.beans.StringAndNumber;

public class SortArrayOfStringAndNumber implements Comparator<StringAndNumber> {

    @Override
    public int compare(StringAndNumber arg0, StringAndNumber arg1) {
        return arg1.getNumber() - arg0.getNumber();
    }

}
