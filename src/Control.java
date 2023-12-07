
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.geom.Point2D;

public class Control implements MouseListener{

   final int size = 3;
   int[][] tablero = new int[size][size];
   int boton;
   ArrayList<myRectangle> zonapulsable = new ArrayList<myRectangle>();

   //constructor
   public Control(){
      this.crearTablero();
   }

   public void crearTablero(){
      for (int i = 0; i < tablero[0].length; i++) {
         for (int j = 0; j < tablero.length; j++) {
            tablero[i][j] = -1;
         }
      }
   }
   
   public void getCasilla(Point punto){
      Point2D p2d = punto;
      for(myRectangle mrect:this.getLcasillas()){
         if(mrect.getRect().contains(p2d)){
            /* System.out.println("tablero["+mrect.getPosx()+ "]["+mrect.getPosy()+"]"); */
            System.out.println("tablero["+mrect.getPosy()+ "]["+mrect.getPosx()+"]");
            if (boton == 1) {
            System.out.println("BOTON IZQUIERDO");
               tablero[mrect.getPosx()][mrect.getPosy()]=0;
            }
            if (boton == 3) {
               System.out.println("BOTON DERECHO");
                tablero[mrect.getPosx()][mrect.getPosy()]=1;
            }
         }
      }
   }
   
   public ArrayList<myRectangle> getLcasillas() {
      return zonapulsable;
   }

   public void setLcasillas(ArrayList<myRectangle> zonapulsable) {
      this.zonapulsable = zonapulsable;
   }

   public int[][] getTablero() {
      return tablero;
   }


   public void setTablero(int[][] tablero) {
      this.tablero = tablero;
   }


   //metodos abstractos
   @Override
   public void mouseClicked(MouseEvent e) {
     
   }

   @Override
   public void mousePressed(MouseEvent e) {
      Point punto = e.getPoint();
      boton = e.getButton();
      System.out.println("estas presionando este boton "+boton);
      this.getCasilla(punto);
   }

   @Override
   public void mouseReleased(MouseEvent e) {
     
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      
   }

   @Override
   public void mouseExited(MouseEvent e) {
      
   }


   
}
