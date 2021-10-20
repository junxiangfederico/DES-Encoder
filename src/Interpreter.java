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
        v.add(0);
        v.add(31);
        v.add(18);
        v.add(19);
        v.add(10);
        bitVector c = new bitVector(32, v);
        XOROperator xor = new XOROperator();

        System.out.println(b.getRep());

        System.out.println(c.getRep());


        System.out.println(xor.compareTo(c, b).getRep());
    }
}
