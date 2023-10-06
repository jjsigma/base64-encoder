package org.base64;

import java.nio.charset.StandardCharsets;


public class Main {
    private static final char[] toBase64 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };
    private StringBuilder result;

    public static void main(String[] args) {
//        String text = "abcdefg";
//        new Main().encode(text);
        System.out.println(toBase64[48]);
        System.out.println(toBase64[12]);
        System.out.println(toBase64[7]);
        System.out.println(toBase64[2]);

    }
    public void encode(String text) {
        if(text == null) {
            throw new IllegalArgumentException("data is null");
        }
//        byte[] data = text.getBytes(StandardCharsets.UTF_8);
//
//        //needless
//        for (byte b : data) {
//            System.out.print(b+" ");
//        }
//
//        result = new StringBuilder((int) Math.ceil(data.length * 8.0 / 6.0));
//
//        for(int i = 0; i < data.length; i += 6) {
//            int byteCount = Math.min(6, data.length-1);
//            long buffer = 0;
//            for (var j = 0; j < byteCount; ++j)
//            {
//                buffer = (buffer << 8) | data[i + j];
//                System.out.println(buffer);
//            }
//        }
    }

    private void appendLetter(String letter) {
        result.append(letter);
    }
}