package MInefront;


import GraphicsGames.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class Display extends Canvas implements Runnable {
    public static final int height = 600;
    public static final int width = 800;
    private static final String title = "Test Game 1.0";
    private static Dimension size;
    private Thread thread;
    private Screen screen;
    private BufferedImage img;
    private Game game0;
    private boolean running = false;
    private int[] pixels;


    private Display() {
        game0 = new Game();

        screen = new Screen(width, height);
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
    }

    public static void main(String[] args) {

        Display game = new Display();
        JFrame window = new JFrame();
        window.add(game);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        window.setTitle(title);

        size = new Dimension(width, height);
        window.setPreferredSize(size);
        window.setMaximumSize(size);
        window.setMinimumSize(size);
        window.setSize(size);

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
        game0.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.render(game0);

        for (int i = 0; i < width * height; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();
        bs.show();

    }

    public void run() {
        int frames = 0;
        double unprocessedSeconds;
        long previousTime = System.nanoTime();
        double secondsPerTick = 1 / 60.0;
        int tickCount = 0;
        boolean ticked = false;

        while (running) {
            long currentTime = System.nanoTime();
            long passedTime = currentTime - previousTime;
            previousTime = currentTime;
            unprocessedSeconds = passedTime / 1000000000.0;

            while (unprocessedSeconds > secondsPerTick) {
                tick();
                unprocessedSeconds -= secondsPerTick;
                ticked = true;
                tickCount++;

                if (tickCount % 60 == 0) {
                    System.out.println( frames + "fps");
                    previousTime += 1000;
                    frames = 0;
                }
            }

            if(ticked){
                render();
                frames++;
            }

            render();
            frames++;
        }
    }
}
