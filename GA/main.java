package GA;

public class main {

    public static void main(String[] args) {
        GA ga = new GA();
        ga.generatePop(100);
        ga.printStats();
        for (int i = 0; i < 100; i++) {
            ga.tournament();
            ga.crossover();
            System.out.println("Generation: " + i);
            ga.printPop();
        }

        ga.printStats();


//        int nrOfDefectors = 0;
//        int nrOfCooperators = 0;
//        for (int x = 0; x < 100; x++) {
//            GA ga =new GA();
//            ga.generatePop(100);
////loop through the simulation x number of time (each generation)
//            for (int i = 0; i < 100; i++) {
//                ga.tournament();
//                ga.crossover();
////            System.out.println("Generation: " + i);
////            ga.printPop();
//            }
//
//            if (ga.isSelfish() == true) {
//                nrOfDefectors++;
//            } else {
//                nrOfCooperators++;
//            }
//            //get the final number of cooperators and defectors
////            System.out.println("final:");
//            ga.printStats();
//        }
//        System.out.println("final:");
//        System.out.println("cooperators: " + nrOfCooperators);
//        System.out.println("defectors: " + nrOfDefectors);
//
//    }
    }
}
