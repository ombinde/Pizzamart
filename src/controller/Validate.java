package controller;
public class Validate {

	/**
	 * Checks whether string is empty or not
	 * @param text string to be checked
	 * @return true if there is a string and false if there is none.
	 */
	public static boolean stringNonEmpty(String text){
		if(text.equals("") || text == null)
			return false;
		return true;
	}
	
	/**
	 * Checks whether string contains a number
	 * @param text string to be checked
	 * @return true if there is a string and false if there is none.
	 */
	public static boolean stringContainsNumb(String text){
		for(int i = 0; i < text.length(); i++){
			int cha = (int)text.charAt(i);
			if(cha >= 48 && cha <= 57){
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
	public static boolean stringOnlyNumb(String text){
		for(int i = 0; i < text.length(); i++){
			int cha = (int)text.charAt(i);
			if(!(cha >= 48 && cha <= 57))
				return false;
		}
		return true;
	}

	//public static boolean stringOnlyCharacters(String text){
	/**
	 * 
	 * @param text
	 * @return
	 */
	public static boolean stringNotLeagal(String text){
		for(int i = 0; i < text.length(); i++){
			char cha = text.charAt(i);
			if(!((cha >= 'A' && cha <= 'Z') || (cha >= 'a' && cha <= 'z')) )
				return false;
			
		}
		return true;
	}
	/**
	 * 
	 * @param text
	 * @return
	 */
	public static boolean stringLegal(String text){
		for (int i = 0; i < text.length(); i++) {
			int cha = (int)text.charAt(i);
			if(cha<32 || cha > 255){
				return false;
			}
		}
		return true;
	}

}
