package controller;
public class Validate {


	public static boolean stringNonEmpty(String text){
		if(text.equals(""))
			return false;
		return true;
	}

	public static boolean stringContainsNumb(String text){
		for(int i = 0; i < text.length(); i++){
			int cha = (int)text.charAt(i);
			if(cha >= 48 && cha <= 57){
				return true;
			}
		}
		return false;
	}

	public static boolean stringOnlyNumb(String text){
		for(int i = 0; i < text.length(); i++){
			int cha = (int)text.charAt(i);
			if(!(cha >= 48 && cha <= 57))
				return false;
		}
		return true;
	}

	public static boolean stringOnlyCharacters(String text){
		for(int i = 0; i < text.length(); i++){
			int cha = (int)text.charAt(i);
			if(!(cha >= 65 && cha <= 90) || !(cha >= 97 && cha <= 122))
				return false;
		}
		return true;
	}
	
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
