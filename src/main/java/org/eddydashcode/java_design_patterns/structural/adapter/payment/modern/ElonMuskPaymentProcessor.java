package org.eddydashcode.java_design_patterns.structural.adapter.payment.modern;

public class ElonMuskPaymentProcessor implements ModernPaymentProcessor {

    private final BiometricScan biometricScan;

    public ElonMuskPaymentProcessor(BiometricScan biometricScan){
        this.biometricScan = biometricScan;
    }

    @Override
    public void initProcess() {
        System.out.println("Initiated modern payment with scan data -> " + biometricScan.scanData());

    }
}
