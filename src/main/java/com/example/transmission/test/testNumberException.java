package com.example.transmission.test;

import com.example.transmission.util.CustomException;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class testNumberException {

    public void test(int i){
        try{
            if(i>=0){
                System.out.println(i);
            }else{
                throw new CustomException("i的值必须大于等于0");
            }
        }catch (CustomException e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        // 创建一个MessageDigest实例:
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            // 反复调用update输入数据:
            md.update("Hello".getBytes("UTF-8"));
            md.update("World".getBytes("UTF-8"));
            byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
            System.out.println(new BigInteger(1, result).toString(16));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
