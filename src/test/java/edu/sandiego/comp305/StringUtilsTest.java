package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsTest {

    @Test
    public void testReverseString() {
        assertEquals("hello", StringUtils.reverseString("olleh"));
    }

    @Test
    public void testReverseStringEmpty() {
        assertEquals("", StringUtils.reverseString(""));
    }

    @Test
    public void testReverseStringSingleChar() {
        assertEquals("a", StringUtils.reverseString("a"));
    }
}
