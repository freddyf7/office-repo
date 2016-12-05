import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by freddy on 05/12/2016.
 */
public class Day5_2 {

    private static String INPUT = "uqwqemis";

    public static void main(String[] args) throws NoSuchAlgorithmException {

        int index = 0;
        boolean passwordFound = false;
        String[] passwordChars = new String[8];

        while(!passwordFound){
            char passwordPositionChar;
            String inputIndexed = INPUT.concat(Integer.toString(index));

            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            String hexHash = (new HexBinaryAdapter()).marshal(m.digest(inputIndexed.getBytes()));

            if(hexHash.startsWith("00000")){
                // Validate if a position is already filled
                // Validate if is valid position 0-7
                passwordPositionChar = hexHash.charAt(5);

                if(String.valueOf(passwordPositionChar).matches("[0-7]{1}")){
                    int passwordPositionInteger = Integer.parseInt(String.valueOf(passwordPositionChar));
                    if(passwordChars[passwordPositionInteger] == null){
                        passwordChars[passwordPositionInteger] = String.valueOf(hexHash.charAt(6));
                    }
                }

            }

            index++;

            boolean charsMissing = false;
            for (String character:passwordChars) {
                if(character == null){
                    charsMissing = true;
                }
            }

            passwordFound = charsMissing == true ? false : true;
        }

        for (String character:passwordChars) {
            System.out.println(character);
        }

    }

}
