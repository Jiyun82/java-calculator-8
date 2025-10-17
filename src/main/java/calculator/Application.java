package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String sep = " ";
        double sum = 0;

        if (input.length() > 0) {
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

            // split 해서 더함
            if (input.length() > 0) {
                String[] parts = input.split(Pattern.quote(sep));
                for (String part : parts) {
                    if (!isNumberic(part)) {
                        throw new IllegalArgumentException();
                    }
                    double n = Double.parseDouble(part);
                    if (n < 0) {
                        throw new IllegalArgumentException();
                    }
                    sum += Double.parseDouble(part);
                }
            }

        }

        if (sum == Math.floor(sum)) {
            System.out.println("결과: " + (int) sum);
        } else {
            System.out.println("결과: " + sum);
        }

    }

    public static boolean isNumberic(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }

        return str.matches("[+-]?\\d*(\\.\\d+)?");
    }
}
