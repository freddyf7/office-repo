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
public class Day7_1 {

    private static String FILE_PATH = "C:\\Users\\freddy\\Devel\\IdeaProjects\\office-repo\\advent-of-code\\advent-of-code-2016\\resource\\Input_Day7_1";
    private static String PATTERN = "(\\w+)(\\[\\w*\\])*";

    public static void main(String[] args) {

        int validCounter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    boolean isValid = false;
                    Pattern r = Pattern.compile(PATTERN);
                    Matcher m = r.matcher(line);

                    while(m.find()) {
                        if(m.group(1) != null && !m.group(1).isEmpty()){
                            String content = m.group(1);
                            if(hasMirroredStrings(content)){
                                isValid = true;
                            }
                        }
                        if(m.group(2) != null && !m.group(2).isEmpty()){
                            String bracketsContent = m.group(2);
                            bracketsContent = bracketsContent.replace("[", "");
                            bracketsContent = bracketsContent.replace("]", "");

                            if(hasMirroredStrings(bracketsContent)){
                                isValid = false;
                                break;
                            }
                        }

                    }

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

    private static boolean hasMirroredStrings(String value){

        for (int i = 0; i < value.length() ; i++) {
            if(i + 3 >= value.length()){
                break;
            }
            if((value.charAt(i) == value.charAt(i + 3)) && (value.charAt(i + 1) == value.charAt(i + 2)) && (value.charAt(i) != value.charAt(i + 1))){
                return true;
            }
        }

        return false;
    }


}
