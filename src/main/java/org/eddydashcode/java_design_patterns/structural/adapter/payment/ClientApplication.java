package org.eddydashcode.java_design_patterns.structural.adapter.payment;

import org.eddydashcode.java_design_patterns.structural.adapter.payment.adapter.LegacyPaymentProcessorAdapter;
import org.eddydashcode.java_design_patterns.structural.adapter.payment.legacy.CardPayment;
import org.eddydashcode.java_design_patterns.structural.adapter.payment.legacy.LegacyPaymentProcessor;
import org.eddydashcode.java_design_patterns.structural.adapter.payment.legacy.MaxPaymentProcessor;
import org.eddydashcode.java_design_patterns.structural.adapter.payment.modern.BiometricScan;
import org.eddydashcode.java_design_patterns.structural.adapter.payment.modern.ElonMuskPaymentProcessor;
import org.eddydashcode.java_design_patterns.structural.adapter.payment.modern.ModernPaymentProcessor;

public class ClientApplication {

    public void makePayment(ModernPaymentProcessor modernPaymentProcessor){
        modernPaymentProcessor.initProcess();
    }


    public static void main(String[] args) {

        // original payment system
        ModernPaymentProcessor modernPaymentProcessor = new ElonMuskPaymentProcessor(new BiometricScan("qwerty"));
        ClientApplication clientApplication1 = new ClientApplication();
        clientApplication1.makePayment(modernPaymentProcessor);

        System.out.println(); // for spacing

        // using legacy payment directly fails because the interfaces are not compatible
        LegacyPaymentProcessor legacyPaymentProcessor = new MaxPaymentProcessor(new CardPayment(1234));
        ClientApplication clientApplication2 = new ClientApplication();
//        clientApplication2.makePayment(legacyPaymentProcessor);  // complied error


        // the adapter permits the incompatible interfaces to collaborate
        LegacyPaymentProcessorAdapter legacyPaymentProcessorAdapter = new LegacyPaymentProcessorAdapter(legacyPaymentProcessor);
        ClientApplication clientApplication3 = new ClientApplication();
        clientApplication3.makePayment(legacyPaymentProcessorAdapter);
    }
}
