package tfreese.de.eanvalidator;

public class Ean {
    private String ean;

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean.trim();
    }

    public boolean isValid() {
        if (ean.length() == 13) {
            int sum1 = 0;
            int sum2 = 0;
            int sumTotal = 0;

            for (int i = 0; i < ean.length() - 1; i += 2) {
                sum1 += Character.getNumericValue(ean.charAt(i));
                sum2 += Character.getNumericValue(ean.charAt(i + 1));
            }
            sumTotal = sum1 + sum2 * 3;
            int checkDigit = (10 - sumTotal % 10) % 10;
            return checkDigit == Character.getNumericValue(ean.charAt(12));
        } else {
            return false;
        }
    }
}
