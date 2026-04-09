package org.eddydashcode.java_design_patterns.structural.adapter.payment.legacy;

public class MaxPaymentProcessor implements LegacyPaymentProcessor {

    private final  CardPayment cardPayment;

    public MaxPaymentProcessor(CardPayment cardPayment){
        this.cardPayment = cardPayment;
    }

    @Override
    public void initProcess() {
        System.out.println("Initiated legacy payment with pin code -> " + this.cardPayment.pinCode());

    }
}
