public class FreelancerTaxCalculateProvider implements TaxCalculateProvider {

    private static final double TAX_PERCENT = 3.3;

    public FinalUserPayInfo calculate(UserPayInfo payInfo) {
        double subtractedAmount = payInfo.calculateInsuranceAmount(TAX_PERCENT);
        return payInfo.subtractInsuranceAmount(subtractedAmount);
    }

}
