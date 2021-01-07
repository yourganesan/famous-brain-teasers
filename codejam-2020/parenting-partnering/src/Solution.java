import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) {
        try {
            solveParentingPartneringProblem();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solveParentingPartneringProblem() throws IOException {

        //File file = new File("input.txt");
        //BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        int noOfTests = Integer.parseInt(reader.readLine());

        for (int testCounter = 0; testCounter < noOfTests; testCounter++) // test case loop
        {
            String line = reader.readLine();

            System.out.println("Case #"+(testCounter+1)+": ");
        }
    }
}
