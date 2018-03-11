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
public class AlgoritmoEvolutivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int t = 0;
        Algoritmo g = new Algoritmo();
        //Inicia la poblacion
        g.initPoblationP();
        //evalua la poblacion
        g.evaluationPopulation(t);
        do {
           
            t++;
            g.printWithFitness();
            g.select();
          //  g.printWithFitness();
            g.crossver();
            g.evaluationPopulation(t);
            //falta si ha convergido salir
            System.out.print("\n--------Generacion "+t+" --------\n");
        } while (t < Config.T);
    }

}
