package com.moonlight.algorithm.train.design;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/encode-and-decode-tinyurl/
 *
 * TinyURL是一种URL简化服务， 比如：
 *   当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，
 *   它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 *
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。
 *      你的加密和解密算法如何设计和运作是没有限制的，
 *      你只需要保证一个URL可以被加密成一个TinyURL，
 *      并且这个TinyURL可以用解密方法恢复成原本的URL。
 *
 * @author Moonlight
 */
public class TinyUrl {

    public static void main(String[] args) {
        Codec codec = new Codec();
        String s = codec.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(s);
        System.out.println(codec.decode(s));
    }

    public static class Codec {
        private Map<Integer, String> map = new HashMap<>();
        private static final String PREFIX = "http://tinyurl.com/";
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            int hashCode = longUrl.hashCode();
            map.put(hashCode, longUrl);
            return Codec.PREFIX + hashCode;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(Integer.parseInt(shortUrl.replaceAll(Codec.PREFIX, "")));
        }
    }

}
