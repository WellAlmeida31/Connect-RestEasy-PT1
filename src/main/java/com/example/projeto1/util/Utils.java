package com.example.projeto1.util;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class Utils {

    public String toJson(Object obj){
        return new Gson().toJson(obj);
    }

    public static <T> String arrayToString(List<T> list) {
        return new Gson().toJson(list);
    }

}
