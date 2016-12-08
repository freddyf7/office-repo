import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by freddy on 08/12/2016.
 */
public class Day8_1 {

    private static String FILE_PATH = "C:\\Users\\freddy\\Devel\\IdeaProjects\\office-repo\\advent-of-code\\advent-of-code-2016\\resource\\Input_Day8_1";
    private static int MATRIX_WIDE = 50;
    private static int MATRIX_HEIGHT = 6;

    public static void main(String[] args) {

        int[][] matrix = new int[MATRIX_WIDE][MATRIX_HEIGHT];
        fillArray(matrix);

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            try {
                while ((line = br.readLine()) != null) {
                        if(line.matches("rect.*")){
                            rect(line, matrix);
                        }
                        if(line.matches("rotate row.*")){
                            rotateRow(line, matrix);
                        }
                        if(line.matches("rotate column.*")){
                            rotateColumn(line, matrix);
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
        for (int i = 0; i < MATRIX_HEIGHT; i++) {
            for (int j = 0; j < MATRIX_WIDE; j++) {
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Lit Pixels: " + countLitPixels(matrix));
        System.out.println("Spells: " + "UPOJFLBCEZ");
    }

    private static void fillArray(int[][] matrix){
        for (int i = 0; i < MATRIX_WIDE ; i++) {
            for (int j = 0; j <MATRIX_HEIGHT ; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    private static void rect(String line, int[][] matrix){
        Pattern r = Pattern.compile(".* (\\d+)x(\\d+)");
        Matcher m = r.matcher(line);
        int wide = 0;
        int height = 0;

        if(m.find()){
            wide = Integer.parseInt(m.group(1));
            height = Integer.parseInt(m.group(2));
        }

        for (int i = 0; i < wide; i++) {
            for (int j = 0; j < height; j++) {
                matrix[i][j] = 1;
            }
        }
    }

    private static void rotateRow(String line, int[][] matrix){
        Pattern r = Pattern.compile(".* y=(\\d+) by (\\d+)");
        Matcher m = r.matcher(line);
        int y = 0;
        int rotation = 0;
        int[] newRow = new int[MATRIX_WIDE];

        if(m.find()){
            y = Integer.parseInt(m.group(1));
            rotation = Integer.parseInt(m.group(2));
        }

        for (int i = 0; i < MATRIX_WIDE; i++) {
            if(i - rotation < 0){
                int diff = rotation - i;
                newRow[i] = matrix[MATRIX_WIDE - diff][y];
            } else {
                newRow[i] = matrix[i - rotation][y];
            }
        }

        for (int i = 0; i < MATRIX_WIDE; i++) {
            matrix[i][y] = newRow[i];
        }
    }

    private static void rotateColumn(String line, int[][] matrix){
        Pattern r = Pattern.compile(".* x=(\\d+) by (\\d+)");
        Matcher m = r.matcher(line);
        int x = 0;
        int rotation = 0;
        int[] newColumn = new int[MATRIX_HEIGHT];

        if(m.find()){
            x = Integer.parseInt(m.group(1));
            rotation = Integer.parseInt(m.group(2));
        }

        for (int i = 0; i < MATRIX_HEIGHT; i++) {
            if(i - rotation < 0){
                int diff = rotation - i;
                newColumn[i] = matrix[x][MATRIX_HEIGHT - diff];
            } else {
                newColumn[i] = matrix[x][i - rotation];
            }
        }

        for (int i = 0; i < MATRIX_HEIGHT; i++) {
            matrix[x][i] = newColumn[i];
        }
    }

    private static int countLitPixels(int[][] matrix){
        int litPixels = 0;

        for (int i = 0; i < MATRIX_WIDE; i++) {
            for (int j = 0; j < MATRIX_HEIGHT; j++) {
                if(matrix[i][j] == 1){
                    litPixels++;
                }
            }
        }

        return litPixels;
    }

}
