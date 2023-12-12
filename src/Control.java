
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.geom.Point2D;
import javax.swing.JOptionPane;

public class Control implements MouseListener{

   final int size = 3;
   int[][] tablero = new int[size][size];
   int boton;
   Point punto;
   int ganador;
   boolean turno=true;
   boolean botonpulsado=false;
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

   public int calcularTablero(){
      if((tablero[0][0]!=-1)&&(tablero[0][0]==tablero[1][1])&&(tablero[1][1]==tablero[2][2])){//diagonal principal
          return tablero[1][1];
      }
       if((tablero[2][0]!=-1)&&(tablero[2][0]==tablero[1][1])&&(tablero[1][1]==tablero[0][2])){//diagonal principal
          return tablero[1][1];
      }
       int n=this.calcularLinea();
       int m=this.calcularColumuna();
       if(n!=-1){
           return n;
       }
       if(m!=-1){
           return m;
       }
      
      return -1;   
   }

   public boolean fin(){
      return (this.isCompleto())||(this.calcularTablero()!=-1);
   }
   
   public boolean isCompleto(){
      boolean condicion=true;
       for(int i=0;i<tablero[0].length;i++){//recorremos el tablero
          for(int j=0;j<tablero.length;j++){
              if(tablero[i][j]==-1){
                  condicion=false;
              }
          }
       }
       return condicion;
   }

   public int calcularLinea(){
   boolean condicion=false;
   int i=0;
   int resul=-1;
      while((condicion==false)&&(i<tablero[0].length)){
      if((tablero[0][i]!=-1)&&(tablero[0][i]==tablero[1][i])&&(tablero[1][i]==tablero[2][i])){//diagonal principal
      resul=tablero[0][i];
      condicion=true;
         }
      i++;
      }
      if (condicion==true){
         return resul;
      }else
      return -1;
   }



   //pseudocodigo
/*    MiniMax()  
      best.mv = [not yet defined]  
      best.score = -99999  
      For each legal move m  
      { 
         make move m.mv on Board   
         m.score = MIN   
         if (m.score > best.score) then best = m   
         retract move m.mv on Board  
      }  
      Make move best.mv 
      ----------------------------------------  
      MAX()  if (game over) return EVAL-ENDING  
      else if (max depth) return EVAL  
      else   best.score = -99999
         for each computer legal move m   
         { make move m.mv on Board    
            m.score = MIN    
            if (m.score > best.score) then best = m    
            retract move m.mv on Board   
         }   
      return best.score  
      
      ----------------------------------------
      MIN()  if (game over) return EVAL-ENDING  
      else if (max depth) return EVAL  
      else   best.score = 99999   
      for each human legal move m.mv   
      { make move m.mv on Board    
         m.score = MAX    
         if (m.score < best.score) then best = m    
         retract move m.mv on Board   
      }   
      return best.score  */

   public void minmax(){
       
      int filaoptima=0;
      int columnaoptima=0;
      int valorOptimo=-99999;
      int aux;
      //TERMINAR
       /* for (int index = 0; index < array.length; index++) {
         for (int index = 0; index < array.length; index++) {
            
         }
       } */
        
        tablero[filaoptima][columnaoptima]=1;
  }


   public int min(){
      if(this.fin()){
         if(this.calcularTablero()!=-1){
            return 1;
            }else{
            return 0;
         }
      }
   
      int valorOptimo=99999;
      int aux;
      //TERMINAR
     /*  for (int index = 0; index < array.length; index++) {
         for (int index = 0; index < array.length; index++) {
            
         }
       } */
    return valorOptimo;
   }

   public int max(){
      if(this.fin()){
          if(this.calcularTablero()!=-1){
              return -1;
            }else{
              return 0;
          }     
      }
      int valorOptimo=-99999;
      int aux;
        for(int i=0;i<tablero[0].length;i++){//recorremos el tablero
           for(int j=0;j<tablero.length;j++){
               if(tablero[i][j]==-1){
                   tablero[i][j]=1;
                   aux=min();
                   if(aux>valorOptimo){
                       valorOptimo=aux;
                   }
                   tablero[i][j]=-1;
               }
           }
        }
       return valorOptimo;
   }

   public int calcularColumuna(){
      for(int i=0;i<tablero.length;i++){
         if((tablero[i][0]!=-1)&&(tablero[i][0]==tablero[i][1])&&(tablero[i][1]==tablero[i][2])){//diagonal principal
         return tablero[i][0];
            }
         }
      return -1;
   }


   public void ejecutarFrame(){
      if(!this.fin()){
         if(turno==true){//si me toca
         if(this.botonpulsado){
            if(this.getCasilla(punto)){// si se ppuede pulsar esa casilla la marca y devuelve true si se ha podido marcar una casilla
               botonpulsado=false;
               turno=false;
            }
         }else{
               
         }
      }else{
      this.minmax();
      turno=true;
      }
      }else{
         int n=this.calcularTablero();
         String ganador="";
         if (n==1){
            ganador="PC";
         }else if (n==0){
            ganador="Usuario";
         }else{
            ganador="Empate";
         }
         JOptionPane.showMessageDialog(null,"ha ganadoo el Jugador"+ganador);
         this.crearTablero();
      }
   }


   public boolean getCasilla(Point punto){
      Point2D p2d=punto;
      boolean condicion=false;
      for(myRectangle mrect:this.getLcasillas()){
         if(mrect.getRect().contains(p2d)){  
         System.out.print("tablero["+mrect.getPosx()+ "]["+mrect.getPosy()+"]==");
         if(tablero[mrect.getPosx()][mrect.getPosy()]==-1){
               tablero[mrect.getPosx()][mrect.getPosy()]=0;
               condicion=true;
         }
         }
      }
         return condicion;
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
      punto=e.getLocationOnScreen();
      botonpulsado=true;
      /* punto = e.getPoint();
      boton = e.getButton();
      System.out.println("estas presionando este boton "+boton);
      this.getCasilla(punto); */
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      botonpulsado=false;
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      
   }

   @Override
   public void mouseExited(MouseEvent e) {
      
   }


   
}
