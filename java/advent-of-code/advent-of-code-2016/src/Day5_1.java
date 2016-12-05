import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by freddy on 05/12/2016.
 */
public class Day5_1 {

    private static String INPUT = "uqwqemis";

    public static void main(String[] args) throws NoSuchAlgorithmException {

        int index = 0;
        boolean passwordFound = false;
        StringBuilder password = new StringBuilder();

        while(!passwordFound){
            char passwordChar;
            String inputIndexed = INPUT.concat(Integer.toString(index));

            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            String hexHash = (new HexBinaryAdapter()).marshal(m.digest(inputIndexed.getBytes()));

            if(hexHash.startsWith("00000")){
                passwordChar = hexHash.charAt(5);
                password.append(passwordChar);
            }

            index++;

            if(password.length() == 8){
                passwordFound = true;
            }
        }

        System.out.println(password.toString());

    }

}
