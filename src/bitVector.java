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
 *   valid positions range from 1 included to 32 included.
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
        if (size < 0) throw new IllegalArgumentException("The size of a bitVector cannot be negative");
        for (int i : p){
            if (i <= 0 || i > size){
                throw new IllegalArgumentException("Positions inside of a bitVector cannot have a higher value than the size of the bitVector, or have a value <= 0, positions range from 1 to 32 ");
            }
        }
        this.size = size;
        positions = new HashSet<>(Objects.requireNonNull(p, "Positions of a 1s inside of a bitVector cannot be null"));
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

    /**
     * Checks if the bitVector has a bit value of 1 in the given position
     * @param x the index of the bit to check
     * @return 1 if bitVector_i == 1, 0 otherwise
     * @throws IllegalArgumentException if x > size || 0 >= x >=
     */
    public int getBit(int x){
        if (positions.contains(x)){ return 1;}
        return 0;
    }

    /**
     * Extracts a subSet of a bitVector
     * @param size the size of the subSet bitVector
     *             the size shall be 1 > x >= size
     * @param index the index from which the subSet shall be extracted
     *             to extract half from the from of a 32 bit bitVector arguments shall be: (16, 1)
     *             to extract half from the from of a 32 bit bitVector arguments shall be: (16, 17)
     * @return the subSet bitVector requested
     * @throws IllegalArgumentException if index <= 0
     * @throws IllegalArgumentException if size > this.size
     */
    public bitVector subSet(int size, int index){
        if (index <= 0) throw new IllegalArgumentException("The starting index of a subSet of the bitVector cannot be <= 0, value should be in range 1 < x < size");
        if (size > this.size) throw new IllegalArgumentException("Cannot extract a bitVector bigger than the referenced bitVector");
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i < size+1; i++){
            if (getBit(index+i-1) == 1) s.add(i);
        }
        bitVector a = new bitVector(size, s);
        return a;
    }

    public static bitVector bitVectorFromInt(int x){
        String s = Integer.toBinaryString(x);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1') set.add(i+1);
        }
        bitVector b = new bitVector(s.length(), set);
        return b;
    }

    public static bitVector combineWith(bitVector b, bitVector c){
        Set<Integer> s = new HashSet<>();
        s.addAll(b.getPositions());
        int newsize = b.getSize() + c.getSize();
        for (int i : c.getPositions()){
            s.add(i + b.getSize());
        }
        b = new bitVector(newsize, s);
        return b;
    }
    
    public String getRep(){
        String output = "";
        for (int i = 1; i < size+1; i++){
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
