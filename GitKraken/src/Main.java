import java.util.concurrent.atomic.AtomicInteger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for(int i=0; i<100; i++){
            Thread temp = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0; i<1000000; i++)
                        atomicInteger.getAndAdd(1);
                }
            });
            temp.start();
        }
        Thread.sleep(10000);
        System.out.println(atomicInteger.toString());
    }
}