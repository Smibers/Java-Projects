package stringMethod;
import java.util.Scanner;
public class StringMethod {

	public static int countOccurences(String str, String str2) {
		int count = 0;
		int bigcount = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = 1; j <str2.length(); j++) {
				if (str.charAt(i + (j - 1)) == str2.charAt(j-1)) {
					count++;
					
				} else if(str.charAt(i + (j - 1)) != str2.charAt(j-1)) {
					count = 0;
				};
				if (count++ == str2.length()) {
						bigcount++;
				};
			}
		}
		return bigcount;
	}
	public static int countUppercase(String str) {
		int upperCase = 0;
		 for (int i = 0; i < str.length(); i++)
		 {
			 if (Character.isUpperCase(str.charAt(i)))
				 upperCase++;
		 }
		 return upperCase;
	}
	
	public static String pigLatin(String str){
		char cha='a';
		int subval = 0;
		 for (int i = 0; i < str.length(); i++)
		 {
			 cha=str.charAt(i);
			 if (cha == 'a' || cha == 'e' ||cha == 'i' || cha == 'o' || cha == 'u')  {
				 subval=i;
				 i=str.length();
				 
			 }
		 }  
		 
		  return str.substring(subval)+str.substring(0,subval)+"ay";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("what would you like your sentamce to be");
		String sentence = scan.nextLine();
		System.out.println("what word are you looking for in this sentance?");
		String word =scan.nextLine();
		System.out.println("what sentance would you like to look for upper cases in?");
		String upper=scan.nextLine();
		System.out.println("what word would you like to turn into piglatin?");
		String pig = scan.nextLine();
				
		System.out.println(word+ " has appeared " + countOccurences(sentence,word)+ " times in your sentence.");
		System.out.println("There are "+ countUppercase(upper)+ " capitals in the '"+upper+"'" );
		System.out.println("your new word is "+pigLatin(pig));
 
	}
	 


}
