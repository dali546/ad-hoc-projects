package caesar;

import java.util.*;

public class CaesarEncoder {

    private int key;
    private String input, output;
    private LinkedList<Character> cipher;

    public CaesarEncoder() {
        cipher = initialiseWithAlphabet();
    }

    private LinkedList<Character> initialiseWithAlphabet() {
        return new LinkedList<>(
                Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        );
    }

    public void startEncodingProcess(Scanner scanner) {
        System.out.println("Please Enter a key. enter a number between 1 - 26");
        key = Integer.parseInt(getKeyFromUser(scanner));
        input = getFreeText(scanner);
        System.out.println("K. You want me to encode this: " + input);
        System.out.println("Please Wait!");
        shiftCipher();
    }

    private String getKeyFromUser(Scanner scanner) {
        String tempKey = scanner.next();
        if (!tempKey.matches("([1-9]|1[0-9]|2[0-6])")) do {
            System.out.println("Eh eh. Enter between 1 - 26");
            tempKey = scanner.next();
        } while (!tempKey.matches("([1-9]|1[0-9]|2[0-6])"));
        return tempKey;
    }

    private void shiftCipher() {
        int shiftCount = key;
        while (shiftCount-- > 0) {
            cipher.addFirst(cipher.pollLast());
        }
        System.out.println(cipher);
    }

    private String getFreeText(Scanner scanner) {
        System.out.println("Ok. Got your cipher. Now Enter a text you'd like to encode");
        return scanner.next();
    }

}
