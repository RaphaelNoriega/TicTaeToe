
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Control implements MouseListener{

   final int size = 3;
   int[][] tablero = new int[size][size];
   ArrayList<myRectangle> zonapulsable = new ArrayList<myRectangle>();

   //constructor
   public Control(){

   }

   
   public int[][] getTablero() {
      return tablero;
   }


   public void setTablero(int[][] tablero) {
      this.tablero = tablero;
   }



   @Override
   public void mouseClicked(MouseEvent e) {
     
   }

   @Override
   public void mousePressed(MouseEvent e) {
      
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
