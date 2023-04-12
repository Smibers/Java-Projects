import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> listgen1 = Stream.generate(() -> random.nextInt(100)).limit(100).collect(Collectors.toList());;
        System.out.println(listgen1);
        System.out.println("list printed for reference\n\n\n");

            for (int i=0; i<100;i++){
                System.out.println("spot "+(i+1)+" is: "+ listgen1.get(i));
            }

    }
}