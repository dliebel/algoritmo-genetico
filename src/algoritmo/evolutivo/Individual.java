/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo.evolutivo;

import java.util.Random;




/**
 *
 * 
 * Genes: material genético básico
 * Cromosoma: secuencia de genes que codifica a un individuo 
 * @author dliebel
 */
public class Individual {

    private long fitness = 0;
    private final int[]  genes = new int[Config.L];
    
    /**
     * genera los cromosomas de cada individuo de forma aleatoria
     */
    public void generatChromosome() {
        for (int i = 0; i < Config.L; i++) {
            Random r = new Random();
            this.genes[i] = r.nextInt(2);
        }
    }
    /**
     * obtiene el fitness 
     * @return 
     */
    public long getFitness() {
        if (this.fitness == 0) {
            //utilizamos un utis para calcular el fitness
            this.fitness = Utils.calFitness(genes);
        }
        return this.fitness;
    }

    
    /**
     * obtiene todos los genes del individuo
     * @return 
     */
    public int[] getGenes() {
        return genes;
    }

    /**
     * (por sobrecarga)
     * obtiene los genes por index 
     * @param index
     * @return 
     */
    public int getGenes(int index) {
        return genes[index];
    }

    public void setGenes(int index,int value) {
        this.genes[index] = value;
    }

    public int size() {
        return this.genes.length;
    }
    
    
    
    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += this.getGenes(i);
        }
        return geneString;
    }
    

}
