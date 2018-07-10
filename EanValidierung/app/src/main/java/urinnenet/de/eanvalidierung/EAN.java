package urinnenet.de.eanvalidierung;

public class EAN {
    public EAN(String value) {
        this.value = value;
    }

    private String value;
    private boolean isValid = false;

    public void validationCheck() {
        do {
            int checkDigit = 0;
            if (value.length() == 13) {
                int sum1 = 0;
                int sum2 = 0;
                int sumTotal = 0;

                for (int i = 0; i < value.length() - 1; i += 2) {
                    sum1 += Character.getNumericValue(value.charAt(i)); // - 48;
                    sum2 += Character.getNumericValue(value.charAt(i + 1));
                }

                sumTotal = sum1 + sum2 * 3;
                int nearestNrDivisibleBy10 = sumTotal + 9 - (sumTotal + 9) % 10;
                checkDigit = nearestNrDivisibleBy10 - sumTotal;

                String output = "Die EAN " + value + " ist ";
                if (checkDigit == Character.getNumericValue(value.charAt(12)))
                    output += "gültig!";
                else
                    output += "nicht gültig!";
            }
            else {
                // error
            }
        } while (value != null);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
