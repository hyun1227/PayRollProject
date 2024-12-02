public class PayRoll
{
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        PayRollMachine controller = new PayRollMachine(inputView, outputView);

        controller.run();
    }

}