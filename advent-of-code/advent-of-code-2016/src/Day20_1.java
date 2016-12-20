import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Created by Freddy on 12/20/2016.
 */
public class Day20_1 {

    private static String FILE_PATH = "C:\\Users\\freddy\\IdeaProjects\\office-repo\\advent-of-code\\advent-of-code-2016\\resource\\Input_Day20_1";
    private static String PATTERN = "(\\d+)-(\\d+)";

    public static void main(String[] args) {

        List<String[]> ranges = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            try {
                while ((line = br.readLine()) != null) {

                    Pattern r = Pattern.compile(PATTERN);
                    Matcher m = r.matcher(line);

                    if (m.find( )) {
                        String[] range = {m.group(1), m.group(2)};
                        ranges.add(range);
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
        System.out.println("File Loaded");
        long minValue = 4294967295L;
        int numberOfValidIps = 0;

        for (long i = 0; i <= 4294967295L; i++) {
            boolean isValid = true;
            for (String[] range:ranges) {
                long rangeMin = Long.valueOf(range[0]);
                long rangeMax = Long.valueOf(range[1]);

                if(i >= rangeMin && i <= rangeMax){
                    isValid = false;
                    i = rangeMax;
                    break;
                }
            }

            if(isValid){
                numberOfValidIps += 1;
                if(i < minValue){
                    minValue = i;
                }
            }
        }
        
        System.out.println("Min IP: " + minValue);
        System.out.println(numberOfValidIps);
    }

}
