package src;

import java.util.*;

public class Tests {
    
    public static void main(String[] args) {
        System.out.println("Testing goes here:");
        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(19);
        s.add(4);
        s.add(2);
        s.add(19);
        s.add(4);
        s.add(2);s.add(19);
        s.add(4);
        s.add(2);s.add(19);
        s.add(4);
        s.add(2);s.add(19);
        s.add(4);
        s.add(2);s.add(19);
        s.add(4);
        s.add(2);
        s.add(1);
        s.add(6);
        s.add(11);
        s.add(14);
        s.add(1);
        s.add(15);
        s.add(18);
        s.add(1);
        s.add(1);
        s.add(20);
        s.add(24);
        s.add(32);
        s.add(28);
        s.add(29);
        s.add(31);
        bitVector a = new bitVector(32, s);
        //System.out.println("a: " + a.getRep());
        Set<Integer> v = new HashSet<>();
        v.add(6);
        v.add(1);
        v.add(1);
        v.add(31);
        v.add(17);
        v.add(19);
        v.add(16);
        bitVector c = new bitVector(48, v);
        //System.out.println("c: " + c.getRep());


        Feistel f = new Feistel(a, c);
        System.out.println(f.getOutput().getRep());



    }
}
