/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package catching;
import java.io.File;
import java.awt.Color;
import javax.swing.JProgressBar;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 *
 * @author Dulce
 */
public class Hilocatch extends Thread  {
    
    
       
   JProgressBar barrac;
   Intro intr;
   BasicPlayer sonido;
   String archivo = "C:\\Users\\Dulce\\Documents\\NetBeansProjects\\Catching\\src\\sonido\\intro.mp3";
        
    public Hilocatch(JProgressBar baca,Intro ino){
   barrac=baca;
   intr=ino;

}

    public void iniciarSonido()
    {
        try
        {
            sonido = new BasicPlayer();
            sonido.open(new File(archivo));
            sonido.play();
        }
        catch(BasicPlayerException ex)
        {
            System.out.println("Error iniciar sonido" + ex);
        }
    }
    
    public void detenerSonido()
    {
        try
        {
            sonido.open(new File(archivo));
            sonido.stop();
        }
        catch(BasicPlayerException ex)
        {
            System.out.println("Error deneter sonido" + ex);
        }
    }


public void run(){
    iniciarSonido();
  for(int i=0;i<=100;i++){
  
      barrac.setValue(i);
      if(i>0 && i<=50){
          barrac.setForeground(Color.RED);
      }else if (i>50){
          
           barrac.setForeground(Color.YELLOW);
      }
  try {
      Thread.sleep(60);
   }catch (InterruptedException ex){
        System.out.println("Error de hilo Intro");
   }
}
  
  barrac.setForeground(Color.GREEN);
  detenerSonido();
  menu j = new menu();
  j.setBounds(30,30,560,400);
  j.setLocationRelativeTo(null);
  j.setVisible(true);
  intr.setVisible(false);
  
  
   /*Nivel2 n = new Nivel2 ();
 n.setBounds(30,30,700,710);
  n.setVisible(true);
  j.setVisible(false);*/
 
}
}



