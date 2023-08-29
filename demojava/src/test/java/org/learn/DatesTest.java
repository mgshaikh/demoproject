package org.learn;

// JUNTI 5 test to test the validateDate  method in RegexDemo.java

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DatesTest {

    @Test
    void testValidateDate() {
     
        assertEquals(1,RegexDemo.validateDate("01/01/2021"));
    }

// add test for invalid date
    @Test
    void testValidateDateInvalid() {
     
        assertEquals(0,RegexDemo.validateDate("01--01/2021"));
    }
    
    // add test for invalid date
    @Test
    void testValidateDateInvalid2() {
     
        assertEquals(0,RegexDemo.validateDate("0101/2021"));
    }
    
    // add test for invalid date
    @Test
    void testValidateDateInvalid3() {
     
        assertEquals(0,RegexDemo.validateDate("01/44/2021"));
    }

    // test for format yyyy/mm/dd
    @Test
    void testValidateDate2() {
     
        assertEquals(3,RegexDemo.validateDate("2021/01/01"));
    }

}   

