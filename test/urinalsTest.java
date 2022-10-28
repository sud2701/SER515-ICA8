package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Urinals;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main() {
    }

    @Test
    void isValid() {

        assertTrue(Urinals.isValid(new String("00000")));
        assertFalse(Urinals.isValid(new String("Hello")));
        assertFalse(Urinals.isValid(new String("123,456")));
        assertFalse(Urinals.isValid(new String("abc123")));
        assertFalse(Urinals.isValid(new String("a,b,1.2,x23")));
        assertTrue(Urinals.isValid(new String("10101")));
        assertFalse(Urinals.isValid(new String("")));
        assertTrue(Urinals.isValid(new String("1")));
        assertTrue(Urinals.isValid(new String("0")));
        assertFalse(Urinals.isValid(new String("6")));
        assertTrue(Urinals.isValid(new String("010")));
        assertFalse(Urinals.isValid(new String("0000000000000000000000000000000000000000000")));
        assertFalse(Urinals.isValid(new String("011")));
        assertFalse(Urinals.isValid(new String("111")));
        assertFalse(Urinals.isValid(new String("1101")));
        System.out.println("====== Sudheer Reddy Kunduru == TEST ONE EXECUTED");
    }

    @Test
    void countUrinals() {
        Assertions.assertEquals(1, Urinals.countUrinals(new String("10001")));
        Assertions.assertEquals(0, Urinals.countUrinals(new String("1001")));
        Assertions.assertEquals(2, Urinals.countUrinals(new String("0000")));
        Assertions.assertEquals(3, Urinals.countUrinals(new String("00000")));
        Assertions.assertEquals(1, Urinals.countUrinals(new String("01000")));
        Assertions.assertEquals(-1, Urinals.countUrinals(new String("011")));
        Assertions.assertEquals(-1, Urinals.countUrinals(new String("11")));
        Assertions.assertEquals(0, Urinals.countUrinals(new String("101")));
        Assertions.assertEquals(0, Urinals.countUrinals(new String("10")));
        Assertions.assertEquals(1, Urinals.countUrinals(new String("10001")));
        System.out.println("====== Sudheer Reddy Kunduru == TEST TWO EXECUTED");
    }

    @Test
    void urinalUsage() {
        System.out.println("====== Sudheer Reddy Kunduru == FINAL TEST EXECUTED");
    }
}