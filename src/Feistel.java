package src;

import java.util.*;

public class Feistel {
    
    bitVector bits;
    bitVector key;

    public Feistel(bitVector b, bitVector k){
        bits = b;
        key = k;
    }

    public static bitVector Expander(bitVector b) {
        Set<Integer> s = new HashSet<>();
        bitVector a = new bitVector(0, s);
        if (b.getSize() != 32) throw new IllegalArgumentException("The Feistel expansion formula requires a bitVector of size 32");
        
        return a;
    }

    public bitVector getBits() {
        return bits;
    }
    public bitVector getKey() {
        return key;
    }
    public bitVector getOutput(){
        bitVector f = Expander(bits);
        XOROperator x = new XOROperator();
        f = x.compareTo(f, key);
        f = sBox(f);
        f = Permuter(f);
        return f;
    }

    public static bitVector sBox(bitVector b) {
        return b;
    }

    public static bitVector Permuter(bitVector b){
        return b;
    }


}
