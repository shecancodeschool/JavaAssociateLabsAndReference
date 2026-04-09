package org.eddydashcode.java_design_patterns.behavioral.template_method.data_validation;

public class EmailValidator extends DataValidator{
    @Override
    protected boolean checkFormat(String input) {
        return input.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }
}
