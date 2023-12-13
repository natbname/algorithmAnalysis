import java.util.*;

public class TestAlgorithms //six intervals: 10k, 25k, 50k, 75k, 100k
{
    public static void main(String[] args)
    {
        Algorithms algos = new Algorithms();
        double firstTime;
   
        
        double[] timesTen = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}; //stores runtimes for each algorithm
        ArrayList<int[]> arraysTen = new ArrayList<>(); //stores each array
        
        for(int i = 0; i < 7; i++) //adds values to arrays using fill array
        {
            arraysTen.add(algos.fillArray(10000));
        }

        System.out.println("Runtimes for 10,000 integers:");
        firstTime = System.currentTimeMillis(); //sets firstTime to current
        algos.testerMethod(firstTime, timesTen, arraysTen);

        
        double[] timesTFive = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}; //stores runtimes for each algorithm
        ArrayList<int[]> arraysTFive = new ArrayList<>(); //stores each array
        
        for(int i = 0; i < 7; i++) //adds values to arrays using fill array
        {
            arraysTFive.add(algos.fillArray(25000));
        }
        
        System.out.println("\nRuntimes for 25,000 integers:");
        firstTime = System.currentTimeMillis(); //sets firstTime to current
        algos.testerMethod(firstTime, timesTFive, arraysTFive);
        
        double[] timesFifty = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}; //stores runtimes for each algorithm
        ArrayList<int[]> arraysFifty = new ArrayList<>(); //stores each array
        
        for(int i = 0; i < 7; i++) //adds values to arrays using fill array
        {
            arraysFifty.add(algos.fillArray(50000));
        }
        
        System.out.println("\nRuntimes for 50,000 integers:");
        firstTime = System.currentTimeMillis(); //sets firstTime to current
        algos.testerMethod(firstTime, timesFifty, arraysFifty);
        
        
        double[] timesSFive = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}; //stores runtimes for each algorithm
        ArrayList<int[]> arraysSFive = new ArrayList<>(); //stores each array
        
        for(int i = 0; i < 7; i++) //adds values to arrays using fill array
        {
            arraysSFive.add(algos.fillArray(75000));
        }
        
        System.out.println("\nRuntimes for 75,000 integers:");
        firstTime = System.currentTimeMillis(); //sets firstTime to current
        algos.testerMethod(firstTime, timesSFive, arraysSFive);
        
        
        double[] timesH = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}; //stores runtimes for each algorithm 
        ArrayList<int[]> arraysH = new ArrayList<>(); //stores each array
        
        for(int i = 0; i < 7; i++) //adds values to arrays using fill array
        {
            arraysH.add(algos.fillArray(100000));
        }
        
        System.out.println("\nRuntimes for 100,000 integers:");
        firstTime = System.currentTimeMillis(); //resets firstTime to current
        algos.testerMethod(firstTime, timesH, arraysH);
    }
}
