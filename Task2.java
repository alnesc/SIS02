import java.text.SimpleDateFormat;
import java.util.Date;

public class Task2 extends Thread {
    public static   int examSheets = 500;

    @Override
    public void run() {
        while (true) {
            synchronized (Task2.class) {
                if (examSheets <= 0) {
                    System.out.println("There is no any exam shheet left! All papers was already checked");
                    break;
                }

                examSheets -= 50;
                System.out.println(Thread.currentThread().getName() + " finish check, at: " +
                        new SimpleDateFormat("E MMM dd HH:mm:ss  yyyy").format(new Date()) +
                        ", sheets is now " + examSheets);
            }

            try {
                Thread.sleep(777);
            } catch (InterruptedException e) {
                System.err.println("Error");
            }
        }
    }

    public static void main(String[] args) {

        Task2 checker1 = new Task2();
        Task2 checker2 = new Task2();

        checker1.setName("Alibek");
        checker2.setName("Dana");

        checker1.start();
        checker2.start();
    }
}