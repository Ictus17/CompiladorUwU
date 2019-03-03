/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.de.imagenes;

import GUI.JFrameImagen;
import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import muestreo.EscalaGrises;
import muestreo.Expansion;
import muestreo.HistogramaFrecuencias;
import muestreo.MetodoIterativo;
import muestreo.Umbralizacion;

/**
 *
 * @author Roberto Cruz Leija
 */





public class AnalisisDeImagenes {

    
    public static Image CambiarColor(BufferedImage bf, Color anterior, Color nuevo, int rango){
        
        
        Color aux1 = new Color(anterior.getRed()+rango,
                                    anterior.getGreen()+rango,
                                        anterior.getBlue()+rango); 
        
        Color aux2 = new Color(anterior.getRed()-rango,
                                    anterior.getGreen()-rango,
                                        anterior.getBlue()-rango); 
        
        for (int x = 0; x < bf.getWidth(); x++) {
            for (int y = 0; y < bf.getHeight(); y++) {
                
                if(bf.getRGB(x, y)<=aux1.getRGB() && 
                        bf.getRGB(x, y)>=aux2.getRGB())
                bf.setRGB(x, y, nuevo.getRGB());
                
            }
        }
        
        
        Image nueva = ImageManager.toImage(bf);
        return nueva; 
}
    public static void main(String[] args) {
       Image imagen = ImageManager.openImage();
        JFrameImagen frame1 = new JFrameImagen(imagen);
        Image grises = EscalaGrises.generarImagenEnGrises(imagen);
        JFrameImagen frame2 = new JFrameImagen(grises);
        HistogramaFrecuencias histo = new HistogramaFrecuencias(grises);
        histo.graficarHistogramasRGB();
       
        Image contraste = Expansion.expansionCuadratica(grises);
        JFrameImagen frame3 = new JFrameImagen(contraste);
        HistogramaFrecuencias histo2 = new HistogramaFrecuencias(contraste);
        histo2.graficarHistogramasRGB();
        
        System.out.println();
            
    }
    
}