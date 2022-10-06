import java.util.Scanner;

public class simulator {
    public static void main(String[] args) { //main메소드
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("사람 수와 시뮬레이션 횟수 입력(-1 입력 시 종료): ");

            int people = scanner.nextInt();
            if(people == -1) {
                break;
            }
            int trials = scanner.nextInt();

            SameBirthday sb = new SameBirthday(trials, people);
            sb.simulation();
        }

        scanner.close();
    }
}
