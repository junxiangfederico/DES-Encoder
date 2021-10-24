package src;

import java.util.*;

public class Permutation {
    
    public static bitVector initialPermutation(bitVector b){
        Set<Integer> s = new HashSet<>();
        if (b.getSize() != 64) throw new IllegalArgumentException("The Feistel expansion formula requires a bitVector of size 32");
        for (int i = 1; i < 65; i++){
            switch (i) {
                case 1:
                    if (b.getBit(58) == 1) s.add(i);
                    break;
                case 2:
                    if (b.getBit(50) == 1) s.add(i);
                    break;
                case 3:
                    if (b.getBit(42) == 1) s.add(i);
                    break;
                case 4:
                    if (b.getBit(34) == 1) s.add(i);
                    break;
                case 5:
                if (b.getBit(26) == 1) s.add(i);
                break;
                case 6:
                if (b.getBit(18) == 1) s.add(i);
                break;
                case 7:
                if (b.getBit(10) == 1) s.add(i);
                break;
                case 8:
                if (b.getBit(2) == 1) s.add(i);
                break;
                case 9:
                if (b.getBit(60) == 1) s.add(i);
                break;
                case 10:
                if (b.getBit(52) == 1) s.add(i);
                break;
                case 11:
                if (b.getBit(44) == 1) s.add(i);
                break;
                case 12:
                if (b.getBit(36) == 1) s.add(i);
                break;
                case 13:
                if (b.getBit(28) == 1) s.add(i);
                break;
                case 14:
                if (b.getBit(20) == 1) s.add(i);
                break;
                case 15:
                if (b.getBit(12) == 1) s.add(i);
                break;
                case 16:
                if (b.getBit(4) == 1) s.add(i);
                break;
                case 17:
                if (b.getBit(62) == 1) s.add(i);
                break;
                case 18:
                if (b.getBit(54) == 1) s.add(i);
                break;
                case 19:
                if (b.getBit(46) == 1) s.add(i);
                break;
                case 20:
                if (b.getBit(38) == 1) s.add(i);
                break;
                case 21:
                if (b.getBit(30) == 1) s.add(i);
                break;
                case 22:
                if (b.getBit(22) == 1) s.add(i);
                break;
                case 23:
                if (b.getBit(14) == 1) s.add(i);
                break;
                case 24:
                if (b.getBit(6) == 1) s.add(i);
                break;
                case 25:
                if (b.getBit(64) == 1) s.add(i);
                break;
                case 26:
                if (b.getBit(56) == 1) s.add(i);
                break;
                case 27:
                if (b.getBit(48) == 1) s.add(i);
                break;
                case 28:
                if (b.getBit(40) == 1) s.add(i);
                break;
                case 29:
                if (b.getBit(32) == 1) s.add(i);
                break;
                case 30:
                if (b.getBit(24) == 1) s.add(i);
                break;
                case 31:
                if (b.getBit(16) == 1) s.add(i);
                break;
                case 32:
                if (b.getBit(8) == 1) s.add(i);
                break;
                case 33:
                if (b.getBit(57) == 1) s.add(i);
                break;
                case 34:
                if (b.getBit(49) == 1) s.add(i);
                break;
                case 35:
                if (b.getBit(41) == 1) s.add(i);
                break;
                case 36:
                if (b.getBit(33) == 1) s.add(i);
                break;
                case 37:
                if (b.getBit(25) == 1) s.add(i);
                break;
                case 38:
                if (b.getBit(17) == 1) s.add(i);
                break;
                case 39:
                if (b.getBit(9) == 1) s.add(i);
                break;
                case 40:
                if (b.getBit(1) == 1) s.add(i);
                break;
                case 41:
                if (b.getBit(59) == 1) s.add(i);
                break;
                case 42:
                if (b.getBit(51) == 1) s.add(i);
                break;
                case 43:
                if (b.getBit(43) == 1) s.add(i);
                break;
                case 44:
                if (b.getBit(35) == 1) s.add(i);
                break;
                case 45:
                if (b.getBit(27) == 1) s.add(i);
                break;
                case 46:
                if (b.getBit(19) == 1) s.add(i);
                break;
                case 47:
                if (b.getBit(11) == 1) s.add(i);
                break;
                case 48:
                if (b.getBit(3) == 1) s.add(i);
                break;
                case 49:
                if (b.getBit(61) == 1) s.add(i);
                break;
                case 50:
                if (b.getBit(53) == 1) s.add(i);
                break;
                case 51:
                if (b.getBit(45) == 1) s.add(i);
                break;
                case 52:
                if (b.getBit(37) == 1) s.add(i);
                break;
                case 53:
                if (b.getBit(29) == 1) s.add(i);
                break;
                case 54:
                if (b.getBit(21) == 1) s.add(i);
                break;
                case 55:
                if (b.getBit(13) == 1) s.add(i);
                break;
                case 56:
                if (b.getBit(5) == 1) s.add(i);
                break;
                case 57:
                if (b.getBit(63) == 1) s.add(i);
                break;
                case 58:
                if (b.getBit(55) == 1) s.add(i);
                break;
                case 59:
                if (b.getBit(47) == 1) s.add(i);
                break;
                case 60:
                if (b.getBit(39) == 1) s.add(i);
                break;
                case 61:
                if (b.getBit(31) == 1) s.add(i);
                break;
                case 62:
                if (b.getBit(23) == 1) s.add(i);
                break;
                case 63:
                if (b.getBit(15) == 1) s.add(i);
                break;
                case 64:
                if (b.getBit(7) == 1) s.add(i);
                break;


            }
        }
        bitVector a = new bitVector(64, s);
        return a;
    }
    public static bitVector inversePermutation(bitVector b){
        Set<Integer> s = new HashSet<>();
        if (b.getSize() != 64) throw new IllegalArgumentException("The Feistel expansion formula requires a bitVector of size 32");
        for (int i = 1; i < 65; i++){
            switch (i) {
                case 1:
                    if (b.getBit(40) == 1) s.add(i);
                    break;
                case 2:
                    if (b.getBit(8) == 1) s.add(i);
                    break;
                case 3:
                    if (b.getBit(48) == 1) s.add(i);
                    break;
                case 4:
                    if (b.getBit(16) == 1) s.add(i);
                    break;
                case 5:
                if (b.getBit(56) == 1) s.add(i);
                break;
                case 6:
                if (b.getBit(24) == 1) s.add(i);
                break;
                case 7:
                if (b.getBit(64) == 1) s.add(i);
                break;
                case 8:
                if (b.getBit(32) == 1) s.add(i);
                break;
                case 9:
                if (b.getBit(39) == 1) s.add(i);
                break;
                case 10:
                if (b.getBit(7) == 1) s.add(i);
                break;
                case 11:
                if (b.getBit(47) == 1) s.add(i);
                break;
                case 12:
                if (b.getBit(15) == 1) s.add(i);
                break;
                case 13:
                if (b.getBit(55) == 1) s.add(i);
                break;
                case 14:
                if (b.getBit(23) == 1) s.add(i);
                break;
                case 15:
                if (b.getBit(63) == 1) s.add(i);
                break;
                case 16:
                if (b.getBit(31) == 1) s.add(i);
                break;
                case 17:
                if (b.getBit(38) == 1) s.add(i);
                break;
                case 18:
                if (b.getBit(6) == 1) s.add(i);
                break;
                case 19:
                if (b.getBit(46) == 1) s.add(i);
                break;
                case 20:
                if (b.getBit(14) == 1) s.add(i);
                break;
                case 21:
                if (b.getBit(56) == 1) s.add(i);
                break;
                case 22:
                if (b.getBit(22) == 1) s.add(i);
                break;
                case 23:
                if (b.getBit(62) == 1) s.add(i);
                break;
                case 24:
                if (b.getBit(30) == 1) s.add(i);
                break;
                case 25:
                if (b.getBit(37) == 1) s.add(i);
                break;
                case 26:
                if (b.getBit(5) == 1) s.add(i);
                break;
                case 27:
                if (b.getBit(45) == 1) s.add(i);
                break;
                case 28:
                if (b.getBit(13) == 1) s.add(i);
                break;
                case 29:
                if (b.getBit(53) == 1) s.add(i);
                break;
                case 30:
                if (b.getBit(21) == 1) s.add(i);
                break;
                case 31:
                if (b.getBit(61) == 1) s.add(i);
                break;
                case 32:
                if (b.getBit(29) == 1) s.add(i);
                break;
                case 33:
                if (b.getBit(36) == 1) s.add(i);
                break;
                case 34:
                if (b.getBit(4) == 1) s.add(i);
                break;
                case 35:
                if (b.getBit(44) == 1) s.add(i);
                break;
                case 36:
                if (b.getBit(12) == 1) s.add(i);
                break;
                case 37:
                if (b.getBit(52) == 1) s.add(i);
                break;
                case 38:
                if (b.getBit(20) == 1) s.add(i);
                break;
                case 39:
                if (b.getBit(60) == 1) s.add(i);
                break;
                case 40:
                if (b.getBit(28) == 1) s.add(i);
                break;
                case 41:
                if (b.getBit(35) == 1) s.add(i);
                break;
                case 42:
                if (b.getBit(3) == 1) s.add(i);
                break;
                case 43:
                if (b.getBit(43) == 1) s.add(i);
                break;
                case 44:
                if (b.getBit(11) == 1) s.add(i);
                break;
                case 45:
                if (b.getBit(51) == 1) s.add(i);
                break;
                case 46:
                if (b.getBit(19) == 1) s.add(i);
                break;
                case 47:
                if (b.getBit(59) == 1) s.add(i);
                break;
                case 48:
                if (b.getBit(27) == 1) s.add(i);
                break;
                case 49:
                if (b.getBit(34) == 1) s.add(i);
                break;
                case 50:
                if (b.getBit(2) == 1) s.add(i);
                break;
                case 51:
                if (b.getBit(42) == 1) s.add(i);
                break;
                case 52:
                if (b.getBit(10) == 1) s.add(i);
                break;
                case 53:
                if (b.getBit(50) == 1) s.add(i);
                break;
                case 54:
                if (b.getBit(18) == 1) s.add(i);
                break;
                case 55:
                if (b.getBit(58) == 1) s.add(i);
                break;
                case 56:
                if (b.getBit(26) == 1) s.add(i);
                break;
                case 57:
                if (b.getBit(33) == 1) s.add(i);
                break;
                case 58:
                if (b.getBit(1) == 1) s.add(i);
                break;
                case 59:
                if (b.getBit(41) == 1) s.add(i);
                break;
                case 60:
                if (b.getBit(9) == 1) s.add(i);
                break;
                case 61:
                if (b.getBit(49) == 1) s.add(i);
                break;
                case 62:
                if (b.getBit(17) == 1) s.add(i);
                break;
                case 63:
                if (b.getBit(57) == 1) s.add(i);
                break;
                case 64:
                if (b.getBit(25) == 1) s.add(i);
                break;


            }
        }
        bitVector a = new bitVector(64, s);
        return a;
    }





}
