package com.huxili.mapreduce.etl;

public class TestETL {
    public static void main(String[] args) {
        String check = "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$";

        // 检验phone是否为手机号，是返回true，否则返回false
        String phone = "1352235001312";

        System.out.println(phone.matches(check));
    }
}
