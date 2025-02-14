package basics;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverse("Hello Sam"));
        System.out.println(new ReverseString().reverse("1234"));
    }

    private String reverse(String input) {
        char[] chars = input.toCharArray();
        int left =0; int right = input.length()-1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
