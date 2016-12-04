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
public class Day4_1 {

    private static String FILE_PATH = "C:\\Users\\freddy\\Devel\\IdeaProjects\\office-repo\\java\\advent-of-code\\advent-of-code-2016\\resource\\Input_Day4_1";
    private static String PATTERN = "(?<name>[\\D-]+)(?<sector>\\d+)(?<checksum>[\\[\\w\\]]+)";

    public static void main(String[] args) {

        HashMap<String, Integer> letters = new HashMap<String, Integer>();
        int roomsIdSum = 0;
        int storageRoomId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            try {
                while ((line = br.readLine()) != null) {

                    Pattern r = Pattern.compile(PATTERN);
                    Matcher m = r.matcher(line);
                    if (m.find( )) {
                        // Dashes not necessary
                        String name = m.group("name");
                        name = name.replace("-", "");
                        String sector = m.group("sector");
                        String checksum = m.group("checksum");
                        checksum = checksum.replace("[","");
                        checksum = checksum.replace("]","");

                        for (int i = 0; i < name.length(); i++) {
                            char character = name.charAt(i);
                            storeLetter(String.valueOf(character), letters);
                        }

                        String commonLetters = commonLetters(letters);

                        if(commonLetters.equals(checksum)){
                            roomsIdSum = roomsIdSum + Integer.parseInt(sector);
                            StringBuilder decryptedName = new StringBuilder(name);
                            int rotation = Integer.parseInt(sector) % 26;

                            for (int i = 0; i < name.length() ; i++) {
                                char currentChar = name.charAt(i);
                                char rotatedChar;

                                if(currentChar + rotation > 122){
                                    rotatedChar = (char) (currentChar + rotation - 122 + 96);
                                } else {
                                    rotatedChar = (char) (currentChar + rotation);
                                }

                                decryptedName.setCharAt(i, rotatedChar);
                            }
                            if(decryptedName.toString().equals("northpoleobjectstorage")){
                                storageRoomId = Integer.parseInt(sector);
                            }

                        }

                    }else {
                        System.out.println("NO MATCH");
                    }

                    letters.clear();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(roomsIdSum);
        System.out.println(storageRoomId);
    }

    private static void storeLetter(String letter, HashMap<String, Integer> letters){
        if(letters.containsKey(letter)){
            int oldValue = letters.get(letter);
            letters.replace(letter, oldValue + 1);
        } else{
            letters.put(letter, 1);
        }
    }

    private static String commonLetters(Map<String, Integer> letters){

        String[] sortedKeys = new String[letters.size()];

        Map<String, Integer> sorted = sortByValue(letters);

        // Invert the sort to have DESC
        int i = sorted.size() - 1;
        for(HashMap.Entry<String, Integer> entry : sorted.entrySet()) {
            sortedKeys[i] = entry.getKey();
            i--;
        }

        StringBuilder commonLetters = new StringBuilder();
        for (String key:sortedKeys) {
            commonLetters.append(key);
        }

        return commonLetters.toString().substring(0, 5);
    }

    // Util to sort ASC by value and key
    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map ) {

        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>( map.entrySet() );

        Collections.sort(list, new Comparator<Map.Entry<K, V>>()
        {
            public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
            {
                if(o1.getValue() != o2.getValue()){
                    return (o1.getValue()).compareTo(o2.getValue());
                } else {
                    // Compare alphabetically
                    if(o1.getKey().compareTo(o2.getKey()) < 0){
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        } );

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        return result;
    }

}
