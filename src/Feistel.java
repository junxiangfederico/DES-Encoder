package src;

import java.util.*;

public class Feistel {
    
    private final bitVector bits;
    private final bitVector key;

    public Feistel(bitVector b, bitVector k){
        if (b.getSize() != 64 || k.getSize() != 48) throw new IllegalArgumentException("The Feistel function requires a 64 bits long bitVector and a 48 bits long key bitVector");
        bits = b;
        key = k;
        //System.out.println("bits values: " + b.getRep());
        //System.out.println("key values: " + k.getRep());

    }

    /**
     * Feistel 32-bits expander function
     * @param b a bitVector of size 32
     */
    public static bitVector Expander(bitVector b) {
        Set<Integer> s = new HashSet<>();
        if (b.getSize() != 32) throw new IllegalArgumentException("The Feistel expansion formula requires a bitVector of size 32");
        for (int i = 1; i < 49; i++){
            switch (i) {
                case 1:
                    if (b.getBit(32) == 1) s.add(i);
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    if (b.getBit(i-1) == 1) s.add(i);
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                    if (b.getBit(i-3) == 1) s.add(i);
                    break;
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                    if (b.getBit(i-5) == 1) s.add(i);
                    break;
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    if (b.getBit(i-7) == 1) s.add(i);
                    break;
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                    if (b.getBit(i-9) == 1) s.add(i);
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                    if (b.getBit(i-11) == 1) s.add(i);  
                    break;
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                    if (b.getBit(i-13) == 1) s.add(i);  
                    break;
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                    if (b.getBit(i-15) == 1) s.add(i);  
                    break;
                case 48:
                    if (b.getBit(1) == 1) s.add(i);
                    break;
                default:
                    break;
            }
        }
        bitVector a = new bitVector(48, s);
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

    public bitVector sBox(bitVector b) {
        HashSet<Integer> h = new HashSet<>();
        bitVector output = new bitVector(0, h);
        for (int i = 1; i < 9; i++){
            bitVector c = b.subSet(6, ((i-1)*6)+1);
            int k = getSboxIndex(c);
            System.out.println(c.getRep() + "sbox index in array: " + k + " # sbox: " + i);
            bitVector d = sboxfunc(k, i);
            output = bitVector.combineWith(output, d);
        }
        return b;
    }

    public int getSboxIndex(bitVector b){
        int i = 0;
        switch (b.getBit(1) + b.getBit(6)) {
            case 0:
                break;
            case 1:
                i += 16;
                break;
            case 2:
                i += 32;
                break;
            case 3:
                i += 48;
                break;
        }
        bitVector c = b.subSet(4, 2);
        i += bitsToInt(c);
        return i;
    }

    public static int bitsToInt(bitVector b){
        return Integer.parseInt(b.getRep(), 2);
    }

    public bitVector intTobitVector(int x){
        bitVector b = bitVector.bitVectorFromInt(x);
        return b;
    }

    private bitVector sboxfunc(int sboxIndex, int sboxNumber) {
        bitVector b;
        int[] sbox1 = { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7,
            0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8, 4, 1, 14,
            8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0, 15, 12, 8, 2, 4, 9,
            1, 7, 5, 11, 3, 14, 10, 0, 6, 13 };
    int[] sbox2 = { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10,
            3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5, 0, 14, 7,
            11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15, 13, 8, 10, 1, 3,
            15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 };
    int[] sbox3 = { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8,
            13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1, 13, 6, 4,
            9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7, 1, 10, 13, 0, 6, 9,
            8, 7, 4, 15, 14, 3, 11, 5, 2, 12 };
    int[] sbox4 = { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15,
            13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9, 10, 6, 9,
            0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4, 3, 15, 0, 6, 10, 1,
            13, 8, 9, 4, 5, 11, 12, 7, 2, 14 };
    int[] sbox5 = { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9,
            14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6, 4, 2, 1,
            11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14, 11, 8, 12, 7, 1,
            14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 };
    int[] sbox6 = { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11,
            10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8, 9, 14,
            15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6, 4, 3, 2, 12, 9,
            5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 };
    int[] sbox7 = { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1,
            13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6, 1, 4, 11,
            13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2, 6, 11, 13, 8, 1, 4,
            10, 7, 9, 5, 0, 15, 14, 2, 3, 12 };
    int[] sbox8 = { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7,
            1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2, 7, 11, 4,
            1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8, 2, 1, 14, 7, 4, 10,
            8, 13, 15, 12, 9, 0, 3, 5, 6, 11 };

        if (sboxNumber == 1){
            b = intTobitVector(sbox1[sboxIndex]);
        }if (sboxNumber == 2){
            b = intTobitVector(sbox2[sboxIndex]);
        }if (sboxNumber == 3){
            b = intTobitVector(sbox3[sboxIndex]);
        }if (sboxNumber == 4){
            b = intTobitVector(sbox4[sboxIndex]);
        }if (sboxNumber == 5){
            b = intTobitVector(sbox5[sboxIndex]);
        }if (sboxNumber == 6){
            b = intTobitVector(sbox6[sboxIndex]);
        }if (sboxNumber == 7){
            b = intTobitVector(sbox7[sboxIndex]);
        }else{

            b = intTobitVector(sbox8[sboxIndex]);
        }
        return b;
        }
    public static bitVector Permuter(bitVector b){
        return b;
    }


}
