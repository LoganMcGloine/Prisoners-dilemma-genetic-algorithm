package GA;


import java.util.Random;


public class Member {
    boolean[] gene = new boolean[4];
    int num;



    //randomly produce 4 bits for the gene
    void genGene() {
        Random random = new Random();
        for (int x = 0; x < gene.length; x++) {
            gene[x] = random.nextBoolean();
        }
    }


    //determine if the number is > 7
    boolean isDefecter() {
        if(gene[0] == true) {
            return true;
        } else {
            return false;
        }
    }

    void printGene() {
        System.out.print("[");
        for (int x = 0; x < gene.length; x++) {
            if (gene[x] == true) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }

        }
        System.out.print("]");
        System.out.println();


    }
}
