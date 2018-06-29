package org.spring.springboot.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 16:19
 */
public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> saveList = null;
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        int i = 0;
        while (i*100 < list.size()) {
            if(i*100 + 100 < list.size())
                saveList = list.subList(i*100, i*100 + 100);
            else
                saveList = list.subList(i*100, list.size());
            System.out.println(saveList.size());
            i++;
        }
    }
}
