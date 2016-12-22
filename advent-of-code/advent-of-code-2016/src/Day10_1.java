import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Freddy on 12/22/2016.
 */
public class Day10_1 {

    private static String FILE_PATH = "C:\\Users\\freddy\\IdeaProjects\\office-repo\\advent-of-code\\advent-of-code-2016\\resource\\Input_Day10_1";
    private static String VALUE_PATTERN = "value (\\d+) goes to bot (\\d+)";
    private static String INSTRUCTION_PATTERN = "bot (?<bot>\\d+) gives (low|high) to (bot (?<lowBotTarget>\\d+)|output (?<lowOutputTarget>\\d+)) and (low|high) to (bot (?<highBotTarget>\\d+)|output (?<highOutputTarget>\\d+))";

    public static void main(String[] args) {

        Map<Integer, Bot> bots = new HashMap<>();
        Map<Integer, Integer> outputs = new HashMap<>();

        // Read file and load chips and instructions to each bot
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            try {

                while ((line = br.readLine()) != null) {

                    if(line.contains("value")){
                        Pattern p = Pattern.compile(VALUE_PATTERN);
                        Matcher m = p.matcher(line);

                        if(m.find()){
                            int chipValue = Integer.valueOf(m.group(1));
                            int botValue = Integer.valueOf(m.group(2));
                            saveChipToBot(bots, chipValue, botValue);
                        }
                    }

                    if(line.contains("gives low")){
                        Pattern p = Pattern.compile(INSTRUCTION_PATTERN);
                        Matcher m = p.matcher(line);

                        if(m.find()){
                            int botValue = Integer.valueOf(m.group("bot"));
                            saveInstructionToBot(bots, line, botValue);
                        }
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

        // Look for bot with both values (low & high)
        Bot bot = getInitialBot(bots);

        if(bot != null){
            if(bot.getInstruction() != null){
                processInstruction(bots, outputs, bot);
            }
        }

        System.out.println("Part 2: " + outputs.get(0)*outputs.get(1)*outputs.get(2));
    }

    private static void processInstruction(Map<Integer, Bot> bots, Map<Integer, Integer> outputs, Bot bot) {

        Pattern p = Pattern.compile(INSTRUCTION_PATTERN);
        Matcher m = p.matcher(bot.getInstruction());

        if(m.find()) {
            if (m.group("lowBotTarget") != null && !m.group("lowBotTarget").isEmpty()) {
                int lowBotTargetId = Integer.valueOf(m.group("lowBotTarget"));
                giveChipToBot(lowBotTargetId, bot.getLow(), bots, outputs);
                bot.setLow(0);
            }

            if (m.group("lowOutputTarget") != null && !m.group("lowOutputTarget").isEmpty()) {
                int lowOutputTargetId = Integer.valueOf(m.group("lowOutputTarget"));
                putChipInOutput(lowOutputTargetId, bot.getLow(), outputs);
                bot.setLow(0);
            }

            if (m.group("highBotTarget") != null && !m.group("highBotTarget").isEmpty()) {
                int highBotTargetId = Integer.valueOf(m.group("highBotTarget"));
                giveChipToBot(highBotTargetId, bot.getHigh(), bots, outputs);
                bot.setHigh(0);
            }

            if (m.group("highOutputTarget") != null && !m.group("highOutputTarget").isEmpty()) {
                int highOutputTargetId = Integer.valueOf(m.group("highOutputTarget"));
                putChipInOutput(highOutputTargetId, bot.getHigh(), outputs);
                bot.setHigh(0);
            }

        }

    }

    private static Bot getInitialBot(Map<Integer, Bot> bots) {
        int initialBot = 0;
        for (Map.Entry<Integer, Bot> bot:bots.entrySet()) {
            if(bot.getValue().getLow() > 0 && bot.getValue().getHigh() > 0){
                initialBot = bot.getKey();
                break;
            }
        }

        return bots.get(initialBot);
    }

    private static void saveInstructionToBot(Map<Integer, Bot> bots, String line, int botValue) {
        Bot bot = bots.get(botValue);
        if(bot != null){
            bot.setInstruction(line);
        } else {
            bot = new Bot();
            bot.setInstruction(line);
            bots.put(botValue, bot);
        }
    }

    private static void saveChipToBot(Map<Integer, Bot> bots, int chipValue, int botValue) {
        Bot bot = bots.get(botValue);
        if(bot != null){
            bot.receiveChip(chipValue);
        } else {
            bot = new Bot();
            bot.receiveChip(chipValue);
            bots.put(botValue, bot);
        }
    }

    private static void giveChipToBot(int receiverBotId, int value, Map<Integer, Bot> botMap, Map<Integer, Integer> outputs){

        // Insert value on bot map
        Bot bot = botMap.get(receiverBotId);
        if(bot != null){
            bot.receiveChip(value);
            // Check if values are 17 and 61. If true print.
            if(bot.getLow() == 17 && bot.getHigh() == 61){
                System.out.println("Winner Bot: " + receiverBotId);
            }

            // If has both values -> read instruction and call recursively else return
            if(bot.getInstruction() != null && bot.getLow() > 0 && bot.getHigh() > 0){
                processInstruction(botMap, outputs, bot);
            }
        }

    }

    private static void putChipInOutput(int output, int value, Map<Integer, Integer> outputsMap){
        // Insert value on output and return
        outputsMap.put(output, value);
    }

}

class Bot {

    private int low;
    private int high;
    private String instruction;

    public void receiveChip(int value){

        if(this.low == 0 && this.high == 0){
            this.low = value;
        } else if(this.high == 0 && value > this.low){
            this.high = value;
        } else if(this.high == 0 && value < this.low){
            this.high = this.low;
            this.low = value;
        } else if(this.low == 0 && value > this.high){
            this.low = this.high;
            this.high = value;
        } else if(this.low == 0 && value < this.high){
            this.low = value;
        }

    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
