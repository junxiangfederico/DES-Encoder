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
        s.add(40);
        s.add(41);
        s.add(48);
        s.add(50);
        s.add(51);
        s.add(52);
        s.add(55);
        s.add(59);
        s.add(60);
        s.add(63);
        s.add(64);
        bitVector a = new bitVector(64, s);
        System.out.println("a: " + a.getRep());
        System.out.println("a: permutated" + Permutation.initialPermutation(a).getRep());
        System.out.println("a: r_permutated" + Permutation.inversePermutation(a).getRep());

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



    }
}
