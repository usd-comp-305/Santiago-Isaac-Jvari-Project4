package edu.sandiego.comp305;

/**
 * Utility class for String operations.
 */
public final class StringUtils {

    /**
     * Private constructor
     */
    private StringUtils() {
    }

    /**
     * Reverses the given string.
     *
     * @param input string to reverse
     * @return reversed string
     */
    public static String reverseString(final String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
