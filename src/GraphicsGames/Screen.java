package GraphicsGames;


import java.util.Random;

public class Screen extends Render {
    private Render testSC;


    public Screen(int width, int height) {
        super(width, height);
        Random random = new Random();
        testSC = new Render(254, 254);


        for (int i = 0; i < 254 * 254; i++) {
            testSC.pixels[i] = random.nextInt();
        }
    }

    public void render() {
        for (int i = 0 ; i < height * width; i++) pixels[i] = 0;
        int xAnim = (int) (Math.sin(System.currentTimeMillis() % 1000.00 / 500 * Math.PI * 2) * 2.5);
        int yAnim = (int) (Math.cos(System.currentTimeMillis() % 1000.00 / 1000 * Math.PI * 2) * 1.5);
        System.out.println("x: " + xAnim + "  y: " + yAnim + "   Sys time :" + (Math.sin(System.currentTimeMillis() % 1000.00)));

        draw(testSC, (width - 254) / 2 * xAnim, (height - 254) / 2 * yAnim );
    }

}
