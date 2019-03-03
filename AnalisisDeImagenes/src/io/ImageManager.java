/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Roberto Cruz Leija - Carlos Escobar
 */
public class ImageManager {
    public static String rutaImagen; 
    public static String Aux; 
    public static BufferedImage bi; 
    
    
    
    public static Image openImage (){
    
        try {
            // definir los filtros para lectura
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter("Imagenes","jpg","jpeg","png","bmp");
            // crear un selector de archivos
            JFileChooser selector = new JFileChooser();
            // agregar el filtro al selector
            selector.addChoosableFileFilter(filtro);
            // especificar que solo se puedan abrir archivos
            selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            //ejecutar el selector de imagenes
            
            int res = selector.showOpenDialog(null);
            
            if (res == 1 ){
                
                return null;
                
            }
            
            File archivo = selector.getSelectedFile();
            System.out.println(selector.getSelectedFile().getAbsolutePath());
            rutaImagen = selector.getSelectedFile().getAbsolutePath(); 
            Aux = selector.getSelectedFile().getName().split("\\.")[0];
            
            
            
            
            bi = ImageIO.read(archivo);
            
            return toImage(bi);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static BufferedImage openImageBI (){
    
        try {
            // definir los filtros para lectura
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter("Imagenes","jpg","jpeg","png","bmp");
            // crear un selector de archivos
            JFileChooser selector = new JFileChooser();
            // agregar el filtro al selector
            selector.addChoosableFileFilter(filtro);
            // especificar que solo se puedan abrir archivos
            selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            //ejecutar el selector de imagenes
            
            int res = selector.showOpenDialog(null);
            
            if (res == 1 ){
                
                return null;
                
            }
            
            File archivo = selector.getSelectedFile();
            System.out.println(selector.getSelectedFile().getAbsolutePath());
            rutaImagen = selector.getSelectedFile().getAbsolutePath(); 
            Aux = selector.getSelectedFile().getName().split("\\.")[0];
            
            
            
            
            bi = ImageIO.read(archivo);
            
            return bi;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void writeImage(Image imagen) throws IOException{
         
            rutaImagen = rutaImagen.replaceAll(Aux, Aux+"Nuevo"); 
            
            System.out.println(rutaImagen);
            
            File archivo = new File(rutaImagen); 
        
            ImageIO.write(toBufferedImage(imagen), "png", archivo); 
        
        
    }
    
     public static void writeImage(BufferedImage imagen) throws IOException{
         
            rutaImagen = rutaImagen.replaceAll(Aux, Aux+"Nuevo"); 
            
            System.out.println(rutaImagen);
            
            File archivo = new File(rutaImagen); 
        
            ImageIO.write(imagen, "png", archivo); 
        
        
    }
    
     public static void writeImage(BufferedImage imagen, String ruta) throws IOException{
         
            
            System.out.println(ruta);
            
            File archivo = new File(ruta); 
        
            ImageIO.write(imagen, "png", archivo); 
        
        
    }
     public static void writeImage(Image imagen, String ruta) throws IOException{
         
            System.out.println(ruta);
            
             
            File archivo = new File(ruta); 
        
            ImageIO.write(toBufferedImage(imagen), "png", archivo); 
        
        
    }
     
    public static Image toImage (BufferedImage bi){
        return bi.getScaledInstance(bi.getWidth(),bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }
    
    public static BufferedImage toBufferedImage (Image imagen){
         // imagen es un objeto de tipo BufferedImage
        if (imagen instanceof BufferedImage){
          return (BufferedImage)imagen;
        }
        BufferedImage bi = 
                new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
        
        Graphics2D nueva = bi.createGraphics();
        nueva.drawImage(imagen, 0, 0,null);
        nueva.dispose();
        
        return bi;
    }
    
}