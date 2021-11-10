package eu.zulewski;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public static String getHash(Block block) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = messageDigest.digest(getByteArray(block));

        return hexToString(encodedHash);
    }

    private static String hexToString(byte[] hex) {
        BigInteger number = new BigInteger(1, hex);
        StringBuilder hexString = new StringBuilder(number.toString(16));

        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    private static byte[] getByteArray(Block block) {
        String str = new String(block.data + block.previousHash + Long.toString(block.timestamp) + Integer.toString(block.nonce));
        return str.getBytes(StandardCharsets.UTF_8);
    }
}
