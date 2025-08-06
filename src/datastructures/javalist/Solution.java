package datastructures.javalist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n < 1 || n > 4000) {
            throw new IllegalArgumentException("The entry isn't an integer between 1 and 4000");
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            } else {
                throw new IllegalArgumentException("The entry isn't an integer");
            }
        }

        int q = scanner.nextInt();

        if (q < 1 || q > 4000) {
            throw new IllegalArgumentException("The entry isn't an integer between 1 and 4000");
        }

        for (int i = 0; i < q; i++) {
            String queryType = scanner.next().trim();

            if ("insert".equalsIgnoreCase(queryType)) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (x < 0 || x > list.size()) {
                    throw new IllegalArgumentException("Insert index out of bounds");
                }

                list.add(x, y);

            } else if ("delete".equalsIgnoreCase(queryType)) {
                int x = scanner.nextInt();

                if (x < 0 || x >= list.size()) {
                    throw new IllegalArgumentException("Delete index out of bounds");
                }

                list.remove(x);
            } else {
                throw new IllegalArgumentException("Unknown query type: " + queryType);
            }
        }

        for (int number : list) {
            System.out.print(number + " ");
        }
        scanner.close();
    }
}