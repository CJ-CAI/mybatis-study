package com.cj.utils;
import java.util.UUID;

public class ID_utility{
    public static  String getID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
