package bouncycastle;

import java.security.*;

public class RSASignature {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {

        InitCrypto.init();

        // Generate key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        String message = "Transfer $10,000 to Bob";

        // Sign the message
        Signature signer = Signature.getInstance("SHA256withRSA", "BC");
        signer.initSign(keyPair.getPrivate());
        signer.update(message.getBytes());
        byte[] signature = signer.sign();

        // Verify the signature
        Signature verifier = Signature.getInstance("SHA256withRSA", "BC");
        verifier.initVerify(keyPair.getPublic());
        verifier.update(message.getBytes());

        boolean isValid = verifier.verify(signature);
        System.out.println("Signature valid: " + isValid);
    }
}
