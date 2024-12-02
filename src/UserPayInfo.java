public class UserPayInfo {

    private final String name;
    private final double amountPerHour;
    private final double workedTime;
    private final boolean freelancer;

    public UserPayInfo(String name, double amountPerHour, double workedTime, boolean freelancer) {
        this.name = name;
        this.amountPerHour = amountPerHour;
        this.workedTime = workedTime;
        this.freelancer = freelancer;
    }

    public FinalUserPayInfo subtractInsuranceAmount(double subtractedAmount) {
        double calculatedTotalAmount = calculateTotalAmount();

        double subtractedTotalAmount = calculateSubtractAmount(calculatedTotalAmount, subtractedAmount);

        return FinalUserPayInfo.of(name, subtractedTotalAmount);
    }

    public boolean isFreelancer() {
        return freelancer;
    }

    private double calculateTotalAmount() {
        return amountPerHour * workedTime;
    }

    private double calculateSubtractAmount(double totalAmount, double subtractedAmount) {
        return totalAmount - subtractedAmount;
    }

}
