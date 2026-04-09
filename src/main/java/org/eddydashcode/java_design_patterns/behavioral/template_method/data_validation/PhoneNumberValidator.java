package org.eddydashcode.java_design_patterns.behavioral.template_method.data_validation;

public class PhoneNumberValidator extends DataValidator{

    @Override
    protected boolean checkFormat(String input) {
        return input.matches("^\\+?[0-9]{10,15}$");
    }
}
