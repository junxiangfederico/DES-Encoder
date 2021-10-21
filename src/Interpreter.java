package src;
import java.util.*;

public class Interpreter {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(3);
        s.add(5);
        s.add(6);
        s.add(2);
        s.add(8);
        s.add(8);
        s.add(10);
        bitVector b = new bitVector(32, s);

        Set<Integer> v = new HashSet<>();
        v.add(6);
        v.add(1);
        v.add(1);
        v.add(31);
        v.add(17);
        v.add(19);
        v.add(16);
        bitVector c = new bitVector(32, v);
        XOROperator xor = new XOROperator();

        System.out.println("b: " + b.getRep());

        System.out.println("c: " +c.getRep());

        bitVector d;
        d = c.subSet(16, 1);
        System.out.println(d.getRep());
        d = c.subSet(16, 17);
        System.out.println(d.getRep());
    }
}
