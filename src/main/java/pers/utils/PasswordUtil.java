package pers.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordUtil {

    public static String encryptPassword(String password, String salt) {
        String newPassword =
                new SimpleHash("sha-256", password, salt, 4).toHex();
        return newPassword;
    }

}
