package basics;

public class SubString {
    public static void main(String[] args) {
        String s = "hello";
        subString(s);
        subStringWithoutBuiltIn(s);
    }

    private static void subStringWithoutBuiltIn(String s) {
        for(int i =0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder("");
            for (int j = i ; j < s.length(); j++) {
                sb.append(s.charAt(j));
                System.out.println(sb);
            }
        }
    }

    private static void subString(String s) {
        for (int i =0; i< s.length(); i++) {
            for(int j= i+1; j<=s.length(); j++) {
                System.out.println(s.substring(i,j));
            }
        }
    }
}
