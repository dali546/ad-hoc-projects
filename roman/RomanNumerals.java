package roman;

public enum RomanNumerals {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int romanNumber;

    RomanNumerals(int romanNumber) {
        this.romanNumber = romanNumber;
    }

    public int getNumericalValue() {
        return this.romanNumber;
    }

}
