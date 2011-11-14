package controller;
public class Validate {


	public static boolean stringNonEmpty(String text){
<<<<<<< HEAD
		if(text.equals(""))
=======
		
		if(text.equals("") || text == null)
>>>>>>> david/receipt
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
<<<<<<< HEAD

	public static boolean stringOnlyCharacters(String text){
=======
	
	public static boolean stringNotLeagal(String text){
		
		
>>>>>>> david/receipt
		for(int i = 0; i < text.length(); i++){
			char cha = text.charAt(i);
			if(!((cha >= 'A' && cha <= 'Z') || (cha >= 'a' && cha <= 'z')) )
				return false;
			
		}
		return true;
	}
<<<<<<< HEAD
	
	public static boolean stringLegal(String text){
		for (int i = 0; i < text.length(); i++) {
			int cha = (int)text.charAt(i);
			if(cha<32 || cha > 255){
				return false;
			}
		}
		return true;
	}


=======
>>>>>>> david/receipt
}
