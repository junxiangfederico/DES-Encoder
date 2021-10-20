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
        System.out.println(b.getRep());
    }
}
