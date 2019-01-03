/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catching;

/**
 *
 * @author bick
 */
import java.io.File;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Random;


/**
 *
 * @author bick
 */
public class HiloComida extends Thread{
    
    JLabel comi1 = new JLabel();
    JLabel chang = new JLabel();
    JLabel punt1 = new JLabel();
    JLabel vid1 = new JLabel();
    public Juego j;
    Random num = new Random();
    int alea =  (int)(num.nextDouble() * 530 + 30);
    
    
    public HiloComida(JLabel co1, JLabel ch, JLabel pun, JLabel vid)
    {
        comi1 = co1;
        chang = ch;
        punt1 = pun;
        vid1 = vid;
    }
    
    
    
    public void validar()
    {
        int changoX = (int)chang.getLocation().getX();
        int comidaY = (int)comi1.getLocation().getY();
        int p = 0;
        int chanX =0; 
        chanX = alea - 30;
        if(comidaY==440 && (changoX==chanX || changoX==chanX-1 || changoX==chanX-2 
                || changoX==chanX-3 || changoX==chanX-4|| changoX==chanX-5 || changoX==chanX-6
                || changoX==chanX-7 || changoX==chanX-8|| changoX==chanX-9 || changoX==chanX-10
                || changoX==chanX-11 || changoX==chanX-12 || changoX==chanX-13 || changoX==chanX+1
                || changoX==chanX+2 || changoX==chanX+3|| changoX==chanX+4 || changoX==chanX+5
                || changoX==chanX+6 || changoX==chanX+7|| changoX==chanX+8 || changoX==chanX+9
                || changoX==chanX+10 || changoX==chanX+11 || changoX==chanX+12 || changoX==chanX+13))
        {
            
            comi1.setVisible(false);
            Juego.puntos= Juego.puntos+1;
            System.out.println("Puntos sumados " + Juego.puntos);
            punt1.setForeground(new java.awt.Color(0,102,0));
            punt1.setFont(new java.awt.Font("Comic Sans MC", 1, 18));;
            punt1.setText("Puntos: " + Juego.puntos);
            this.interrupt();
            
            if(this.interrupted())
            {
                System.out.println("Hilo detenido");
                
            }
            else
            {
                System.out.println("Hilo no detenido ");
            }
            j.reinicioHilo();
            
        }
        else if(comidaY == 550)
        {
            comi1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/manzane.png")).getImage()));
            Juego.vidas = Juego.vidas-1;
            System.out.println("Vidas perdidas " + Juego.vidas);
            vid1.setText("Vidas: ");
        }
        
    }
    
    
    
    public void run()
    {
        System.out.println("Posicion y " + alea);
        int comidaY = (int)comi1.getLocation().getY(); 
        for(int y = 90 ; y < 600 ; y++)
        {
            comi1.setLocation(alea,y);
            validar();
            try
            {
                Thread.sleep(17);
                
            }
            catch (InterruptedException ex)
            {
                System.out.println("Error hilo1");
            }
            
        }
    }
    
}
