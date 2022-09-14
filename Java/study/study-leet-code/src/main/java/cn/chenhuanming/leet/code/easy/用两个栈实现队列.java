package cn.chenhuanming.leet.code.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class 用两个栈实现队列 {
    public static void main(String[] args) {

    }

    private Deque<Integer> a;
    private Deque<Integer> b;

    public 用两个栈实现队列() {
        a = new ArrayDeque<>();
        b = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        while (!b.isEmpty()) {
            a.push(b.pop());
        }

        b.push(value);

        while (!a.isEmpty()) {
            b.push(a.pop());
        }
    }

    public int deleteHead() {
        return b.isEmpty() ? -1 : b.pop();
    }
}
