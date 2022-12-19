package datastructures.javaarraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            scanner.nextLine();
            if(n < 1 || n > 20000) {
                printErrorAndExit();
            }
            List<List<Integer>> dLines = readLines(scanner, n);
            validateDLines(dLines);
            int q = scanner.nextInt();
            scanner.nextLine();
            if (q < 1 || q > 1000) {
                printErrorAndExit();
            }
            List<List<Integer>> qLines = readLines(scanner, q);
            validateQLines(qLines, n);
            applyQueries(dLines, qLines);
        } catch (Exception e) {
            printErrorAndExit();
        }
    }

    private static void applyQueries(List<List<Integer>> dLines, List<List<Integer>> qLines) {
        qLines.forEach(qLine -> {
            int x = qLine.get(0) - 1;
            int y = qLine.get(1);
            try {
                List<Integer> dLine = dLines.get(x);
                System.out.println(dLine.get(y));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        });
    }

    private static void validateQLines(List<List<Integer>> qLines, int n) {
        qLines.forEach(qLine -> {
            if (qLine.size() != 2) {
                printErrorAndExit();
            }
            for(int i = 0; i < qLine.size(); i++) {
                int x = qLine.get(0);
              if (x < 1 || x > n) {
                  printErrorAndExit();
              }
            }
           }
        );
    }

    private static List<List<Integer>> readLines(Scanner scanner, int lineNum) {
        List<List<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < lineNum; i++) {
            String line = scanner.nextLine();
            lines.add(Arrays.stream(line.split(" "))
                    .map(value -> Integer.parseInt(value)).collect(Collectors.toList()));
        }
        return lines;
    }

    private static void printErrorAndExit() {
        System.out.println("ERROR!");
        System.exit(1);
    }

    private static void validateDLines(List<List<Integer>> dLines) {
        dLines.forEach(dLine ->
            dLine.forEach( d -> {
                if (d < 0 || d > 50000) {
                    printErrorAndExit();
                }
            })
        );
    }

}
