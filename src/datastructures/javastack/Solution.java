package datastructures.javastack;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here.
        Read input from STDIN.
        Print output to STDOUT.
        Your class should be named Solution.
        */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String bracketsStr = scanner.nextLine();
            if (isValid(bracketsStr)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }

    }

    private static boolean isValid(String bracketsStr) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : bracketsStr.toCharArray()) {
            if (brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != brackets.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
