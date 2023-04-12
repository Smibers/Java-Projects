import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {




        int[][] myArray = {{34,89},{56,3},{27,61},{45,8},{45,89}};

        Stream.of(myArray).flatMapToInt(e-> IntStream.of(e)).distinct().sorted().forEach(e-> System.out.print(e+", "));



    }
//        int[][] myArray = new int[10][2];
//        Random random = new Random();
//        List<Integer> listgen1 = Stream.generate(() -> random.nextInt(100)).limit(10).collect(Collectors.toList());
//        List<Integer> listgen2 = Stream.generate(() -> random.nextInt(100)).limit(10).collect(Collectors.toList());
//
//        for (int i = 0; i < myArray.length; i++) {
//            for (int j = 0; j < myArray[i].length; j++) {
//                myArray[i][j] = listgen1.get(i) + listgen2.get(j);
//            }
//        }
//
//        for (int i = 0; i < myArray.length; i++) {
//            System.out.print("{");
//            for (int j = 0; j < myArray[i].length; j++) {
//                System.out.print(myArray[i][j] +",");
//            }
//            System.out.print( "}, ");
//        }
//
//        System.out.println(listgen2);
//        System.out.println(listgen1);
//    }
}