package GraphicsGames;


import java.util.Random;

public class Screen extends  Render {
    private  Render testSC;

    public Screen(int width, int height){
        super(width, height);
        Random random = new Random();
        testSC = new Render(254, 254);
        for(int  i = 0; i < 254*254; i++){
            testSC.pixels[i] = random.nextInt();
        }
    }

    public void render(){
        draw(testSC, 0,0);
    }
}
