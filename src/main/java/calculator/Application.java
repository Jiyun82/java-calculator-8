package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String sep = " ";

        if (Character.isDigit(input.charAt(0))) { // 기본 구분자
            input = input.replace(',', ' ').replace(':', ' ');
        } else if (input.startsWith("//")) { // 커스텀 구분자
            if (input.indexOf("\\n") != 3) {
                throw new IllegalArgumentException();
            }
            sep = input.substring(2, 3);
            input = input.substring(5);
        } else { // 그 외
            throw new IllegalArgumentException();
        }

    }
}
