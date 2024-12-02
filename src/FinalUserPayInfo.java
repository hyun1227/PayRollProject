public class FinalUserPayInfo {

    private final String name;
    private final double amount;

    private FinalUserPayInfo(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public static FinalUserPayInfo of(String name, double amount) {
        return new FinalUserPayInfo(name, amount);
    }

    @Override
    public String toString() {
        return "FinalUserPayInfo{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }

}
