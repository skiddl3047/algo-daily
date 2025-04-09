package blind75.stack;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] comp = path.split("/");
        for (String dir : comp) {
            if (dir.equals(".") || dir.isEmpty()) {
                continue;
            } else if (dir.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.add(dir);
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }
        return !sb.isEmpty() ? sb.toString() : "/";
    }
}
