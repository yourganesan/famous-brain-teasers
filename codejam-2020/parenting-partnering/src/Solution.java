import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        solveProblem(reader);
    }

    private static void solveProblem(BufferedReader reader) throws IOException
    {
        // Reading data using readLine
        int noOfTests = Integer.parseInt(reader.readLine());

        for (int testCounter = 0; testCounter < noOfTests; testCounter++) // test case loop
        {
            int taskCount = Integer.parseInt(reader.readLine());
            Map<String, Pair<Integer, Integer>> parentsEngagementMap = new HashMap<>();
            parentsEngagementMap.put("C", new Pair(0, 0));
            parentsEngagementMap.put("J", new Pair(0, 0));

            String output = "";
            for (int rowCounter = 0; rowCounter < taskCount; rowCounter++) // row loop
            {
                boolean taskAssigned = false;
                String rowStr = reader.readLine();
                String[] rowStrArr = rowStr.split(" ");

                Pair<Integer, Integer> currentTaskTimeRange = new Pair(Integer.parseInt(rowStrArr[0]), Integer.parseInt(rowStrArr[1]));

                for ( String parent : parentsEngagementMap.keySet())
                {
                    Pair<Integer, Integer> currentParentTimeRange = parentsEngagementMap.get(parent);

                    if(currentParentTimeRange.snd <= currentTaskTimeRange.fst || currentParentTimeRange.fst >= currentTaskTimeRange.snd)
                    {
                        parentsEngagementMap.put(parent, currentTaskTimeRange);
                        taskAssigned = true;
                        output = output+parent;
                        break;
                    }
                }
                if(!taskAssigned)
                {
                    output = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #"+(testCounter+1)+": "+output);
        }
    }

    static class Pair<A, B> {
        public final A fst;
        public final B snd;

        public Pair(A var1, B var2) {
            this.fst = var1;
            this.snd = var2;
        }
    }
}

