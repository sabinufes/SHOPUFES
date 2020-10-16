package com.ufes.utility;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {
private static final String SALT ="salt"; //protect 

@Bean 
public static BCryptPasswordEncoder passowrdEncoder() {
	
return new BCryptPasswordEncoder(12,new SecureRandom(SALT.getBytes()));



}

//GENERAM RANDOM STRINGS

@Bean
public static String randomPassword() {
	String SALTCHARS ="ABCEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	StringBuilder salt = new StringBuilder();
	Random rnd = new Random();
	
	while (salt.length()<18) {
		int index = (int) (rnd.nextFloat()*SALTCHARS.length());
		salt.append(SALTCHARS.charAt(index));
	}
	String saltStr = salt.toString();
	return saltStr;
}

}