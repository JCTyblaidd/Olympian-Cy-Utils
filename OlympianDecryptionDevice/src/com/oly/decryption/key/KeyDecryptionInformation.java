package com.oly.decryption.key;

import java.util.HashMap;

public class KeyDecryptionInformation {
	
	public static final String  ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	
	public HashMap<Character,Character> encrypt = new HashMap<Character,Character>();
	
	public KeyDecryptionInformation(String key) {
		char last = ' ';
		for(int v = 0; v < ALPHABET.length(); v++) {
			if(v < key.length()) {
				encrypt.put(ALPHABET.charAt(v),key.charAt(v));
				last = ALPHABET.charAt(v);
			}else {
				char temp = getNextInAlphabet(last);
				while( key.indexOf(temp) == -1 ){
					temp = getNextInAlphabet(temp);
				}
				encrypt.put(ALPHABET.charAt(v),temp);
				last = temp;
			}
		}
	}
	
	private char getNextInAlphabet(char c) {
		int loc = ALPHABET.indexOf(c);
		loc += 1;
		loc = loc % ALPHABET.length();
		return ALPHABET.charAt(loc);
	}
	
	
	
}
