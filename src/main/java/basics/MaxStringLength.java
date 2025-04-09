package basics;

import java.util.Arrays;
import java.util.List;

public class MaxStringLength {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "welcome23", "to", "java", "world");

        int maxLength = words.stream()
                        .mapToInt(String::length)
                                .max()
                                        .orElse(0);
        int minLength = words.stream()
                        .mapToInt(String::length)
                                .min()
                                        .orElse(0);

        System.out.println("Maximum string length: " + maxLength);
        System.out.println("Minimum string length: " + minLength);
    }
}