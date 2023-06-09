import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] list = {"Java", "program", "list", "string", "unix", "hours", "syntax", "error"};
        System.out.println("top three words are: ");
        Stream.of(list).sorted((e1,e2)->wordScore(e2)-wordScore(e1)).limit(3).forEach(e-> System.out.println(e+": "+wordScore(e)));
        double average=Stream.of(list).mapToInt(e->wordScore(e)).average().getAsDouble();
        System.out.println("average: "+average);
        Stream.of(list).collect(Collectors.groupingBy(e->wordScore(e)>average)).forEach((a,b)-> System.out.println((a? "above average: ": "below average")+":"+b));
    }
    public static int wordScore(String word){
        word=word.toLowerCase();
        Map<Character, Integer> letterValues = new HashMap();
        letterValues.put('a', 1);
        letterValues.put('b', 3);
        letterValues.put('c', 3);
        letterValues.put('d', 2);
        letterValues.put('e', 1);
        letterValues.put('f', 4);
        letterValues.put('g', 2);
        letterValues.put('h', 4);
        letterValues.put('i', 1);
        letterValues.put('j', 8);
        letterValues.put('k', 5);
        letterValues.put('l', 1);
        letterValues.put('m', 3);
        letterValues.put('n', 1);
        letterValues.put('o', 1);
        letterValues.put('p', 3);
        letterValues.put('q', 10);
        letterValues.put('r', 1);
        letterValues.put('s', 1);
        letterValues.put('t', 1);
        letterValues.put('u', 1);
        letterValues.put('v', 8);
        letterValues.put('w', 4);
        letterValues.put('x', 8);
        letterValues.put('y', 4);
        letterValues.put('z', 10);
        int score = 0;
        for (int i=0;i<word.length();i++){
            score+=letterValues.get(word.charAt(i));
        }
        return score;
    }
}