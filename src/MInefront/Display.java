package MInefront;

import javax.swing.*;
import java.awt.*;


public class Display extends Canvas implements Runnable {
    private static final int height = 400;
    private static final int width = 800;
    private static final String title = "Test Game 1.0";


    private Thread thread;
    private boolean running = false;

    public static void main(String[] args) {
        Display game = new Display();
        JFrame window = new JFrame();
        window.add(game);
        window.setSize(width, height);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        window.setTitle(title);

        game.start();
    }

    private void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    private void stop() {
        if (!running) return;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    public void run() {
        while (running) {
            System.out.println("Running...");
        }
    }
}
