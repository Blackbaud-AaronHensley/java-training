import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.apache.commons.lang3.ArrayUtils;

public class Solution {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        /*
         * Write your code here.
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int counter = 0;

        for(int a : A) {
            pq.add(a);
        }

        while(pq.size() > 1) {
            if(pq.peek() >= k) {
                return counter;
            } else {
                sweetenCookies(pq);
                counter++;
            }
        }

        if(cookiesAreRemainingAndAreSweetEnough(k, pq)) {
            return counter;
        } else {
            return -1;
        }
    }

    private static boolean cookiesAreRemainingAndAreSweetEnough(int k, PriorityQueue<Integer> pq) {
        return pq.size() > 0 && pq.peek() >= k;
    }

    private static void sweetenCookies(PriorityQueue<Integer> pq) {
        int cookie1 = pq.poll();
        int cookie2 = pq.poll();
        int newCookie = cookie1 + cookie2 * 2;
        pq.add(newCookie);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
