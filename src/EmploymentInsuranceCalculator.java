public class EmploymentInsuranceCalculator {

    private final static double TAX_PERCENT = 0.9;

    public double calculate(UserPayInfo payInfo) {
        return payInfo.calculateInsuranceAmount(TAX_PERCENT);
    }

}
