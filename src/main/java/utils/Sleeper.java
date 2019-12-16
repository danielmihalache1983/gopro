package utils;

public class Sleeper {

    public static void silentSleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
