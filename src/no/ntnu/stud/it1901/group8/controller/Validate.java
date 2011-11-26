package no.ntnu.stud.it1901.group8.controller;

/**
 * A class with methods for validating input data.
 */
public class Validate {

	/**
	 * Checks whether string is empty or not
	 * 
	 * @param text
	 *            is the string to be checked
	 * @return true if there is a string and false if there is none.
	 */
	public static boolean stringNonEmpty(String text) {
		if (text.equals("") || text == null)
			return false;
		return true;
	}

	/**
	 * Checks whether string contains a number
	 * 
	 * @param text
	 *            is the string to be checked
	 * @return true if string contains numbers and false if it contains no
	 *         numbers.
	 */
	public static boolean stringContainsNumb(String text) {
		for (int i = 0; i < text.length(); i++) {
			int cha = (int) text.charAt(i);
			if (cha >= 48 && cha <= 57) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether the given string is a valid zipcode.
	 * 
	 * @param text
	 *            is the string to be checked
	 * @return true if string is a valid zip code and false if it is not valid.
	 */
	public static boolean isZipCode(String text) {
		if (text.length() != 4) {
			return false;
		}
		for (int i = 0; i < text.length(); i++) {
			int cha = (int) text.charAt(i);
			if (cha < 48 || cha > 57) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks whether string only constitutes of integers.
	 * 
	 * @param text
	 *            is the string to be checked
	 * @return true if string contains only numbers, and false otherwise
	 */
	public static boolean isStringOnlyNumbers(String text) {
		for (int i = 0; i < text.length(); i++) {
			int cha = (int) text.charAt(i);
			if (!(cha >= 48 && cha <= 57))
				return false;
		}
		return true;
	}

	/**
	 * Checks whether string contains any illegal characters
	 * 
	 * @param text
	 *            is the string to be checked
	 * @return true if there is a string and false if there is none.
	 */
	public static boolean isStringLegal(String text) {
		for (int i = 0; i < text.length(); i++) {
			int cha = (int) text.charAt(i);
			if (cha < 32 || cha > 255) {
				return false;
			}
		}
		return true;
	}

}
