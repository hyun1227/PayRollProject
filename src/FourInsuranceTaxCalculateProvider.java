public class FourInsuranceTaxCalculateProvider implements TaxCalculateProvider {

    private final static NationalPensionCalculator NATIONAL_PENSION_CALCULATOR = new NationalPensionCalculator();
    private final static HealthInsuranceCalculator HEALTH_INSURANCE_CALCULATOR = new HealthInsuranceCalculator();
    private final static EmploymentInsuranceCalculator EMPLOYMENT_INSURANCE_CALCULATOR = new EmploymentInsuranceCalculator();

    public FinalUserPayInfo calculate(UserPayInfo payInfo) {
        double nationalPensionAmount = NATIONAL_PENSION_CALCULATOR.calculate(payInfo);
        double healthInsuranceAmount = HEALTH_INSURANCE_CALCULATOR.calculate(payInfo);
        double employmentInsuranceAmount = EMPLOYMENT_INSURANCE_CALCULATOR.calculate(payInfo);

        double totalInsuranceAmount = nationalPensionAmount + healthInsuranceAmount + employmentInsuranceAmount;

        return payInfo.subtractInsuranceAmount(totalInsuranceAmount);
    }

}
