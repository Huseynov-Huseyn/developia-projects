package ders10;

import java.math.BigDecimal;

public class bigintegerdecimal {
	public static void main(String[] args) {
//		biginteger tam , bigdecimal kesr ededler ucun

		BigDecimal a = new BigDecimal("123124141.412");
		BigDecimal b = new BigDecimal("8606834763.46");

		BigDecimal c = a.multiply(b);
		System.out.println(c);
	}
}
