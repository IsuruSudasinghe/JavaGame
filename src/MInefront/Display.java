package MInefront;


import GraphicsGames.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class Display extends Canvas implements Runnable {
    private static final int height = 600;
    private static final int width = 800;
    private static final String title = "Test Game 1.0";


    private Thread thread;
    private Screen screen;
    private BufferedImage img;

    private boolean running = false;
    private int[] pixels;


    private Display() {
        screen = new Screen(width, height);
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
    }

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

    private void tick() {
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.render();

        for (int i = 0; i < width * height; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();
        bs.show();

    }

    public void run() {
        while (running) {
            tick();
            render();
        }
    }
}
