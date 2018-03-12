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

    public static double decodeBtoD(int[] genes) {
        double d = 0;

        for (int j = 0; j < Config.L; j++) {
            d += Math.pow(2, (Config.L - 1) - j) * genes[j];
        }
        return d;
    }


    
    public static double calX(int[] genes) {
        double x = 0.0;
        //alfa= (b-a)/((2^l)-1)
        double alpha = (Config.b - Config.a) / (Math.pow(2, Config.L ) -1);
        //beta = b
        double beta = Config.a;
        // x = alfa*y + beta;  beta = a
        x = (alpha * decodeBtoD(genes)) + beta;
        System.out.printf("%s %10f %n","x: ",  x);

        return x;
    }

    public static double funtionObjetive(double x) {
        return Math.pow((x - Config.c), 2);
    }

}
