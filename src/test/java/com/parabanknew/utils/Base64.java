package com.parabanknew.utils;

public class Base64 {
    public static String encode(String text) {
        byte[] data = text.getBytes();
        return java.util.Base64.getEncoder().encodeToString(data);
    }

    public static String decode(String base64Text) {
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(base64Text);
        return new String(decodedBytes);
    }
}
