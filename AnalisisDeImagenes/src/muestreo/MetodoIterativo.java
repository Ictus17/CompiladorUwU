/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestreo;


/**
 *
 * @author Carlos
 */
public class MetodoIterativo {
    public static int ui; 
    public static int Iteraciones; 
    public static int h[]; 
    
    
    
    
    public static int Iterar(int ui,int[] h){
        int uf = 0;
        boolean b = false; 
        
        int u1,u2; 
        
        int a1 = 0; 
        int c1 = 0; 
        
        
        int a2 = 0; 
        int c2 = 0; 
        
        
        for (int i = 0; i < h.length; i++) {
            if(!b){
                
                if(i == 0) a1+=h[i];
                else a1+=h[i]*i;
               c1+=h[i]; 
            }else{
               if(i == 0) a2+=h[i];
                else a2+=h[i]*i;
               c2+=h[i]; 
                
            }
            
            
            if(i==ui) b = true; 
        }
        
        u1 = a1/c1; 
        u2 = a2/c2; 
        
        uf=(u1+u2)/2;
        
        System.out.println("I: "+Iteraciones++);
        if(ui == uf){
            
            System.out.println(uf);
            return uf; 
        }else{
            return  Iterar(uf, h); 
            
        }
        
       
     
    }
    
    public static void main(String[] args){
        int h[] = new int[] {10,12,3,4,5,6,7,8,9,10}; 
        
        
        
        
        
        System.out.println(Iterar(0,h) );
        
    }
    
    
}
