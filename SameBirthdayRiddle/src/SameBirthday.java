import java.util.Random;

public class SameBirthday {
    final int YEAR = 365;
    private int trials;
    private int people;
    SameBirthday(int trials, int people) { //생성자. 시도 횟수와 사람 수 저장
        this.trials = trials;
        this.people = people;
    }

    public void simulation() { //시도 횟수만큼 반복 시행
        int success = 0;
        double rob;
        for(int i = 0; i < trials; i++) {
            if(oneSimulation() == true) {
                System.out.println("겹침");
                success++;
            } else {
                System.out.println("겹치지 않음");
            }
        }
        rob = robability();
        System.out.println("확률:" + String.format("%.6f", rob) + "   예상 결과: " + String.format("%.0f", (rob * trials)) + "/" + trials);
        System.out.println("실제 시뮬레이션 결과: " + success + "/" + trials + "(성공 횟수/실행 횟수)");
    }

    private boolean oneSimulation() { //한 번 시행 시뮬레이션
        Random random = new Random();
        int array[] = new int[people];

        for(int i = 0; i < people; i++) { //사람마다 1~365 중 랜덤 수 배정
            array[i] = random.nextInt(YEAR) + 1;
        }

        for(int i = 0; i < people - 1; i++) { //가장 중요 부분. 생일을 비교한다.
            for(int y = i + 1; y < people; y++) {
                if(array[i] == array[y]) {
                    return true;
                }
            }
        }
        return false;
    }

    private double robability() { //공식에 따른 예상 결과를 계산한다
        if(people <= 1) {
            return 0;
        } else if (people >= YEAR) {
            return 1;
        }
        return 1 - (molecule()/denominator());
    }
    private double molecule() {
        double mol = 1;
        for(int i = 1; i < people; i ++) {
            mol *= YEAR - i;
        }
        return mol;
    }
    private double denominator() {
        double den = 1;
        for(int i = 1; i < people; i++) {
            den *= YEAR;
        }
        return (double)den;
    }
}
