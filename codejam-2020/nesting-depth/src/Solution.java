import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) {
        try {
            testNestingDepthProblem();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testNestingDepthProblem() throws IOException {

        //File file = new File("input.txt");
        //BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // Reading data using readLine
        int noOfTests = Integer.parseInt(reader.readLine());

        for (int testCounter = 0; testCounter < noOfTests; testCounter++) // test case loop
        {
            String line = reader.readLine();
            char[] inputArr = line.toCharArray();
            int previous = 0;
            StringBuilder outputBuilder = new StringBuilder();
            // char arr loop
            for (char c : inputArr)
            {
                int value = Integer.parseInt(String.valueOf(c));

                if (previous < value) {
                    int diff = value - previous;
                    for (int k = 0; k < diff; k++) {
                        outputBuilder.append("(");
                    }
                }
                if (previous > value) {
                    int diff = previous - value;
                    for (int k = 0; k < diff; k++) {
                        outputBuilder.append(")");
                    }
                }

                outputBuilder.append(value);
                previous = value;
            }

            for (int k = 0; k < previous; k++) {
                outputBuilder.append(")");
            }
            System.out.println("Case #"+(testCounter+1)+": "+outputBuilder.toString());
        }
    }
}
