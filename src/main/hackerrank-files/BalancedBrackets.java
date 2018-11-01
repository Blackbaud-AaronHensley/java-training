import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // character is one of the three opening brackets
            if (characterIsABracketType) {
                stack.push(c);
            }
            // character is one of the three closing brackets
            else {
                if (stackNotEmptyAndTopOfStackMatchesItsOpeningBracket(stack, c)) {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    private static boolean characterIsABracketType(String c) {
        return (c == '[' || c == '{' || c == '(');
    }


    private static boolean stackNotEmptyAndTopOfStackMatchesItsOpeningBracket(Stack<Character> stack, char c) {
        return !stack.isEmpty() && stack.peek() == getOpeningBracket(c);
    }

    private static Character getOpeningBracket(Character closingBracket) {
        Character openingBracket = null;
        if (closingBracket == ']') {
            openingBracket = '[';
        } else if (closingBracket == '}') {
            openingBracket = '{';
        } else if (closingBracket == ')') {
            openingBracket = '(';
        }
        return openingBracket;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
