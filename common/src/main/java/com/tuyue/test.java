package com.tuyue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntBinaryOperator;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/23.
 */
public class test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("a", "b", "c", "d");
        Collections.sort(names, ( a,b) -> b.compareTo(a));
        for (String name : names) {
            System.out.println(name);
        }
    }

}
