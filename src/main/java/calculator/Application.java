package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (Character.isDigit(input.charAt(0))) { // 기본 구분자
            System.out.println("기본");
        } else if (input.startsWith("//")) { // 커스텀 구분자
            System.out.println("커스텀");
        } else { // 그 외
            throw new IllegalArgumentException();
        }

    }
}
