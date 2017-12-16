package com.tinker.findme.util;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Base64;
import javax.enterprise.context.Dependent;

@Dependent
public class SecurityUtil {


    public String encodeText(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes("UTF-8"));
            byte[] passwordDigest = md.digest();
            return new String(Base64.getEncoder().encode(passwordDigest));
        } catch (Exception e) {
            throw new RuntimeException("Exception encoding password", e);
        }
    }


    public  Key generateKey(String keyString) {
        return new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
    }
}

