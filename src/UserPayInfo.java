public class UserPayInfo {

    public static final int PERCENT_UNIT = 100;

    private final String name;
    private final double amountPerHour;
    private final double workedTime;
    private final boolean isFreelancer;

    public UserPayInfo(String name, double amountPerHour, double workedTime, boolean isFreelancer) {
        this.name = name;
        this.amountPerHour = amountPerHour;
        this.workedTime = workedTime;
        this.isFreelancer = isFreelancer;
    }

    public static UserPayInfo of(String name, double amountPerHour, double workedTime, boolean freelancer) {
        return new UserPayInfo(name, amountPerHour, workedTime, freelancer);
    }

    public FinalUserPayInfo subtractInsuranceAmount(double subtractedAmount) {
        double calculatedTotalAmount = calculateTotalAmount();

        double subtractedTotalAmount = calculateSubtractAmount(calculatedTotalAmount, subtractedAmount);

        return FinalUserPayInfo.of(name, subtractedTotalAmount);
    }

    public double calculateInsuranceAmount(double taxPercent) {
        return calculateTotalAmount() * taxPercent / PERCENT_UNIT;
    }

    public boolean isFreelancer() {
        return isFreelancer;
    }

    private double calculateTotalAmount() {
        return amountPerHour * workedTime;
    }

    private double calculateSubtractAmount(double totalAmount, double subtractedAmount) {
        return totalAmount - subtractedAmount;
    }
}
