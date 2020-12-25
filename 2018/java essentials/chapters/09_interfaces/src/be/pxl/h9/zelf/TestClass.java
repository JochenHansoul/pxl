package be.pxl.h9.zelf;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class TestClass {
    public static void main(String[] args) {
        Collection<Integer> ic1 = new PriorityQueue<>();
        Collection<Integer> ic2 = new LinkedList<>();

        Deque<Integer> deq = new LinkedList<>();

        LinkedList<Integer> ll = new LinkedList<>();
        //List<Integer> l = new PriorityQueue<>(); // cannot infer arguments
    }
}
