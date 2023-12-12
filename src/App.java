import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends JFrame implements Runnable{

    int width = 800;
    int height = 800;
    int tcelda = 150;
    int desplazamiento = 170;
    Control control;
    
    Image cross=this.cargarImagen("cross.png");
    Image circle=this.cargarImagen("circle.png");

    BufferedImage bi = new BufferedImage(this.width,this.height,BufferedImage.TYPE_4BYTE_ABGR);
    Graphics2D g2d = (Graphics2D) bi.getGraphics();
    ArrayList<myRectangle> zonapulsable = new ArrayList<myRectangle>();
   
    public Image cargarImagen(String nombre){
        Image image=new ImageIcon(this.getClass().getResource(nombre)).getImage();
        return image;
    }

    public void crearZonaPulsable(Graphics g){
        for (int i = 0; i < control.tablero[0].length; i++) {
            for (int j = 0; j < control.tablero.length; j++) {
              Rectangle2D rect = new Rectangle(desplazamiento+(i*tcelda),desplazamiento+(j*tcelda),tcelda,tcelda);
              myRectangle mrect = new myRectangle(rect,i,j);
              this.zonapulsable.add(mrect);
            }
         }
    }

    public void pintarCasillas(Graphics g){
        Graphics2D g2d2 = (Graphics2D) g;
        for(myRectangle mrect: control.getLcasillas()){
            g2d2.setColor(Color.WHITE);
            g2d2.draw(mrect.getRect());
        }
    }

    public void píntarFondo(Graphics g){
        for (int i = 0; i < 100; i++) {
            Color c = new Color(34+i, 53, 177  );
            g.setColor(c);
            g.fillRect(0, i*8, this.width, this.height);
        }
    }

    public void pintarSimbolo(Graphics g){
        for(int i=0;i<control.tablero[0].length;i++){
                for(int j=0;j<control.tablero.length;j++){
                    if(control.tablero[i][j]==0){
                        g.drawImage(circle,desplazamiento+(i*tcelda),desplazamiento+(j*tcelda), tcelda, tcelda, this);
                    }
                    if(control.tablero[i][j]==1){
                        g.drawImage(cross,desplazamiento+(i*tcelda),desplazamiento+(j*tcelda), tcelda, tcelda, this);
                    } 
                }
        }
    }

    @Override
    public void paint(Graphics g){
        this.píntarFondo(g2d);
        this.pintarCasillas(g2d);
        this.pintarSimbolo(g2d);
        g.drawImage(bi,10,10,this.width,this.height,this);

    }
    
    //constructor
    public App(){
        this.setSize(this.height,this.width);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("EL JUEGO DEL GATO");
        control = new Control();
        this.crearZonaPulsable(g2d);
        control.setLcasillas(zonapulsable);
        this.addMouseListener(control);
        Thread hilo = new Thread(this);
        hilo.start();
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
            control.ejecutarFrame();
            repaint();
        }
    }
}
