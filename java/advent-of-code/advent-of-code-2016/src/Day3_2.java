import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by freddy on 03/12/2016.
 */
public class Day3_2 {

    private static String FILE_PATH = "C:\\Users\\freddy\\Devel\\IdeaProjects\\office-repo\\java\\advent-of-code\\advent-of-code-2016\\resource\\Input_Day3_1";
    private static String PATTERN = "(\\s+)(?<side1>\\d+)(\\s+)(?<side2>\\d+)(\\s+)(?<side3>\\d+)";

    public static void main(String[] args) {

        int validTriangles = 0;
        ArrayList<ArrayList<Integer>> triangles = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> triangle = new ArrayList<Integer>();
            triangles.add(triangle);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int lineCounter = 0;
            try {
                while ((line = br.readLine()) != null) {
                    lineCounter++;
                    Pattern r = Pattern.compile(PATTERN);
                    Matcher m = r.matcher(line);
                    if (m.find( )) {
                        int side_1 = Integer.parseInt(m.group("side1"));
                        int side_2 = Integer.parseInt(m.group("side2"));
                        int side_3 = Integer.parseInt(m.group("side3"));

                        triangles.get(0).add(side_1);
                        triangles.get(1).add(side_2);
                        triangles.get(2).add(side_3);
                    }else {
                        System.out.println("NO MATCH");
                    }

                    if(lineCounter == 3){

                        for (ArrayList<Integer> triangle:triangles) {
                            int side_1 = triangle.get(0);
                            int side_2 = triangle.get(1);
                            int side_3 = triangle.get(2);

                            if((side_1 + side_2 > side_3) && (side_2 + side_3 > side_1) && (side_1 + side_3 > side_2)){
                                validTriangles++;
                            }

                            triangle.clear();
                        }

                        lineCounter = 0;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Valid Triangles: " + validTriangles);

    }

}
