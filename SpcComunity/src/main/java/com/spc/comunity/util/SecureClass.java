package com.spc.comunity.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SecureClass {
	
	public static String sha512(String pwd, String salt) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			String temp = pwd + salt;
			digest.reset();
			digest.update(temp.getBytes("utf8"));
			return String.format("%0128x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
