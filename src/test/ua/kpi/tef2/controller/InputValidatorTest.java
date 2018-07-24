package ua.kpi.tef2.controller;

import org.junit.Test;
import ua.kpi.tef2.controller.validators.InputValidator;
import ua.kpi.tef2.controller.validators.InputValidatorImpl;

import static org.junit.Assert.*;
import static ua.kpi.tef2.controller.InputType.*;

public class InputValidatorTest {

    private InputValidator inputValidator = new InputValidatorImpl();

    @Test
    public void testValidationNameFalse() {
        String inputType = NAME;

        assertFalse(inputValidator.validate(inputType, "yaroslav"));
        assertFalse(inputValidator.validate(inputType, "Yaros lav"));
        assertFalse(inputValidator.validate(inputType, "Yaros--lav"));
        assertFalse(inputValidator.validate(inputType, "Yaros.lav"));
    }

    @Test
    public void testNewValidationNameTrue() {
        String inputType = NAME;
        assertTrue(inputValidator.validate(inputType, "Yaroslav"));
        assertTrue(inputValidator.validate(inputType, "Yaros-lav"));
    }

    @Test
    public void testLastNameValidation() {
        String inputType = LAST_NAME;
        assertTrue(inputValidator.validate(inputType, "Olesiiuk"));
        assertFalse(inputValidator.validate(inputType, "Olesiiuk 123"));
    }

    @Test
    public void testCommentValidation() {
        String inputType = COMMENT;
        assertTrue(inputValidator.validate(inputType, "some comment of few words"));
        assertTrue(inputValidator.validate(inputType, "some comment of few words, and some ? " +
                "punctuation. that ... I need to check!"));
    }

    @Test
    public void testPhoneNumberValidation() {
        String inputType = PHONE;
        assertTrue(inputValidator.validate(inputType, "063-845-62-45"));
        assertTrue(inputValidator.validate(inputType, "+38-063-845-62-45"));
        assertFalse(inputValidator.validate(inputType, "+38-abd-845-62-45"));
        assertFalse(inputValidator.validate(inputType, "+38-063-845-62-450"));
        assertFalse(inputValidator.validate(inputType, "+38-063-845-62--5"));
        assertFalse(inputValidator.validate(inputType, "+38-063 845-62-45"));
    }

    @Test
    public void testEmailValidation() {
        String inputType = EMAIL;
        assertTrue(inputValidator.validate(inputType, "test@email.com"));
        assertTrue(inputValidator.validate(inputType, "te.s_t@email.com"));
        assertFalse(inputValidator.validate(inputType, "t/e.s_t@email.com"));
        assertFalse(inputValidator.validate(inputType, "te.s_t@ema il.com"));
        assertFalse(inputValidator.validate(inputType, "tes t@ema il.com"));
    }

}
