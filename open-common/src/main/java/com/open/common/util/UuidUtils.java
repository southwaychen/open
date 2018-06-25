package com.open.common.util;


import java.util.Base64;
import java.util.UUID;

public class UuidUtils {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
        public static void main(String[] args) {
        System.out.println(UuidUtils.uuid());
       // System.out.println(UuidUtils.compressedUuid());

    }
}