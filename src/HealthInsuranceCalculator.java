public class HealthInsuranceCalculator {

    private final static double TAX_PERCENT = 3.4545;

    public double calculate(UserPayInfo payInfo) {
        return payInfo.calculateInsuranceAmount(TAX_PERCENT);
    }

}
