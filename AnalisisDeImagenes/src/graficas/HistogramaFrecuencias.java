/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficas;

import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Carlos
 */
public class HistogramaFrecuencias {
    private Image ImagenOriginal; 
    private int HistogramaR[];
    private int HistogramaG[];
    private int HistogramaB[];
    
    
    
    public HistogramaFrecuencias(Image ImagenOriginal) {
        this.ImagenOriginal = ImagenOriginal;
        this.HistogramaR = new int[256]; 
        this.HistogramaG = new int[256]; 
        this.HistogramaB = new int[256]; 
        
        calcularHistogramas(); 
        
        
    }
    
    public void graficarHistogramasRGB(){
        
        
        
        
        
        
        
        
    }

    private void calcularHistogramas() {
        //Recorrido de la imagen y contamos
        BufferedImage bi = ImageManager.toBufferedImage(ImagenOriginal); 
        for (int x = 0; x < bi.getWidth(); x++) 
            for (int y = 0; y < bi.getHeight(); y++) {
                Color pixel = new Color(bi.getRGB(x, y)); 
                this.HistogramaR[pixel.getRed()]++;
                this.HistogramaG[pixel.getGreen()]++;
                this.HistogramaB[pixel.getBlue()]++;
                
            }
            
        
    }
    
    
    
}
