public class NationalPensionCalculator {

    private final static double TAX_PERCENT = 4.5;

    public double calculate(UserPayInfo payInfo) {
        return payInfo.calculateInsuranceAmount(TAX_PERCENT);
    }

}
