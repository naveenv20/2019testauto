package com.qtpselenium.hybrid.examplecode;



import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.openqa.selenium.firefox.FirefoxDriver;

public class EncryptDecrypt {

	public static void main(String[] args) {
		String mypassword="passpasspass";
		
		byte[] message = mypassword.getBytes(StandardCharsets.UTF_8);
		String encoded = Base64.getEncoder().encodeToString(message);
		System.out.println(encoded);
		
		
		byte[] decoded = Base64.getDecoder().decode(encoded);
		System.out.println(new String(decoded, StandardCharsets.UTF_8));
	}

}
