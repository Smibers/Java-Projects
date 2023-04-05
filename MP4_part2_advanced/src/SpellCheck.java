import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SpellCheck {
    // We could have also used TreeSet for the dictionary
    private HashSet<String> dictionary = new HashSet<String>();
    private TreeSet<String> miss_spelled_words = new TreeSet<String>();

    public SpellCheck() throws FileNotFoundException {
        // Add all of the words from "dictionary.txt" to the dictionary HashSet
        Scanner scan = new Scanner(new File("Dictionary.txt"));
        while(scan.hasNextLine()){
            String word = scan.next();
            dictionary.add(word.toLowerCase());
        }
        scan.close();
    }

    public void checkSpelling(String fileName) throws FileNotFoundException {
        System.out.println("======== Spell checking " + fileName + " =========");
        // Clear miss_spelled_words
        miss_spelled_words.clear();
        Scanner fileInput = new Scanner(new File(fileName));
        Scanner secondinput = new Scanner(System.in);
        // Read in each line from "fileName"
        int linenum = 0;
        boolean print;
        while (fileInput.hasNextLine()) {
           String[] words = fileInput.nextLine().split(" +|\\p{Punct}");
           print = true;
           for(String word : words){
               if(word.isEmpty()){
                   continue;
               }
               word=word.toLowerCase();
               if(!Character.isLetter(word.charAt(0))){
                   continue;
               }
               if (dictionary.contains(word)||miss_spelled_words.contains(word)){
                   continue;
               }
               if(word.endsWith("s")){

                   word=word.substring(0,word.length()-1);
                   if(dictionary.contains(word)||miss_spelled_words.contains(word)){
                       continue;
                   }
               }
               if(print){
                   System.out.println("line number: "+linenum );
                   print=false;

               }
               System.out.println(word+" add to dictionary? y or n");
               if(secondinput.nextLine().charAt(0)=='y'){
                   dictionary.add(word);
               }
               else{
                   miss_spelled_words.add(word);
               }
           }
           linenum++;
        }
        fileInput.close();


    }

    public void dump_miss_spelled_words() {
        // Print out the miss-spelled words
        System.out.println("======miss spelled words======");
        for(String word : miss_spelled_words){
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        try {
            SpellCheck spellCheck = new SpellCheck();

            for (int i = 0; i < args.length; i++) {
                spellCheck.checkSpelling(args[i]);
                spellCheck.dump_miss_spelled_words();
            }
        } catch (
                FileNotFoundException e) {
            System.out.println(e);
        }
    }
}