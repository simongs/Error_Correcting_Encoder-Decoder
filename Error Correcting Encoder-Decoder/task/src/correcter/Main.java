package correcter;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String ALPHANUMERIC_CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();

        for (int i = 0; i < input.length; i += 3) {
            int range = random.nextInt(Math.min(3, input.length - i));

            input[i + range] = getRandomAlphaNum();
        }

        System.out.println(input);

    }

    private static String encrypt(String substring) {
        char[] chars = substring.toCharArray();
        chars[random.nextInt(3)] = getRandomAlphaNum();
        return new String(chars);
    }

    private static char getRandomAlphaNum() {
        int randomIndex = random.nextInt(ALPHANUMERIC_CHARACTERS.length());
        char[] chars = ALPHANUMERIC_CHARACTERS.toCharArray();
        return chars[randomIndex];
    }

    public void test() {
        String next = "";

        int loopCount = (next.length() / 3) + 1;
        if (next.length() % 3 == 0) {
            loopCount--;
        }

        // 단어를 3개씩 나누는 방법
        // String[] parts = line.split("(?<=\\G.{3})");

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < loopCount; i++) {
            int startIndex = i * 3;
            int endIndex = (i+1) * 3;

            if (endIndex > next.length()) {
                builder.append(next.substring(startIndex));
            } else {
                String substring = next.substring(startIndex, endIndex);
                String encrypt = encrypt(substring);
                builder.append(encrypt);
            }

        }

        System.out.println(builder.toString());
    }
}
