package src;
import java.util.*;

public class Interpreter {
    public static void main(String[] args) {
        System.out.println("Welcome, what would you like to do?");
        System.out.println("1 calculate the Initial Permutation of a 64 bits sequence");
        System.out.println("2 calculate the Inverse Permutation of a 64 bits sequence");
        System.out.println("3 calculate the key value of a single round");
        System.out.println("4 calculate the cipher value for a single round");
        System.out.println("5 calculate the Feistel function output for a single round");
        System.out.println("0 exit");
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
                    b = new bitVector(input);
                    System.out.println("The initial permutation of the entered bit sequence is \n" + Permutation.initialPermutation(b).getRep());
                    break;
                case "2":
                    System.out.println("Please enter a 64 bits sequence");
                    input = s.next();
                    b = new bitVector(input);
                    System.out.println("The inverse permutation of the entered bit sequence is \n" + Permutation.inversePermutation(b).getRep());
                    break;
                case "3":
                    System.out.println("Please enter a 64 bits sequence");
                    input = s.next();
                    b = new bitVector(input);
                    //System.out.println("The inverse permutation of the entered bit sequence is \n" + Permutation.inversePermutation(b).getRep());
                    break;  
                case "4":
                    System.out.println("Please enter a 64 bits sequence");
                    input = s.next();
                    b = new bitVector(input);
                    //System.out.println("The inverse permutation of the entered bit sequence is \n" + Permutation.inversePermutation(b).getRep());
                    break;
                case "5":
                    System.out.println("Please enter a 64 bits sequence representing the bitVector");
                    input = s.next();
                    b = new bitVector(input);
                    System.out.println("Please enter a 48 bits sequence representing the key");
                    input = s.next();
                    bitVector c = new bitVector(input);
                    Feistel d = new Feistel(b, c);
                    System.out.println("A single Feistel round with the given parameters yields: " + d.getOutput());
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Input invalid, retry");
                    break;
            }
        }
        

    }
}
