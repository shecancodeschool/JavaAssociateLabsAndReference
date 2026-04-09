package org.eddydashcode.java_design_patterns.structural.decorator.message;

import org.eddydashcode.java_design_patterns.structural.decorator.message.decorator.MessageCompressionDecorator;
import org.eddydashcode.java_design_patterns.structural.decorator.message.decorator.MessageEncryptionDecorator;

public class ClientApplication {

    public static void main(String[] args) {

        Message plainText = new PlainMessage();
        plainText.display();

        System.out.println();

        Message encryptedMessage = new MessageEncryptionDecorator(plainText);
        encryptedMessage.display();

        System.out.println();

        Message compressedMessage = new MessageCompressionDecorator(encryptedMessage);
        compressedMessage.display();
    }
}
