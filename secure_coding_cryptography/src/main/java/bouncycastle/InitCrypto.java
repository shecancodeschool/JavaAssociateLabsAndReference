package bouncycastle;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

public class InitCrypto {

    public static void init() {
        Security.addProvider(new BouncyCastleProvider());
    }
}
