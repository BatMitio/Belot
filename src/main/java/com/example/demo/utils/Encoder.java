package com.example.demo.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoder {
    public static String encode(String password)  {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] result = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        char[] hexDigits = new char[64];
        for (int i = 0; i < 32; i++) {
            hexDigits[i * 2] = Character.forDigit(result[i] >> 4 & 0xF, 16);
            hexDigits[i * 2 + 1] = Character.forDigit(result[i] & 0xF, 16);
        }
        return String.valueOf(hexDigits);
    }
}
