public class PayRoll {

    public static void main(String[] args) {
        // InputView 객체 생성 (급여 정보를 입력받는 역할)
        InputView inputView = new InputView();

        // OutputView 객체 생성 (급여 계산 결과를 출력하는 역할)
        OutputView outputView = new OutputView();

        // PayRollMachine 객체 생성 (애플리케이션의 로직 제어)
        PayRollMachine controller = new PayRollMachine(inputView, outputView);

        // 프로그램 실행 (급여 정보 계산 및 출력)
        controller.run();
    }
}