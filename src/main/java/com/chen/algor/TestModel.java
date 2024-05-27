package com.chen.algor;

import java.util.Date;

public class TestModel {
    public static void main(String[] args) {
        Date date = new Date();
        Class<? extends Date> aClass = date.getClass();
        try {
            Date date1 = aClass.newInstance();
            System.out.println(date1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
