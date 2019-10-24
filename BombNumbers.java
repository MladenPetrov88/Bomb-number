import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }
        String[] bombs = scanner.nextLine().split("\\s+");

        int bombNumber = Integer.parseInt(bombs[0]);
        int power = Integer.parseInt(bombs[1]);
        int sum = 0;

        while (numbers.contains(bombNumber)) {
            int bombPosition = numbers.indexOf(bombNumber);
            int leftBound = Math.max(0, bombPosition - power);
            int rightBound = Math.min(numbers.size() - 1, bombPosition + power);

            for (int i = rightBound; i >= leftBound; i--) {
                numbers.remove(i);
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);
    }
}
