/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catching;

import java.io.File;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Cesar
 */
public class HiloComida1 extends Thread{
    
    JLabel comi1 = new JLabel();
    JLabel chang = new JLabel();
    JLabel punt1 = new JLabel();
    int puntos1;
    Juego j;
    
    public HiloComida1(JLabel co1, JLabel ch, JLabel pun)
    {
        comi1 = co1;
        chang = ch;
        punt1 = pun;
    }
    
    public void validar()
    {
        int changoX = (int)chang.getLocation().getX();
        int comidaY = (int)comi1.getLocation().getY();
        
        if(comidaY==440 && changoX==40)
        {
            comi1.setVisible(false);
            puntos1++;
            punt1.setText("Puntos : " + puntos1);
        }
        
        changoX = (int)chang.getLocation().getX();
    }
    
    public void run()
    {
        int comidaY = (int)comi1.getLocation().getY();
        //EH.lanzar();
        for(int y = 90 ; y < 500 ; y++)
        {
            comi1.setLocation(70,y);
            validar();
            try
            {
                Thread.sleep(22);
                
            }
            catch (InterruptedException ex)
            {
                System.out.println("Error hilo1");
            }
            
            
        }
        
        System.out.println("Fin A ");
        System.out.println(" puntos " + puntos1);
        
    }
    
}
