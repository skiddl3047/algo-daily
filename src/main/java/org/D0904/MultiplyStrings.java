package org.D0904;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] arr = new int[num1.length()+num2.length()];
        for(int i = num1.length()-1; i >= 0; i--) {
            int carry = 0;
            for(int j = num2.length()-1; j >= 0; j--) {
                arr[i+j+1] += carry + (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                carry = arr[i+j+1] / 10;
                arr[i+j+1] %= 10;
            }
            arr[i] = carry;
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while(i < arr.length && arr[i] == 0)
            i++;
        if(i >= arr.length)
            return "0";
        for(int j = i; j < arr.length; j++)
            builder.append(arr[j]);

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("60","6"));
        System.out.println(new MultiplyStrings().multiply("67","89"));
        System.out.println(new MultiplyStrings().multiply("22","33"));
        System.out.println(new MultiplyStrings().multiply("2","3"));
    }
}
