package alphabet;

public class alphabet {

public static void main(String[] args) {	
			String letterout = "";
			String letter = "abcdefghijklmnopqrstuvwxyz";
			for (int i =0 ; i<=25 ; i++) {
				letterout = switch (letter.charAt(i)) {
				case 'a' -> ""+letter.charAt(i)+" is a vowel";
				case 'e' -> ""+letter.charAt(i)+" is a vowel";
				case 'i' -> ""+letter.charAt(i)+" is a vowel";
				case 'o' -> ""+letter.charAt(i)+" is a vowel";
				case 'u' -> ""+letter.charAt(i)+" is a vowel";
				default -> ""+letter.charAt(i)+" is a consonant";
				};
				System.out.println(letterout);
			}
			
			

	}

}
