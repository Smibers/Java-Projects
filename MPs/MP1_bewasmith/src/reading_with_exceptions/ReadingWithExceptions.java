package reading_with_exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadingWithExceptions {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s);
            process(s);
        }


    }

    public static void process(String inputFilename) {
        try (Scanner scanner = new Scanner(new File(inputFilename))) {
            int i;
            int numberRead = -1;
            String outputFile = scanner.next();
            try {
                numberRead = scanner.nextInt();
            } catch (InputMismatchException e) {

            }
            int count = 0;
            System.out.println(inputFilename);
            try (PrintWriter printWriter = new PrintWriter(outputFile)) {
                while ((numberRead < 0 || count < numberRead) && scanner.hasNext()) {
                    try {
                        i = scanner.nextInt();
                        printWriter.print(i + " ");
                        count++;
                    } catch (InputMismatchException e) {
                        String baddata = scanner.next();
                        System.out.println("bad data: " + baddata);
                        continue;
                    }

                    if (count % 10 == 0) {
                        printWriter.println("");
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("file " + inputFilename + " not found");

        }
        System.out.println();
    }
}
