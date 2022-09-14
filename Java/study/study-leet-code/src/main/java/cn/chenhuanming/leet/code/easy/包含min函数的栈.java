package cn.chenhuanming.leet.code.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class 包含min函数的栈 {
    private Deque<Integer> a;
    private Deque<Integer> b;

    public 包含min函数的栈() {
        a = new ArrayDeque<>();
        b = new ArrayDeque<>();
    }

    public void push(int x) {
        a.push(x);
        if (b.isEmpty() || b.peek() >= x) {
            b.push(x);
        }
    }

    public void pop() {
        if (a.pop().equals(b.peek()))
            b.pop();
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }
}
