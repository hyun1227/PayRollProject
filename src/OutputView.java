import java.util.List;

public class OutputView {

    // 급여 계산 결과를 콘솔에 출력하는 메서드
    public void showPayInfos(List<FinalUserPayInfo> finalPayInfos) {
        // 결과가 없으면 출력하지 않음
        if (finalPayInfos == null || finalPayInfos.isEmpty()) {
            System.out.println("출력할 급여 정보가 없습니다.");
            return;
        }

        // 결과 출력
        for (FinalUserPayInfo finalPayInfo : finalPayInfos) {
            System.out.println(finalPayInfo);  // toString()을 사용해 보기 쉽게 출력
        }
    }
}
