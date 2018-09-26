import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        //This method is passed a list of sequences (a list of a list of integers) and prints out
        //an integer if the query is of a particular type otherwise it adds an integer to one of the sequences if
        //the query is of a different type.
        //The first line of integers contains two space-separated integers,
        //N (the number of sequences you will create)
        //and Q (the number of queries to be executed on the input to create the sequences)
        //Each subsequent line is three space-separated integers where the first value determines
        //which query type to execute (1 or 2) which will then use the second two values (a 1 or 2 for
        //the second value and any integer for the third) to manipulate the sequence list you are
        //building which is determined by the query used.

        int lastAnswer = 0;
        List<List<Integer>> tracker = new ArrayList<List<Integer>>(n);
        List<Integer> resultList = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            tracker.add(new ArrayList<Integer>());
        }

        for (List<Integer> list : queries) {
            int query = list.get(0);
            int x = list.get(1);
            int y = list.get(2);
            int whichSequence = (x ^ lastAnswer) % n;

            if (query == 1) {
                tracker.get(whichSequence).add(y);
            } else {
                int size = tracker.get(whichSequence).size();
                lastAnswer = tracker.get(whichSequence).get(y % size);
                resultList.add(lastAnswer);
            }
        }

        return resultList;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
