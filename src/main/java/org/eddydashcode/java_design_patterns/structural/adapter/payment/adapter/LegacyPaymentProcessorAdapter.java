package org.eddydashcode.java_design_patterns.structural.adapter.payment.adapter;

import org.eddydashcode.java_design_patterns.structural.adapter.payment.legacy.LegacyPaymentProcessor;
import org.eddydashcode.java_design_patterns.structural.adapter.payment.modern.ModernPaymentProcessor;

public class LegacyPaymentProcessorAdapter implements ModernPaymentProcessor {

    private final LegacyPaymentProcessor legacyPaymentProcessor;

    public LegacyPaymentProcessorAdapter(LegacyPaymentProcessor legacyPaymentProcessor) {
        this.legacyPaymentProcessor = legacyPaymentProcessor;
    }

    @Override
    public void initProcess() {
        // business logics for conversion
        legacyPaymentProcessor.initProcess();
    }
}
