import java.util.ArrayList;
import java.util.List;

public class December {
    public static int countThreads = 10;
    public static int[] testArray = new int[1000];

    static {
        for (int i = 0; i < December.testArray.length; i++) {
            testArray[i] = i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        initThreads();
    }

    public static class SortThread extends Thread {
        @Override
        public void run() {
            sort(testArray);
        }
    }

    public static void initThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<>(countThreads);
        for (int i = 0; i < countThreads; i++) {
            threads.add(new SortThread());
        }
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
    }
    public static void sort(int[] array){
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = 0; j <array.length ; j++) {
                if (array[i]<array[j]){
                    int k = array[i];
                    array[j]=k;
                }

            }

        }
    }
}
