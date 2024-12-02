package practice;

public class MinParenthesisRemovalToMakeValid {

    public static String minRemoveToMakeValidOptimal(String s) {
        StringBuilder sb = new StringBuilder();
        int openSeen =0;
        int balance =0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                openSeen++;
                balance++;
            }else if(ch == ')'){
                if(balance == 0)
                    continue;
                balance--;
            }
            sb.append(ch);
        }

        int openToKeep = openSeen - balance;
        StringBuilder result = new StringBuilder();
        for(char ch: sb.toString().toCharArray()){
            if(ch == '('){
                openToKeep--;
                if(openToKeep < 0)
                    continue;
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValidOptimal("(((abc)"));
    }
}
