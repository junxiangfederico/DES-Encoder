package src;
import java.util.*;

/**
 * Istances in this class concur to represent a bitVector.
 * A bitVector is a sequence of bits 0 and 1 of size >= 0
 * 
 * Attributes in this classe are private and mutable in the case of the positions, and immutable in the case of the size
 * A typical bitVector is b[] = [x_1, ..., x_k] with x_i == 0 || x_i == 1 
 *                        && b.size >=0
 * 
 * bitVectors in this class are concurrently represented by 2 attributs:
 * - the size attribute represents the number of bits inside of a bitVector: usually 32 or 64
 * - the positions attribute represents the positions inside of a bitVector where the bit == 1.
 *   positions which are not present inside the positions attribute have the bit value == 0.
 * 
 * eg.
 * a bitVector in which size = 32 && positions = <1, 2, 4, 7, 12, 14, 15>
 * is as follows: [01101001000010110000000000000000]
 * 
 * A bitVector has a constructor method, which istantiates a bitVector of size \input(size) and positions in which the bit is one, given the Set.
 * 
 * 
 * 
 * AF(size, positions): if p.size > 0 :"bitVector of size: " + size + "with 1s in positions: " + [p_1, ... p_k] for each Integer in p <==> p.size >= 0
 *                      if p.size == 0 :"bitVector of size" + size + ", empty."
 * 
 * IR(size, positions): size >= 0
 *                      positions != null && 
 *                      for {p_1, ..., p_k}, p_i >= 0 && p_i < 32
 *                      
 */
public class bitVector {

    private final int size;
    private Set<Integer> positions;


    public bitVector(int size, Set<Integer> p){
        this.size = size;
        positions = new HashSet<>(p);
    }

    public int getSize() {
        return size;
    }

    public Set<Integer> getPositions() {
        return positions;
    }

    public void addPosition(int x){

        if (!positions.contains(x)) positions.add(x);
    }

    public int getBit(int x){
        if (positions.contains(x)){ return 1;}
        return 0;
    }

    public String getRep(){
        String output = "";
        for (int i = 0; i < size; i++){
            if (positions.contains(i)){
                output += "1";
            }else{
                output += "0";
            }
        }
        return output;
    }

    @Override
    public String toString() {
        String output = "";

        if (positions.size() == 0){
            return "bitVector of size"  + size + ", empty.";
        }

        for (int i: positions){
            output = output + i + ", ";
        }
        output.stripLeading();
        return "bitVector of size: " + size + " with 1s in positions: " + output;
    }

}
