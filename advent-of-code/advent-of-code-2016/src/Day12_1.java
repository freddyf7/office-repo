import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Freddy on 12/23/2016.
 */
public class Day12_1 {

    private static String FILE_PATH = "C:\\Users\\freddy\\IdeaProjects\\office-repo\\advent-of-code\\advent-of-code-2016\\resource\\Input_Day12_1";
    private static String COPY_PATTERN = "cpy (\\w+) (\\w+)";
    private static String INCREASE_PATTERN = "inc (\\D+)";
    private static String DECREASE_PATTERN = "dec (\\D+)";
    private static String JUMP_PATTERN = "jnz (\\w+) (-?\\d+)";

    public static void main(String[] args) {

        List<String> instructions = new ArrayList<>();
        Map<String, Integer> registers = new HashMap<>();

        registers.put("a", 0);
        registers.put("b", 0);
        registers.put("c", 0);
        // Part 2
        //registers.put("c", 1);
        registers.put("d", 0);

        // Read file and save instructions
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    instructions.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;
        while(i < instructions.size()){

            boolean jump = false;
            String instruction = instructions.get(i);

            if(instruction.contains("cpy")){
                Pattern p = Pattern.compile(COPY_PATTERN);
                Matcher m = p.matcher(instruction);

                if(m.find()) {
                    String targetRegister = m.group(2);
                    String valueRecipient = m.group(1);

                    if (registers.containsKey(valueRecipient)) {
                        Integer newValue = registers.get(valueRecipient);
                        registers.replace(targetRegister, newValue);
                    } else {
                        Integer newValue = Integer.valueOf(valueRecipient);
                        registers.replace(targetRegister, newValue);
                    }
                }
            }

            if(instruction.contains("inc")){
                Pattern p = Pattern.compile(INCREASE_PATTERN);
                Matcher m = p.matcher(instruction);

                if(m.find()) {
                    String targetRegister = m.group(1);

                    Integer newValue = registers.get(targetRegister) + 1;
                    registers.replace(targetRegister, newValue);
                }
            }

            if(instruction.contains("dec")){
                Pattern p = Pattern.compile(DECREASE_PATTERN);
                Matcher m = p.matcher(instruction);

                if(m.find()) {
                    String targetRegister = m.group(1);

                    Integer newValue = registers.get(targetRegister) - 1;
                    registers.replace(targetRegister, newValue);
                }
            }

            if(instruction.contains("jnz")){
                Pattern p = Pattern.compile(JUMP_PATTERN);
                Matcher m = p.matcher(instruction);

                if(m.find()) {
                    String recipientValue = m.group(1);
                    int jumpValue = Integer.valueOf(m.group(2));
                    Integer testValue;

                    if(registers.containsKey(recipientValue)){
                        testValue = Integer.valueOf(registers.get(recipientValue));
                    } else{
                        testValue = Integer.valueOf(recipientValue);
                    }

                    if (testValue != 0) {
                        jump = true;
                        i += jumpValue;
                    }
                }
            }

            if(!jump) {
                i++;
            }
        }

        System.out.println(registers.get("a"));

    }
}
