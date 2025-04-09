package org.test;

public class Interview {

    public static String transformString(String input) {
        if (input.length() > 3) {
            String sub = input.substring(0, 3);
            input = input.replace(sub, sub.toUpperCase());
            return input.replaceAll("s", "***");
        }
        return null;
    }

    public static void main(String[] args) {
        String text = "successful";
        String result = transformString(text);
        System.out.println(result);

    }
}
