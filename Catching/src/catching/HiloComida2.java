/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catching;

import java.io.File;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Cesar
 */
public class HiloComida2 extends Thread{
    
    JLabel comi2 = new JLabel();
    JLabel chang = new JLabel();
    JLabel punt2 = new JLabel();
    int puntos2;
    HiloComida1 h1 ;
    
    public HiloComida2(JLabel co2, JLabel ch, JLabel pun)
    {
        comi2 = co2;
        chang = ch;
        punt2 = pun;
    }
    
    public void validar()
    {
        int changoX = (int)chang.getLocation().getX();
        int comidaY = (int)comi2.getLocation().getY();
        
        if(comidaY==440 && (changoX==270 || changoX==260 || changoX==280))
        {
            comi2.setVisible(false);
            puntos2 ++ ;
            punt2.setText("Puntos : " + puntos2);
            if(puntos2 == 1)
            {
                Nivel2 n2 = new Nivel2();
                n2.setVisible(true);
                Catching c = new Catching();
                
            }
            
            
        }
        
        changoX = (int)chang.getLocation().getX();
    }
    
    public void run()
    {
        int comidaY = (int)comi2.getLocation().getY();
        //EH.esperar();
        for(int y = 90 ; y < 500 ; y++)
        {
            comi2.setLocation(300,y);
            validar();
            
                try
                {
                    Thread.sleep(12);
                }
                catch (InterruptedException ex)
                {
                    System.out.println("Error hilo2");
                }
            
        }
        System.out.println("Fin 2 ");
        System.out.println(" puntos " + puntos2);
    }
    
    
    
}
