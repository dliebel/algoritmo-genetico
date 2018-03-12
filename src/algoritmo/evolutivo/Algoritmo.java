/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo.evolutivo;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author dliebel
 */
public class Algoritmo {

    /**
     * matrices
     */
    Population populationP; //poblacion padre
    Population populationE;

    public Algoritmo() {
        this.populationP = new Population();
    }

    /**
     * Inicializa la poblacion
     */
    public void initPoblationP() {
        this.populationP.init();
    }

    /**
     * Evaluacion de Población Que tan cerca esta algún elemento de la
     * muestra/población de acercarse al resultado deseado.
     *
     * @param g
     */
    public void evaluationPopulation(int g) {

        System.out.print("\n------ INICIO evaluacion g" + g + " ------\n");
        for (int z = 0; z < Config.N; z++) {
            double n = this.populationP.individuals[z].calFitness();
            //   System.out.print("\n evaluacion  f: " + n + " x: " + this.populationP.individuals[z].getX());

            if (n > this.populationP.elite) {
                this.populationP.elite = n;
                this.populationP.eliteIndex = z;
            }
        } 
        System.out.print("\n------ FIN    evaluacion g" + g + " ------\n");
        this.populationP.saveHistorical(g, this.populationP.individuals[this.populationP.eliteIndex]);
    }

    /**
     * Imprime la población más el fitnnes
     */
    public void printWithFitness() {
        System.out.print("\nInicio\n");
        for (int i = 0; i < Config.N; i++) {

            System.out.print(this.populationP.individuals[i].toString());
            System.out.print(" -d " + Utils.decodeBtoD(this.populationP.individuals[i].getGenes()));
            System.out.print(" - ");
            System.out.print(" -f " + this.populationP.individuals[i].getFitness());
            System.out.print("\n");
        }
        System.out.print("Fin Printer\n");
    }

    /**
     * Seleccion de torneo: se escogen aleatoriamente un número T de individuos
     * de la población, y el que tiene puntuación mayor se reproduce,
     * sustituyendo su descendencia al que tiene menor puntuación.
     *
     */
    public void select() {
        Individual candidate_a, candidate_b;
        Population progenitors = new Population();

        for (int i = 0; i < Config.N; i++) {
            Random r = new Random();

            candidate_a = this.populationP.individuals[r.nextInt(Config.N)];
            candidate_b = this.populationP.individuals[r.nextInt(Config.N)];
            //aqui es donde se define min o max
            if (candidate_a.getFitness() <= candidate_b.getFitness()) {
                progenitors.individuals[i] = candidate_a;
            } else {
                progenitors.individuals[i] = candidate_b;
            }
        }
        //piso los datos inicializados o anteriores progenitores para dales
        //los progenitores que tiene mayor probabilidad en la seleccion aleatoria
        this.populationP = progenitors;

    }

    /**
     * los dos cromosomas se cortan por n puntos, y el material genético situado
     * entre ellos se intercambia. Lo más habitual es un crossover de un punto o
     * de dos puntos.
     */
    public void crossver() {
        //finaliza la seleccionada los mejores progrenitores padres de la aleatoriedad 
        //de dos elemento 

 
        Random r = new Random();
        int aux = 0;
        //elemento contiguo entre los individuos
        for (int i = 0; i < Config.N; i += 2) {//ya que selecciono pares voy sumando 2 por cada ciclo
            // aplica la probabilidad que se aplique el cruze 
            if (r.nextDouble() < Config.PROB_CRUCE) {
                int pivot = r.nextInt(Config.N - 1); //punto de cruce
                //    System.out.print("pivot: " + pivot + " N-1 " + (Config.N - 1) + "\n");
                //vamos a recorrer los L genes del cromosoma del individuo
                for (int j = pivot; j < Config.L; j++) {
                    aux = this.populationP.individuals[i].getGenes(j);
                    this.populationP.individuals[i].setGenes(j, this.populationP.individuals[i + 1].getGenes(j));
                    this.populationP.individuals[i + 1].setGenes(j, aux);
                }

            }

    
          

        }

    }

    public void muted() {
        Random r = new Random();
        for (int i = 0; i < Config.N; i++) {
            for (int j = 0; j < Config.L; j++) {
                if (r.nextDouble() < Config.PROB_MUT) { //aca esta revisar posible error
                    {
                        if (this.populationP.individuals[i].getGenes(j) == 1) {
                            this.populationP.individuals[i].setGenes(j, 0); //mutamos el hijo
                        } else {
                            this.populationP.individuals[i].setGenes(j, 1); //motamos el hio
                        }
                    }

                }
            }
        }

    }
}
