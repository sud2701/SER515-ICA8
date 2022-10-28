package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.urinals;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

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
        urinals u=new urinals();
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
        System.out.println("====== Sudheer Reddy Kunduru == TEST ONE EXECUTED");
    }
}