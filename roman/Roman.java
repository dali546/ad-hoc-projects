import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Roman {


    public static void main(String[] args) throws IOException {
        List<String> romanNumeralsList = Files.readAllLines(Paths.get("roman/test.txt"));

        Map<String, Integer> romanMap =
                romanNumeralsList.stream().collect(Collectors.toMap(x -> x, Roman::convertRtoInt, (integer, integer2) -> integer));

        romanMap.forEach((s, integer) -> {
            if (integer != 0) System.out.printf("Roman Numeral %s has a value of: %s. \n", s, integer);
            else System.out.printf("Roman Numeral %s is not a valid Numeral. \n", s);
        });

    }

    private static Integer convertRtoInt(String romanNumeral) {
        int convertedInt = 0;
        AtomicBoolean isValid = new AtomicBoolean(true);

        List<RomanNumerals> numeralCharList = romanNumeral.chars()
                .mapToObj(e -> RomanNumerals.valueOf(String.valueOf((char) e)))
                .collect(Collectors.toList());

        convertedInt = getConvertedInt(convertedInt, isValid, numeralCharList);

        validate(numeralCharList, isValid);

        return isValid.get() ? convertedInt : 0;


    }

    private static int getConvertedInt(int convertedInt, AtomicBoolean isValid, List<RomanNumerals> numeralCharList) {
        for (int i = 0; i < numeralCharList.size(); i++) {
            RomanNumerals currentChar = numeralCharList.get(i);

            if (isCharacterPartOfSubtraction(currentChar, numeralCharList, i, isValid)) {
                // If Character is part of subtraction do not do any addition or subtraction. This will be handled by it's counterpart (next statement)
                if (!isValid.get()) break;
            } else if (isPrecedingCharacterASubtraction(currentChar, numeralCharList, i)) {
                convertedInt += currentChar.getNumericalValue() - numeralCharList.get(i - 1).getNumericalValue();
            } else {
                convertedInt += currentChar.getNumericalValue(); // Otherwise add the value to the total.
                if (!isValid.get()) break;
            }
        }
        return convertedInt;
    }


    private static void validate(List<RomanNumerals> numeralCharList, AtomicBoolean isValid) {
        if (numeralCharList.stream().filter(v -> v.equals(RomanNumerals.V)).count() >= 2) isValid.set(false);
        if (numeralCharList.stream().filter(l -> l.equals(RomanNumerals.L)).count() >= 2) isValid.set(false);
        if (numeralCharList.stream().filter(i -> i.equals(RomanNumerals.I)).count() >= 10) isValid.set(false);
        if (numeralCharList.stream().filter(x -> x.equals(RomanNumerals.X)).count() >= 10) isValid.set(false);
        if (numeralCharList.stream().filter(c -> c.equals(RomanNumerals.C)).count() >= 10) isValid.set(false);

        if (getConvertedInt(0,
                new AtomicBoolean(true),
                numeralCharList.stream()
                        .filter(romanNumerals -> romanNumerals != RomanNumerals.M)
                        .collect(Collectors.toList())) + 1 >= RomanNumerals.M.getNumericalValue()) isValid.set(false);
        if (getConvertedInt(0,
                new AtomicBoolean(true),
                numeralCharList.stream()
                        .filter(romanNumerals -> romanNumerals != RomanNumerals.M)
                        .filter(romanNumerals -> romanNumerals != RomanNumerals.D)
                        .filter(romanNumerals -> romanNumerals != RomanNumerals.C)
                        .collect(Collectors.toList())) >= RomanNumerals.C.getNumericalValue()) isValid.set(false);
        if (getConvertedInt(0,
                new AtomicBoolean(true),
                numeralCharList.stream()
                        .filter(romanNumerals -> romanNumerals != RomanNumerals.M)
                        .filter(romanNumerals -> romanNumerals != RomanNumerals.D)
                        .filter(romanNumerals -> romanNumerals != RomanNumerals.C)
                        .filter(romanNumerals -> romanNumerals != RomanNumerals.L)
                        .filter(romanNumerals -> romanNumerals != RomanNumerals.X)
                        .collect(Collectors.toList())) >= RomanNumerals.X.getNumericalValue()) isValid.set(false);
    }


    private static boolean isPrecedingCharacterASubtraction(RomanNumerals currentChar, List<RomanNumerals> numeralCharList, int index) {
        if (index - 1 >= 0) {
            switch (currentChar) {
                case M:
                case D:
                    return numeralCharList.get(index - 1).equals(RomanNumerals.C);
                case C:
                case L:
                    return numeralCharList.get(index - 1).equals(RomanNumerals.X);
                case X:
                case V:
                    return numeralCharList.get(index - 1).equals(RomanNumerals.I);
            }
        }
        return false;
    }

    private static boolean isCharacterPartOfSubtraction(RomanNumerals currentChar, List<RomanNumerals> numeralCharList, int index, AtomicBoolean isValid) {

        // This checks if input character is part of subtraction, and also invalidates string if preceded by itself

        if (index + 1 < numeralCharList.size()) { // If not at end
            switch (currentChar) {
                case I:
                    if (numeralCharList.get(index + 1).equals(RomanNumerals.X) || numeralCharList.get(index + 1).equals(RomanNumerals.V)) {
                        if (index - 1 >= 0 && numeralCharList.get(index - 1).equals(currentChar)) isValid.set(false);
                        else return true;
                    } else return false;
                case X:
                    if (numeralCharList.get(index + 1).equals(RomanNumerals.L) || numeralCharList.get(index + 1).equals(RomanNumerals.C)) {
                        if (index - 1 >= 0 && numeralCharList.get(index - 1).equals(currentChar)) isValid.set(false);
                        else return true;
                    } else return false;
                case C:
                    if (numeralCharList.get(index + 1).equals(RomanNumerals.D) || numeralCharList.get(index + 1).equals(RomanNumerals.M)) {
                        if (index - 1 >= 0 && numeralCharList.get(index - 1).equals(currentChar)) isValid.set(false);
                        else return true;
                    } else return false;
            }
        }
        return false;
    }

}