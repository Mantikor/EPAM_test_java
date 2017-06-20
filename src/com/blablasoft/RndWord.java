package com.blablasoft;

import java.security.SecureRandom;

public class RndWord {
    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public String randomString(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i=0; i < len; i++)
            sb.append( AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public int randomInt(int count){
        return rnd.nextInt(count) + 1;
    }

}
