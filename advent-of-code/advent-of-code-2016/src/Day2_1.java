import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by freddy on 02/12/2016.
 */
public class Day2_1 {

    private static String FILE_PATH = "C:\\Users\\freddy\\Devel\\IdeaProjects\\office-repo\\java\\advent-of-code\\advent-of-code-2016\\resource\\Input_Day2_1";
    private static int[] TOP_AVAILABLE = {4,5,6,7,8,9};
    private static int[] LEFT_AVAILABLE = {2,5,8,3,6,9};
    private static int[] DOWN_AVAILABLE = {1,2,3,4,5,6};
    private static int[] RIGHT_AVAILABLE = {1,4,7,2,5,8};

    public static void main(String[] args) {

        // First position is 5
        int currentPosition = 5;
        List<Integer> buttons = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            try {
                while ((line = br.readLine()) != null) {

                    for (int i = 0; i < line.length(); i++) {
                        char instruction = line.charAt(i);

                        switch (instruction) {
                            case 'U':
                                if(isTopAvailable(currentPosition)){
                                    currentPosition -= 3;
                                }
                                break;
                            case 'L':
                                if(isLeftAvailable(currentPosition)){
                                    currentPosition -= 1;
                                }
                                break;
                            case 'D':
                                if (isDownAvailable(currentPosition)) {
                                    currentPosition += 3;
                                }
                                break;
                            case 'R':
                                if (isRightAvailable(currentPosition)) {
                                    currentPosition += 1;
                                }
                                break;
                            default:
                                break;
                        }

                    }

                    // Add last pressed button
                    buttons.add(currentPosition);
                }

                for (Integer button:buttons) {
                    System.out.println(button);
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
    
    private static boolean isTopAvailable(final int position){
        return Arrays.stream(TOP_AVAILABLE).anyMatch(i -> i == position);
    }

    private static boolean isLeftAvailable(final int position){
        return Arrays.stream(LEFT_AVAILABLE).anyMatch(i -> i == position);
    }

    private static boolean isDownAvailable(final int position){
        return Arrays.stream(DOWN_AVAILABLE).anyMatch(i -> i == position);
    }

    private static boolean isRightAvailable(final int position){
        return Arrays.stream(RIGHT_AVAILABLE).anyMatch(i -> i == position);
    }

}
