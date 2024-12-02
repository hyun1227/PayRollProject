import java.util.List;

public class PayRollMachine {

    private final InputView inputView;
    private final OutputView outputView;

    public PayRollMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<UserPayInfo> payInfos = inputView.getUserPayInfosFromFile();

        TaxCalculate taxCalculate = new TaxCalculate(payInfos);
        List<FinalUserPayInfo> finalPayInfos = taxCalculate.calculate();

        outputView.showPayInfos(finalPayInfos);
    }

}
