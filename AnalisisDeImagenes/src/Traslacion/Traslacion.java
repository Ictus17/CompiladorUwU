/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Traslacion;

import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Carlos
 */
public class Traslacion {
    
    
    
    
    public static Image iluminar(Image imagen, int t){
        BufferedImage bf = ImageManager.toBufferedImage(imagen); 
        
        
        
        for (int i = 0; i < bf.getWidth(); i++) {
            for (int j = 0; j < bf.getHeight(); j++) {
                
               Color c = new Color(bf.getRGB(i, j));
              
               
               int r,g,b; 
               r = c.getRed()+t; 
               g = c.getGreen()+t; 
               b = c.getBlue()+t; 
               if(r<0) r = 0; 
               if(r>255) r = 255; 
               
               if(g<0) g = 0; 
               if(g>255) g = 255; 
               
               if(b<0) b = 0; 
               if(b>255) b = 255; 
               
               
               Color n; 
               
               //n = c.brighter();
               
               n = new Color(r,g,b); 
               
               
               bf.setRGB(i, j, n.getRGB());
               
            }
            
            
        }
        
        
        return ImageManager.toImage(bf); 
        
    }
    
    public static Image warm(Image imagen, int t){
        BufferedImage bf = ImageManager.toBufferedImage(imagen); 
        
          for (int i = 0; i < bf.getWidth(); i++) {
            for (int j = 0; j < bf.getHeight(); j++) {
                
                Color c = new Color(bf.getRGB(i, j));
                int r,b; 
                
                
                if(t>0){
                     r = c.getRed()+Math.abs(t); 
                    if(r<0) r = 0; 
                    if(r>255) r = 255; 
                    
                    
                    b = c.getBlue()-Math.abs(t); 
                    if(b<0) b = 0; 
                    if(b>255) b = 255; 
               
                    
                }else{
                    
                    r = c.getRed()-Math.abs(t); 
                    if(r<0) r = 0; 
                    if(r>255) r = 255; 
                    
                    
                    b = c.getBlue()+Math.abs(t); 
                    if(b<0) b = 0; 
                    if(b>255) b = 255; 
                }
                
                 Color n; 
               
               //n = c.brighter();
               
               n = new Color(r,c.getGreen(),b); 
               
               
               bf.setRGB(i, j, n.getRGB());
            
                
            }
          
          }
        
        
        return ImageManager.toImage(bf); 
    }
    
    
   
    
}
