package org.base64;

import java.nio.charset.StandardCharsets;

public class Encoder {
    private static final char[] toBase64 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };
    private StringBuilder result;

    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        String text = "base64";
        System.out.println("Encoding result: "+ encoder.encode(text.getBytes(StandardCharsets.UTF_8)));
    }

    public String encode(byte[] data) {
        StringBuilder encodedResult = new StringBuilder((int) Math.ceil(data.length * 8.0 / 6.0));

        for(int i = 0; i < data.length ; i+= 3) {
            int byteCount = Math.min(3, data.length - i);

            var buffer = 0;
            for(int j = 0; j < byteCount; j++) {
                buffer = (buffer << 8) | data[i+j];
            }
            var bitCount = byteCount * 8;
            System.out.println(i+". bits: "+bitCount+" | bytes: "+byteCount);
            System.out.println("buffer: "+buffer);
            while(bitCount > 0) {
                var index = 0;
                if(bitCount >= 6) {
                    index = (buffer >> (bitCount - 6)) & 0x3F;
                    encodedResult.append(toBase64[index]);
                } else {
                    index = (buffer & (0x3f >> (6 - bitCount))) << (6 - bitCount);
                    encodedResult.append(toBase64[index]);

                    int bits = (byteCount * 8) + (6 - bitCount);
                    while(bits != 24) {
                        encodedResult.append("=");
                        bits += 6;
                    }
                }
                bitCount -= 6;
            }
        }
        return encodedResult.toString();
    }

    /**
     * doesn't work bruh :/
     * @param data (byte)
     * @return encoded string
     */
    public String stupidEncode(byte[] data) {
        printData(data);
        StringBuilder decimalStr = new StringBuilder();
        for(byte b : data) {
            decimalStr.append(String.format("%8s", Integer.toBinaryString(b)).replaceAll("\\s", "0"));
        }
        System.out.println(decimalStr);

        StringBuilder resultStr = new StringBuilder();
        boolean hasExtraBytes = false;
        int index;
        for (int i = 0; i < decimalStr.length(); i+=6) {

            if(i+6 > decimalStr.length()) {
                String extraSubstring = decimalStr.substring(i, decimalStr.length());
                System.out.println(extraSubstring);
                index = Integer.parseInt(decimalStr.substring(i, decimalStr.length()), 2);
                hasExtraBytes = true;
                System.out.println("nullable index: "+ index);
            }
            else {
                index = Integer.parseInt((decimalStr.substring(i, i+6)), 2);
            }
            resultStr.append(toBase64[index]);
        }
        System.out.println(resultStr);

        if(hasExtraBytes) {
            resultStr.append("=");
        }

        return resultStr.toString();
    }

    private void printData(byte[] data) {
        for(byte b : data) {
            System.out.print(b+" ");
        }
        System.out.print("\n");
    }
}
