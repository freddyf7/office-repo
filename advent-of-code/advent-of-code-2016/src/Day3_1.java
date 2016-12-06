import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by freddy on 03/12/2016.
 */
public class Day3_1 {

    private static String FILE_PATH = "C:\\Users\\freddy\\Devel\\IdeaProjects\\office-repo\\java\\advent-of-code\\advent-of-code-2016\\resource\\Input_Day3_1";
    private static String PATTERN = "(\\s+)(?<side1>\\d+)(\\s+)(?<side2>\\d+)(\\s+)(?<side3>\\d+)";

    public static void main(String[] args) {

        int validTriangles = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            try {
                while ((line = br.readLine()) != null) {

                    Pattern r = Pattern.compile(PATTERN);
                    Matcher m = r.matcher(line);
                    if (m.find( )) {
                        int side_1 = Integer.parseInt(m.group("side1"));
                        int side_2 = Integer.parseInt(m.group("side2"));
                        int side_3 = Integer.parseInt(m.group("side3"));

                        if((side_1 + side_2 > side_3) && (side_2 + side_3 > side_1) && (side_1 + side_3 > side_2)){
                            validTriangles++;
                        }


                    }else {
                        System.out.println("NO MATCH");
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
