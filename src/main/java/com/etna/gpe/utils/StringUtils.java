package com.etna.gpe.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class StringUtils {
	
	public static String hashBcrypt(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public static boolean verifyHash(String passwordToCheck, String passwordhashed) {
		return BCrypt.checkpw(passwordToCheck, passwordhashed);
	}
	

	
	public static boolean isEmptyOrNull(String criteria) {
		return criteria == null || criteria.isEmpty();
	}

}
