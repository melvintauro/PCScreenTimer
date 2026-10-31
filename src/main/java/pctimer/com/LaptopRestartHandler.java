package pctimer.com;

import java.io.FileWriter;
import java.io.IOException;

public class LaptopRestartHandler {

    public static void main(String[] args) {
        System.out.println("Application is running. Try restarting your Windows laptop...");

        // Register the shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Put the action you want to perform before the restart here
            performPreRestartAction();
        }));

        // Keeping the program alive to simulate a background service/app
        try {
            while (true) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Application interrupted.");
        }
    }

    private static void performPreRestartAction() {
        System.out.println("Windows restart/shutdown detected! Running cleanup code...");
        
        // Example action: Saving state or logging to a file
        try (FileWriter writer = new FileWriter("restart_log.txt", true)) {
            writer.write("System requested a restart/shutdown at: " + java.time.LocalDateTime.now() + "\n");
            writer.flush();
            System.out.println("State successfully saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
