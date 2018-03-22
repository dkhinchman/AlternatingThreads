/*

A simple threading program that controls threads
and allows them to run in order

 */

import java.util.ArrayList;

public class AlternatingThreads {
    private Monitor monitor;

    public static void main(String[] args){
        int numThreads = 5;
        /* <-added in for quick testing
        if(args.length != 1)
            toRun();

        int numThreads = 0;
        try{
            numThreads = Integer.parseInt(args[0]);
        }
        catch(Exception e){
            System.out.println(args[0] + " is not a valid integer");
            e.printStackTrace();
            toRun();
        }
        */

        new AlternatingThreads(numThreads);

    }

    public static void toRun(){
        System.out.println("To run enter program name followed by number of threads");
        System.out.println("AlternatingThreads 1 or AlternatingThreads 5");
        System.out.println("Please try again");
        System.exit(0);
    }

    public AlternatingThreads(int numThreads){
        monitor = new Monitor(numThreads);
        ArrayList<Thread> threadPool = new ArrayList<>();

        for(int thisThreadID = 0; thisThreadID < numThreads; ++thisThreadID){
            threadPool.add(new Thread(new ThreadRunner(thisThreadID, monitor)));
        }
        for(Thread thisThread : threadPool){
            thisThread.start();
        }
        try{
            for(Thread thisThread : threadPool) {
                thisThread.join();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
