import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.awt.Color;
public class App extends JFrame implements Runnable{

    int width = 800;
    int height = 800;
    int tcelda = 150;
    int desplazamiento = 170;


    BufferedImage bi = new BufferedImage(this.width,this.height,BufferedImage.TYPE_4BYTE_ABGR);
    Graphics2D g2d = (Graphics2D) bi.getGraphics();
   
    //constructor
    public App(){
        this.setSize(this.height,this.width);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("EL JUEGO DEL GATO");
    }

    public void píntarFondo(Graphics g){
        for (int i = 0; i < 100; i++) {
            Color c = new Color(26+i, 188, 156);
            g.setColor(c);
            g.fillRect(0, i+8, this.width, this.height);
        }
    }

    public void pintarSimbolo(){

    }

    public void paint(Graphics g){
        this.píntarFondo(g2d);
        g.drawImage(bi,10,10,this.width,this.height,this);

    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando juego");
        App juego = new App();
    }

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
