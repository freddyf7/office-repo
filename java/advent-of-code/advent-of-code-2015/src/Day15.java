import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by freddy on 28/11/2016.
 */
public class Day15 {

    private static String FILE_PATH = "C:\\Users\\freddy\\Devel\\IdeaProjects\\office-repo\\java\\advent-of-code\\advent-of-code-2015\\src\\Input_Day15_1";
    private static String CAPACITY = "capacity";
    private static String DURABILITY = "durability";
    private static String FLAVOR = "flavor";
    private static String TEXTURE = "texture";
    private static String CALORIES = "calories";

    public static void main(String[] args) {

        List<Integer> capacities = new ArrayList<Integer>();
        List<Integer> durabilities = new ArrayList<Integer>();
        List<Integer> flavors = new ArrayList<Integer>();
        List<Integer> textures = new ArrayList<Integer>();
        List<Integer> calories = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    capacities.add(getCapacity(line));
                    durabilities.add(getDurability(line));
                    flavors.add(getFlavor(line));
                    textures.add(getTexture(line));
                    calories.add(getCalories(line));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int capacity = 0;
        int durability = 0;
        int flavor = 0;
        int texture = 0;
        int caloriesVal = 0;
        int highest = 0;
        int n = 0;

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                for (int k = 0; k <= 100; k++) {
                    for (int l = 0; l <= 100; l++) {
                        if(i + j + k + l == 100){

                            capacity = capacities.get(n) * i + capacities.get(n + 1) * j +  capacities.get(n + 2) * k + capacities.get(n + 3) * l;
                            durability = durabilities.get(n) * i + durabilities.get(n + 1) * j +  durabilities.get(n + 2) * k + durabilities.get(n + 3) * l;
                            flavor = flavors.get(n) * i + flavors.get(n + 1) * j +  flavors.get(n + 2) * k + flavors.get(n + 3) * l;
                            texture = textures.get(n) * i + textures.get(n + 1) * j +  textures.get(n + 2) * k + textures.get(n + 3) * l;
                            caloriesVal = calories.get(n) * i + calories.get(n + 1) * j +  calories.get(n + 2) * k + calories.get(n + 3) * l;

                            int addAll;
                            if(capacity > 0 && durability > 0 && flavor > 0 && texture > 0) {
                                addAll = capacity * durability * flavor * texture;
                            }
                            else {
                                addAll = 0;
                            }
                            if(addAll > highest && caloriesVal == 500) {
                                highest = addAll;
                            }

                        } else if(i + j + k + l > 100){
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(highest);

    }

    private static int getCapacity(String line){
        int capacityIndex = line.indexOf(CAPACITY);
        String capacityValue = line.substring(capacityIndex + CAPACITY.length() + 1, line.indexOf(","));
        return Integer.parseInt(capacityValue);
    }

    private static int getDurability(String line){
        int durabilityIndex = line.indexOf(DURABILITY);
        String durabilityValue = line.substring(durabilityIndex + DURABILITY.length() + 1, line.indexOf(",", durabilityIndex));
        return Integer.parseInt(durabilityValue);
    }

    private static int getFlavor(String line){
        int flavorIndex = line.indexOf(FLAVOR);
        String flavorValue = line.substring(flavorIndex + FLAVOR.length() + 1, line.indexOf(",", flavorIndex));
        return Integer.parseInt(flavorValue);
    }

    private static int getTexture(String line){
        int textureIndex = line.indexOf(TEXTURE);
        String textureValue = line.substring(textureIndex + TEXTURE.length() + 1, line.indexOf(",", textureIndex));
        return Integer.parseInt(textureValue);
    }

    private static int getCalories(String line){
        int caloriesIndex = line.indexOf(CALORIES);
        String caloriesValue = line.substring(caloriesIndex + CALORIES.length() + 1, line.length());
        return Integer.parseInt(caloriesValue);
    }


}
