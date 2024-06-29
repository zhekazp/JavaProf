package homeWorks.Task1;

public class Thread2 extends Thread{
    @Override
    public void run() {
        Main.countNumbers(1_000_001, 2_000_000,1);
    }
}
