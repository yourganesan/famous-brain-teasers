import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution
{
    public static void main(String[] args) {
        try {
            findTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findTrace() throws IOException {

        //File file = new File("vestigium-input.txt");
        //BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        int noOfTests = Integer.parseInt(reader.readLine());

        for (int testCounter = 0; testCounter < noOfTests; testCounter++) // test case loop
        {
            int size = Integer.parseInt(reader.readLine());
            int diagonalSum = 0;
            int rowDuplicateCounter = 0;
            int columnDuplicateCounter = 0;
            Map<Integer, Set<Integer>> columnMap = new HashMap<>();
            Map<Integer, Boolean> columnDuplicatesMap = new HashMap<>();

            for (int rowCounter = 0; rowCounter < size; rowCounter++) // row loop
            {
                String rowStr = reader.readLine();
                String[] rowStrArr = rowStr.split(" ");
                Set<Integer> rowSet = new HashSet<>();

                boolean rowDuplicateFound = false;
                for (int columnCounter = 0; columnCounter < rowStrArr.length; columnCounter++) // column loop //rowStrArr.length will also be equal to size
                {
                    int value = Integer.parseInt(rowStrArr[columnCounter]);

                    if(!rowDuplicateFound && rowSet.contains(value))
                    {
                        rowDuplicateCounter++;
                        rowDuplicateFound = true;
                    }
                    else
                        rowSet.add(value);

                    Set<Integer> columnSet = columnMap.get(columnCounter);
                    if(columnSet == null)
                        columnSet = new HashSet<>();

                    boolean columnDuplicateFound = columnDuplicatesMap.get(columnCounter) != null && columnDuplicatesMap.get(columnCounter);
                    if(!columnDuplicateFound && columnSet.contains(value))
                    {
                        columnDuplicateCounter++;
                        columnDuplicatesMap.put(columnCounter, true);
                    }
                    else
                    {
                        columnSet.add(value);
                    }

                    columnMap.put(columnCounter, columnSet);

                    if(rowCounter == columnCounter)
                        diagonalSum = diagonalSum + value;
                }
            }
            System.out.println("Case #"+(testCounter+1)+": "+diagonalSum+" "+rowDuplicateCounter+" "+columnDuplicateCounter);
        }
    }
}
