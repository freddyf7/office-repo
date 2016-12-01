import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by freddy on 30/11/2016.
 */
public class Day16 {

    private static final Pattern PATTERN = Pattern.compile("Sue (?<aunt>[0-9]+):.*");

    private static String FILE_PATH = "C:\\Users\\freddy\\Devel\\IdeaProjects\\office-repo\\java\\advent-of-code\\advent-of-code-2015\\src\\Input_Day16_1";
    private static String CHILDREN = "children";
    private static String CATS = "cats";
    private static String SAMOYEDS = "samoyeds";
    private static String POMERANIANS = "pomeranians";
    private static String AKITAS = "akitas";
    private static String VIZSLAS = "vizslas";
    private static String GOLDFISH = "goldfish";
    private static String TREES = "trees";
    private static String CARS = "cars";
    private static String PERFUMES = "perfumes";

    private static Map auntInfo = new HashMap();

    public static void main (String[] args){

        auntInfo.put(CHILDREN,3);
        auntInfo.put(CATS,7);
        auntInfo.put(SAMOYEDS,2);
        auntInfo.put(POMERANIANS,3);
        auntInfo.put(AKITAS,0);
        auntInfo.put(VIZSLAS,0);
        auntInfo.put(GOLDFISH,5);
        auntInfo.put(TREES,3);
        auntInfo.put(CARS,2);
        auntInfo.put(PERFUMES,1);


        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    Matcher m = PATTERN.matcher(line);
                    System.out.println(m.group("aunt"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
