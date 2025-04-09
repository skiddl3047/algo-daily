package basics;

public class Palindrome {

    public static void main(String[] args) {

        String s = "helloolleh";
        boolean isPalindrome = true;
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left ++;
            right --;
        }
        if(isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}
