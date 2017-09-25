package utils;

import java.util.Stack;

/**
 * Created by Snowson Zhang on 2017/9/23.
 */
public class StackUtils {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void add(int ...param) {
        for(int item : param) {
            stack1.push(item);
        }
    }

    public static void poll() {
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        System.out.println(stack2.pop());
        for(int item : stack2) {
            stack1.push(item);
        }
    }
}
