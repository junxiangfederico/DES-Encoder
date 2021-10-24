package src;
import java.util.*;

public class Interpreter {
    public static void main(String[] args) {
        System.out.println("Welcome, what would you like to do?");
        System.out.println("1 calculate the Initial Permutation of a 64 bits sequence");
        System.out.println("2 calculate the Inverse Permutation of a 64 bits sequence");
        System.out.println("3 calculate the key value of a given round");
        System.out.println("4 calculate the cipher value for a given round");
        System.out.println("5 calculate the Feistel function output for a given round");
        System.out.println("0 exit");
        Set<Integer> set = new HashSet<>();
        bitVector b;
        String input = "";
        Scanner s = new Scanner(System.in);
        for (;;){
            System.out.println("What would you like to do?");
            input = s.next();
            switch (input) {
                case "1":
                    System.out.println("Please enter a 64 bits sequence");
                    input = s.next();
                    b = bitVector.bitVectorFromString(input);
                    System.out.println("The initial permutation of the entered bit sequence is \n" + Permutation.initialPermutation(b).getRep());
                    break;
                case "2":
                    System.out.println("Please enter a 64 bits sequence");
                    input = s.next();
                    b = bitVector.bitVectorFromString(input);
                    System.out.println("The inverse permutation of the entered bit sequence is \n" + Permutation.inversePermutation(b).getRep());
                    break;
                default:
                    break;
            }
        }
        

    }
}
