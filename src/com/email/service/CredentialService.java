package com.email.service;

import java.lang.Math;

import com.gl.model.Employee;

public class CredentialService {

	public static int generateRand(int max, int min) {
		return ((int) ((Math.random() * (max - min)) + min));
	}

	public static String generateEmailAddress(Employee emp) {
		return emp.getFirstName() + emp.getSecondName() + '@' + emp.getDept() + ".com";
	}

	/**
	 * Generates the password
	 * 
	 * @return password string
	 */
	public static String generatePassword() {
		String str = null;
		// number, capital letter, small letter & special character 8 chars in total
		// 181E@wFT
		int randNum = generateRand(1000, 0);

		String alphaSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] charArr = new char[4];
		for (int i = 0; i <= 3; i++) {
			charArr[i] = alphaSet.charAt(generateRand(alphaSet.length(), 1));
		}

		String symbolSet = "!#$%&'()*+,-./:;<=>?@[\\]^_{|}~";
		char passwordSymbol = symbolSet.charAt(generateRand(symbolSet.length(), 1));

		str = String.valueOf(charArr).substring(0, 2) + String.valueOf(randNum) + passwordSymbol
				+ (String.valueOf(charArr).substring(2, 4)).toLowerCase();
		return str;
	}

	public static void showCredentials(Employee emp) {
		String resStr = "";
		resStr += "Dear "
				+ emp.getFirstName().substring(0,1).toUpperCase() 
				+ emp.getFirstName().substring(1).toLowerCase() 
				+ " your generated credentials are as follows: \n";
		resStr += "Email        --->  " +  emp.getEmailId() + "\n";
		resStr += "Password ---> " + emp.getPassword();
		System.out.println(resStr);
	}
}
