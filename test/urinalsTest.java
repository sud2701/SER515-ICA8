package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.urinals;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {
    urinals u=new urinals();
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

        Assertions.assertEquals(true,u.isValid(new String("00000")));
        assertFalse(u.isValid(new String("Hello")));
        Assertions.assertEquals(false,u.isValid(new String("123,456")));
        Assertions.assertEquals(false,u.isValid(new String("abc123")));
        Assertions.assertEquals(false,u.isValid(new String("a,b,1.2,x23")));
        Assertions.assertEquals(true,u.isValid(new String("10101")));
        Assertions.assertEquals(false,u.isValid(new String("")));
        Assertions.assertEquals(true,u.isValid(new String("1")));
        Assertions.assertEquals(true,u.isValid(new String("0")));
        Assertions.assertEquals(false,u.isValid(new String("6")));
        Assertions.assertEquals(true,u.isValid(new String("010")));
        Assertions.assertEquals(false,u.isValid(new String("0000000000000000000000000000000000000000000")));
        Assertions.assertEquals(false,u.isValid(new String("011")));
        Assertions.assertEquals(false,u.isValid(new String("111")));
        Assertions.assertEquals(false,u.isValid(new String("1101")));
        System.out.println("====== Sudheer Reddy Kunduru == TEST ONE EXECUTED");
    }

    @Test
    void countUrinals() {
        Assertions.assertEquals(3,u.countUrinals(new String("10001")));
        Assertions.assertEquals(2,u.countUrinals(new String("1001")));
        Assertions.assertEquals(2,u.countUrinals(new String("0000")));
        Assertions.assertEquals(3,u.countUrinals(new String("00000")));
        Assertions.assertEquals(2,u.countUrinals(new String("01000")));
        Assertions.assertEquals(-1,u.countUrinals(new String("011")));
        Assertions.assertEquals(-1,u.countUrinals(new String("11")));
        Assertions.assertEquals(2,u.countUrinals(new String("101")));
        Assertions.assertEquals(1,u.countUrinals(new String("10")));
        Assertions.assertEquals(3,u.countUrinals(new String("10001")));
        System.out.println("====== Sudheer Reddy Kunduru == TEST TWO EXECUTED");
    }
}