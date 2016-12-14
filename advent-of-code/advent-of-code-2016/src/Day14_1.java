import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by freddy on 14/12/2016.
 */
public class Day14_1 {

    private static String INPUT = "abc";
    private static String PATTERN = "(\\w{1})\\1{2}";

    public static void main(String[] args) throws NoSuchAlgorithmException {

        // All 64 keys
        boolean foundAllKeys = false;
        List<Integer> keys =  new ArrayList<>();
        int index = 0;

        while(!foundAllKeys){

            String inputIndexed = INPUT.concat(Integer.toString(index));

            MessageDigest msg = MessageDigest.getInstance("MD5");
            msg.reset();
            String hexHash = (new HexBinaryAdapter()).marshal(msg.digest(inputIndexed.getBytes()));
            hexHash = hexHash.toLowerCase();

            Pattern r = Pattern.compile(PATTERN);
            Matcher m = r.matcher(hexHash);
            boolean foundQuintuplets = false;

            if(m.find() && !foundQuintuplets){
                String foundChar = m.group(1);

                int quintupletIndex = 1;

                while(!foundQuintuplets && quintupletIndex <= 1000){
                    String testInputIndexed = INPUT.concat(Integer.toString(index + quintupletIndex));
                    msg.reset();
                    String quintupletHexHash = (new HexBinaryAdapter()).marshal(msg.digest(testInputIndexed.getBytes()));
                    quintupletHexHash = quintupletHexHash.toLowerCase();

                    Pattern quintupletPattern = Pattern.compile("(" + foundChar +")\\1{4}");
                    Matcher quintupletMatcher = quintupletPattern.matcher(quintupletHexHash);

                    if(quintupletMatcher.find()){
                        keys.add(index);
                        foundQuintuplets = true;
                    }
                    quintupletIndex++;
                }
            }

            if(keys.size() == 64){
                foundAllKeys = true;
            }

            index++;
        }

        for (Integer key:keys) {
            System.out.println(key);
            //System.out.println("64th Key: " + keys.get(63));
        }

    }

}
