package homeWorks.Task1;

import java.sql.Array;

public class Main {
    public static int[] counter = new int[2];


    private static boolean checkThree(int number) {
        return Integer.toString(number).contains("3");
    }

    private static synchronized void increaseCounter(int index) {
        counter[index]++;
    }

    public static void countNumbers(int startValue, int maxValue, int index) {
        for (int i = startValue; i < maxValue; i++) {
            if (i % 21 == 0 && checkThree(i)) {
                increaseCounter(index);
            }

        }
    }

    public static void main(String[] args) {
        counter[0] = 0;
        counter[1] = 0;


        countNumbers(1, 2_000_000, 0);

        System.out.println(counter[0] +
                " numbers from this range of 1 - 2 000 000 are divisible by 21 and contain the digit 3");

        countNumbers(1, 1_000_000, 1);

        Thread2 thread2 = new Thread2();

        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter[1] + " numbers from this range of 1 - 2 000 000 are divisible by 21 and contain the digit 3");


    }
}
