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
public class Config {
    /**
     * cantidad de individios
     */
    public static int N =30; 
    /**
     * datos de cromosomas 
     */
    public static int L =30;
    /**
     * número maximo de generaciones
     */
    public static int T =100;
    /**
     * cantidad de generaciones
     */
    public static int t=0;
    
    /**
     * probabilidad de cruce
     */
    public static double PROB_CRUCE= 0.8;
    /**
     * probabilidad de mutación 
     */
    public static double PROB_MUT= 0.2;
    
    public static long c=5;
    
    /**
     * rango inferior
     */
    public static int a=-10;
    /**
     * rango superior
     */
    public static int b=10;
    
}
