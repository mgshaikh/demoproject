package org.learn;

// JUNTI 5 test to test the validateEmail() method in RegexDemo.java

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRegexDemo {

    @Test
    void testValidateEmail() {
     
        assertTrue(RegexDemo.validateEmail("mg@test.com"));
    }

// add test for invalid email
    @Test
    void testValidateEmailInvalid() {
     
        assertFalse(RegexDemo.validateEmail("mg@test"));
    }
    
    // add test for invalid email
    @Test
    void testValidateEmailInvalid2() {
     
        assertFalse(RegexDemo.validateEmail("mg@test."));
    }
    
    // add test for invalid email
    @Test
    void testValidateEmailInvalid3() {
     
        assertFalse(RegexDemo.validateEmail("mg@test.c"));
    }
    


}