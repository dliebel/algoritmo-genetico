/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo.evolutivo;

/**
 *
 * @author dliebel
 */
public class Utils {
    
    
    public static long calFitness(int[] genes){
        
        // x = alfa*y + beta;  beta = a
        long f=0;
        for (int j=0;j<Config.L;j++){
            f+=Math.pow(2,(Config.L-1)-j)*genes[j];
        }
        return f;
    }
    
    public static long funtionObjetive(long x){
        return (long) Math.pow((x-Config.c),2);
    }
    
    
    
}
