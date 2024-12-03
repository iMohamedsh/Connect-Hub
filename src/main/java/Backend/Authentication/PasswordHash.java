package Backend.Authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordHash {

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest MD = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = MD.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
        
    }
}
