package blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Hasher {
    // Applies Sha256 to a string and returns the result
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Applies sha256 to our input
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            // This will contain hash as hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}