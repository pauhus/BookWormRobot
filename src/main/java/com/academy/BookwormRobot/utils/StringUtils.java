package com.academy.BookwormRobot.utils;

/**
 * Some usefull methods used to check strings
 * 
 * @author Paulina
 *
 */
public class StringUtils {

	/**
	 * Method which checks if String is null or empty. It helps us to maintain
	 * clean code - we only need to call one method instead of two.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}
		return false;
	}
}
