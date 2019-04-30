package caesar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printWelcomeMessage();
        switch (getUserResponse(scanner, "Please Enter an Option?")) {
            case 1:
                System.out.println("Great let's make gibberish.");
                CaesarEncoder encoder = new CaesarEncoder();
                encoder.startEncodingProcess(scanner);
                break;
            case 2:
                //CaesarDecoder decoder = new CaesarDecoder();
                //decoder.startDecodingProcess(scanner);
                break;
            case 3:
                //CrackThatAlgorithmCracker cracker = new CrackThatAlgorithmCracker();
                //cracker.startCrackThatAlgorithm(scanner);
                break;
            default:
                System.out.println("I'm going to totally disregard your input because you are dumb. Bye!");
                break;
        }

    }

    private static int getUserResponse(Scanner scanner, String s) {
        System.out.println(s);
        return scanner.nextInt();
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome To The Caeser Cipher");
        System.out.println("We now have 3 options for you");
        System.out.println("1. Create your own cipher key, and then encode some text (Encoding)");
        System.out.println("2. Decode some text with the key you already know.");
        System.out.println("3. Crack That. The Best Cracking Algorithm to ever Crack Julius Caesar.");
    }

}
