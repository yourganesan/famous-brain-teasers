import com.sun.tools.javac.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionWithFileInput
{
    public static void main(String[] args) {
        try {
            solveParentingPartneringProblem();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solveParentingPartneringProblem() throws IOException {

        File file = new File("input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        // Reading data using readLine
        int noOfTests = Integer.parseInt(reader.readLine());

        for (int testCounter = 0; testCounter < noOfTests; testCounter++) // test case loop
        {
            int taskCount = Integer.parseInt(reader.readLine());
            Map<String, Pair<Integer, Integer>> parentsEngagementMap = new HashMap<>();
            parentsEngagementMap.put("C", Pair.of(0, 0));
            parentsEngagementMap.put("J", Pair.of(0, 0));

            String output = "";
            for (int rowCounter = 0; rowCounter < taskCount; rowCounter++) // row loop
            {
                boolean taskAssigned = false;
                String rowStr = reader.readLine();
                String[] rowStrArr = rowStr.split(" ");

                Pair<Integer, Integer> currentTaskTimeRange = Pair.of(Integer.parseInt(rowStrArr[0]), Integer.parseInt(rowStrArr[1]));

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
                    //System.out.println("IMPOSSIBLE");
                    output = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #"+(testCounter+1)+": "+output);
        }
    }
}
