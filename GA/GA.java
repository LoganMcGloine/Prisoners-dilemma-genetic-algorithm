package GA;

import java.util.ArrayList;
import java.util.Random;

public class GA {
    ArrayList<Member> population = new ArrayList<>();
    int pop;
    double mutationRate = 0.3;
//   Member[] population;


    //Create a population of size, with members with randomly generated genes
    void generatePop(int size) {
        this.pop = size;
//        this.population = new Member[size];
        for (int i = 0; i < size; i++) {
            Member member = new Member();
            member.genGene();
            population.add(member);
        }

    }

    //Loop through the population array printing out the genes of the members
    void printPop() {
        for (int i = 0; i < population.size(); i++) {
            population.get(i).printGene();
        }
    }


    private Member Selection() {

        //create random number
        Random random = new Random();

        //While population size is > 1 (if there is only one left it simply got unlucky and will not enter the gene pool)
        //Choose members of population to face off (remove them from population so they can not be used twice)
        int rannum1 = random.nextInt(population.size() - 1);
        Member member = population.get(rannum1);
        population.remove(rannum1);


        return member;
    }

    void tournament() {
        ArrayList<Member> population2 = new ArrayList<>();

        while (population.size() > 2) {
            Member memberA = Selection();
            Member memberB = Selection();

            if (memberA.isDefecter() == false && memberB.isDefecter() == false) {
                if ((Math.random() * 100) < 60) {
                    population2.add(memberA);
                }
                if ((Math.random() * 100) < 60) {
                    population2.add(memberB);
                }
            }
            else if (memberA.isDefecter() == false && memberB.isDefecter() == true) {
                population2.add(memberB);
            }
            else if (memberA.isDefecter() == true && memberB.isDefecter() == false) {
                population2.add(memberA);
            } 
            else {
                if ((Math.random() * 100) < 20) {
                    population2.add(memberA);
                }
                if ((Math.random() * 100) < 20) {
                    population2.add(memberB);
                }
            }
        }
        population = population2;
    }


    void crossover() {
        //new arraylist for offspring
        ArrayList<Member> population2 = new ArrayList<>();


        while (population2.size() < pop) {
            Member offspringA = new Member();
            Member offspringB = new Member();
            Member memberA = Selection();
            population.add(memberA);
            Member memberB = Selection();
            population.add(memberB);

            //Takes first 2 bits from first parent
            //Takes second 2 bits from second parent
            offspringA.gene[0] = memberA.gene[0];
            offspringA.gene[1] = memberA.gene[1];
            offspringA.gene[2] = memberB.gene[2];
            offspringA.gene[3] = memberB.gene[3];

            offspringB.gene[0] = memberB.gene[3];
            offspringB.gene[1] = memberB.gene[2];
            offspringB.gene[2] = memberA.gene[1];
            offspringB.gene[3] = memberA.gene[0];

            mutate(offspringA);
            mutate(offspringB);
            population2.add(offspringA);
            population2.add(offspringB);
        }

        population = population2;
    }

//go through each bit and mutate according to the mutation rate
    void mutate(Member member) {
        for (int i = 0; i < 4; i++) {
            if (Math.random() * 100 < 0.1) {
                member.gene[i] = !member.gene[i];
            }
        }
    }

    void printStats() {
        int defectors = 0;
        int cooperators = 0;
        for (int i = 0; i < population.size(); i++) {
            if (population.get(i).isDefecter() == true) {
                defectors++;
            } else {
                cooperators++;
            }

        }

        System.out.println("Cooperators: " + cooperators);
        System.out.println("defectors: " + defectors);
    }


    //determines if the majority is selfish
   public boolean isSelfish() {
       int defectors = 0;
       int cooperators = 0;
       for (Member member : population) {
           if (member.isDefecter()) {
               defectors++;
           } else {
               cooperators++;
           }
       }
       return defectors > cooperators;
    }
}