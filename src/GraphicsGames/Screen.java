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
        for (int i = 0; i < height * width; i++) pixels[i] = 0;

        for (int i =0 ; i < 200; i ++   ) {
            int xAnim = (int) ((Math.sin(System.currentTimeMillis() + i) % 2000.0 /2000.0    * Math.PI * 2) * 200);
            int yAnim = (int) ((Math.cos(System.currentTimeMillis()+ i) % 2000.0 / 2000.0 * Math.PI * 2) * 200);

            draw(testSC, (width - 254) / 2 * xAnim, (height - 254) / 2 * yAnim);
            System.out.println("x: " + ((width - 254) / 2 * xAnim) + "  y: " + ((height - 254) / 2 * yAnim) + "   Sys time :" + (Math.sin(System.currentTimeMillis() + i)));

        }

    }

}
