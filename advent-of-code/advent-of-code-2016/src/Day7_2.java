import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by freddy on 04/12/2016.
 */
public class Day7_2 {

    private static String FILE_PATH = "C:\\Users\\freddy\\Devel\\IdeaProjects\\office-repo\\advent-of-code\\advent-of-code-2016\\resource\\Input_Day7_1";
    private static String SPLIT_PATTERN = "(\\w+)(\\[\\w*\\])*";

    public static void main(String[] args) {

        int validCounter = 0;
        Set<String> mirroredStrings  = new HashSet<>();
        List<String> bracketStrings = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    boolean isValid = false;

                    Pattern splitPattern = Pattern.compile(SPLIT_PATTERN);
                    Matcher splitMatcher = splitPattern.matcher(line);

                    // Fill list with strings that match and list with bracket text for posterior comparison
                    while(splitMatcher.find()) {

                        if(splitMatcher.group(1) != null && !splitMatcher.group(1).isEmpty()) {
                            String testString = splitMatcher.group(1);
                            String[] matchedValues = getMatchingABAs(testString);
                            mirroredStrings.addAll(Arrays.asList(invertMatchingABAs(matchedValues)));
                        }

                        if(splitMatcher.group(2) != null && !splitMatcher.group(2).isEmpty()){
                            bracketStrings.add(splitMatcher.group(2));
                        }
                    }

                    for (String invertedString:mirroredStrings) {
                        for (String bracketString:bracketStrings) {
                            if(bracketString.contains(invertedString)){
                                isValid = true;
                                break;
                            }
                        }
                    }

                    mirroredStrings.clear();
                    bracketStrings.clear();

                    if(isValid){
                        validCounter += 1;
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

        System.out.println("Valid IPs: " + validCounter);

    }

    private static String[] getMatchingABAs(String value){

        List<String> result = new ArrayList<>();

        for (int i = 0; i < value.length(); i++) {
            if(i + 2 >= value.length()){
                break;
            }
            if(value.charAt(i) == value.charAt(i + 2) && value.charAt(i) != value.charAt(i + 1)){
                char[] chars = {value.charAt(i), value.charAt(i + 1), value.charAt(i + 2)};
                String match = String.valueOf(chars);
                result.add(match);
            }
        }

        return result.toArray(new String[result.size()]);
    }

    private static String[] invertMatchingABAs(String[] matchedValues){
        for (int i = 0; i < matchedValues.length ; i++) {
            matchedValues[i] = invertABA(matchedValues[i]);
        }

        return matchedValues;
    }

    private static String invertABA(String value){
        char[] chars = {value.charAt(1), value.charAt(0), value.charAt(1)};
        String result = String.valueOf(chars);
        return result;
    }

}
