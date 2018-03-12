/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo.evolutivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author dliebel
 */
public class Population {

    public double elite = 0.0;
    public int eliteIndex = 0;
    public int t;
    private final String path = "C:\\Users\\dliebel.DESKTOP-SM7VE8H\\historico_genoma.txt";
    Individual[] individuals = new Individual[Config.N];

    /**
     * inicializar población
     */
    public void init() {
        for (int i = 0; i < Config.N; i++) {
            Individual ind = new Individual();
            ind.generatChromosome();
            this.individuals[i] = ind;
        }
        initHistorical();

    }

    private void initHistorical() {

        File file = new File(path);
        try {
            BufferedWriter bw;
            if (file.exists()) {
                bw = new BufferedWriter(new FileWriter(file));

            } else {
                bw = new BufferedWriter(new FileWriter(file));

            }
            bw.close();
        } catch (IOException e) {
        }

    }

    public void saveHistorical(int g, Individual i) {
        File file = new File(path);
////        if (file.exists()){
//           System.out.print("archivos existe "+(file.getCanonicalPath()));
////        }

        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fichero = new FileWriter(file, true);
            pw = new PrintWriter(fichero);

            pw.printf("%s %2d %s %10f %s %10f %s %n",
                    "G: ",
                    g,
                    " Fitnnes ",
                    i.getFitness(),
                    " x: " ,
                    i.getX(),
                    "  info genetico: " + i.toString() + "(" + i.getValorD() + ")");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                    pw.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void calElite() {
    }
}
