package src;
import java.util.*;

public class XOROperator implements Operator{

    @Override
    public bitVector compareTo(bitVector a, bitVector b) {
        if (a == null || b == null) throw new IllegalArgumentException("Argument bitVectors are null");
        if (a.getSize() != b.getSize()) throw new IllegalArgumentException("Argument bitVectors are of differing sizes");
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < a.getSize(); i++){
            if ((a.getBit(i) ^ b.getBit(i)) == 1) s.add(i);
        }
        bitVector c = new bitVector(a.getSize(), s);
        return c;
    }
    
}
