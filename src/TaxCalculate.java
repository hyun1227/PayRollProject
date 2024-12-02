import java.util.ArrayList;
import java.util.List;

public class TaxCalculate {

    private static final TaxCalculateProvider FREELANCER_TAX_CALCULATE_PROVIDER = new FreelancerTaxCalculateProvider();
    private static final TaxCalculateProvider FOUR_INSURANCE_TAX_CALCULATE_PROVIDER = new FourInsuranceTaxCalculateProvider();

    private final List<UserPayInfo> payInfos;

    public TaxCalculate(List<UserPayInfo> payInfos) {
        this.payInfos = payInfos;
    }

    public List<FinalUserPayInfo> calculate() {
        List<FinalUserPayInfo> finalUserPayInfos = new ArrayList<>();
        FinalUserPayInfo userPayInfo = null;

        for (UserPayInfo payInfo : payInfos) {
            if (payInfo.isFreelancer()) {
                userPayInfo = FREELANCER_TAX_CALCULATE_PROVIDER.calculate(payInfo);
            } else {
                userPayInfo = FOUR_INSURANCE_TAX_CALCULATE_PROVIDER.calculate(payInfo);
            }
            finalUserPayInfos.add(userPayInfo);
        }

        return finalUserPayInfos;
    }

}
