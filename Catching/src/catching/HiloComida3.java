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
public class HiloComida3 extends Thread{
    
    JLabel comi3 = new JLabel();
    JLabel chang = new JLabel();
    HiloComida2 h2;
    
    
    public HiloComida3(JLabel co1, JLabel ch)
    {
        comi3 = co1;
        chang = ch;
    }
    
    public void validar()
    {
        int changoX = (int)chang.getLocation().getX();
        int comidaY = (int)comi3.getLocation().getY();
        
        if(comidaY==440 && changoX==510)
        {
            comi3.setVisible(false);
        }
        
        changoX = (int)chang.getLocation().getX();
    }
    
    public void run()
    {
        int comidaY = (int)comi3.getLocation().getY();
        //EH.lanzar();
        for(int y = 90 ; y < 500 ; y++)
        {
            comi3.setLocation(540,y);
            validar();
            try
            {
                Thread.sleep(15);
                
            }
            catch (InterruptedException ex)
            {
                System.out.println("Error hilo1");
            }
            
        }
        System.out.println("Fin A ");
        
        
    }
    
}
