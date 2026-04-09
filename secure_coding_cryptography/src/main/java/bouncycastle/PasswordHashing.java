package bouncycastle;

import org.bouncycastle.jcajce.provider.digest.SHA3;

import java.util.Base64;

public class PasswordHashing {

    public static String hash(String password) {
        SHA3.Digest256 sha3Digest = new SHA3.Digest256();
        byte[] hash = sha3Digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    public static void main(String[] args) {
        InitCrypto.init(); // important!
        String hashed = hash("mySecurePassword123!");
        System.out.println("SHA3-256 hash: " + hashed);
    }
}
