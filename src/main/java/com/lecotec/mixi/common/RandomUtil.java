package com.lecotec.mixi.common;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();

    public static String getRandomToken() throws Exception {
        return EncryptUtil.calcMD5_Bin16(String.valueOf(getRandomNum()));
    }

    public static int getRandomNum() {
        return random.nextInt(100000000);
    }

    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
