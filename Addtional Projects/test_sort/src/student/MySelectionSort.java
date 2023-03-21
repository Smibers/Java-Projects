package student;

import java.util.ArrayList;

public class MySelectionSort {

    public static <T extends Comparable> ArrayList<T> sort(ArrayList<T> input){
        for(int i = 0; i < input.size(); i++){
            int smallest = i;
            for(int j = i; j < input.size() - 1; j++){
                if(input.get(smallest).compareTo(input.get(j+1)) > 0){
                    smallest = j + 1;
                }
            }
            T temp = input.get(i);
            input.set(i, input.get(smallest));
            input.set(smallest, temp);
        }
        return input;
    }
}

