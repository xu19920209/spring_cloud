package com.tuyue.aLi;

import sun.misc.BASE64Decoder;

import java.io.UnsupportedEncodingException;

/**
 * base64 编码、解码util
 *
 * @author lifq
 * @date 2015-3-4 上午09:23:33
 */
public class Base64Util {
    /**
     * 将 s 进行 BASE64 编码
     *
     * @return String
     * @author lifq
     * @date 2015-3-4 上午09:24:02
     */
    public static String encode(String s, String charseName) {
        if (s == null)
            return null;
        String res = "";
        try {
            res = new sun.misc.BASE64Encoder().encode(s.getBytes(charseName));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 将 BASE64 编码的字符串 s 进行解码
     *
     * @return String
     * @author lifq
     * @date 2015-3-4 上午09:24:26
     */
    public static String decode(String s, String charseName) {
        if (s == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s);
            return new String(b, charseName);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @return void
     * @author lifq
     * @date 2015-3-4 上午09:23:17
     */
    public static void main(String[] args) {
        // System.out.println(Base64Util.encode("王晨"));
        System.out.println(Base64Util.decode("zfWzvw==", "GBK"));

    }

}