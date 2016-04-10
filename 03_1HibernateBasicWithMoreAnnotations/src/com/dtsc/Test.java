package com.dtsc;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double value = 125.6789;
		
		Locale locale = new Locale("JP", "");
		Currency currency = Currency.getInstance("JPY");
		
		NumberFormat format = NumberFormat.getInstance();
		format.setCurrency(currency);
		String result = format.format(value);
		
		
		System.out.println("Result : " + result);
		

	}

}
