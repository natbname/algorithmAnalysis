import java.util.*;
public class Algorithms 
{
    public Algorithms(){}

    public void bubbleSort(int[] a) 
    {
        int temp;
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a.length; j++)  
            {
                if(a[i] < a[j])
                {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                } 
            }
        }
    }

    
    public void selectionSort(int[] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a.length; j++)
            {
               int lowest = a[i];
               if(lowest < a[j])
               {
                   int temp = lowest;
                   lowest = a[j];
                   a[i] = lowest;
                   a[j] = temp;
               }  
            }
        }
    }
    

    public void insertionSort(int[] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a.length; j++)
            {
                if(a[i] < a[j])
                {
                   int temp = a[i];
                   a[i] = a[j];
                   a[j] = temp;
                }
            }
        }
    }
    

    public int[] mergeSort(int[] a)
    {
        if(a.length < 3)
        {
            if(a.length < 2)
            {
                return a;
            }
            else
            {
                if(a[0] > a[1])
                {
                    int temp = a[0];
                    a[0] = a[1];
                    a[1] = temp;
                }
            }
            return a;
        }
        
        int half = (int) a.length/2;
        
        int[] left = new int[half]; 
        int[] right = new int[a.length-half]; 
        
        for(int i = 0; i < half; i++)
        {
            left[i] = a[i];
        }
        
        for(int i = half; i < a.length; i++)
        {
            right[i-half] = a[i];
        }
        
        mergeSort(left);
        mergeSort(right);
       
        merge(a, left, right);
        
        return a;
    }
     
    
    private void merge(int[] a, int[] left, int[] right) //method from data structures textbook, chapter 8.6. modified to accept arrays + for formatting
    {
       int i = 0;
       int j = 0;
       int k = 0;
       
       while(i < left.length && j < right.length)
       {
           if(left[i] < right[j])
           {
               a[k] = left[i];
               i++;
               k++;
           }
           else
           {
               a[k] = right[j];
               j++;
               k++;
           }
       }
       
       while(i < left.length)
       {
           a[k] = left[i];
           i++;
           k++;
       }   
       
       while(j < right.length) 
       {
           a[k] = right[j];
           j++;
           k++;
       }
       
    }

    
    public void shellSort(int[] a) //method from TutorialsPoint
    {
        int interval = 1;
        for(int i = interval; i < a.length; i++)
        {
            int newI = a[i];
            int ii = i;
            while(ii > interval - 1 && a[ii-interval] >= newI)
            {
                a[ii] = a[ii-interval];
                ii = ii - interval;
            }
            a[ii] = newI;
        }
    }
    
    
    public void qSort(int[] a) //quicksort methods from data structures textbook, chapter 8.9. modified to accept arrays instead of tables
    {
        quickSort(a, 0, a.length -1);
    }
    
    public void quickSort(int[] a, int first, int last)
    {
        if(first < last)
        {
            int pIndex = partition(a, first, last);
            quickSort(a, first, pIndex - 1);
            quickSort(a, pIndex+1, last);
        }
    }
    
    public int partition(int[] a, int first, int last)
    {
        int pivot = a[first];
        int up = first;
        int down = last; 
        
        while(up < down)
        {
            while((up < last) && (pivot >= a[up]))
            {
                up++;
            }
            
            while(pivot < a[down])
            {
                down --;
            }
            
            if (up < down)
            {
                swap(a, up, down);
            }
        }
        swap(a, first, down);
        
        return down;
    }
    
    
    public void hSort(int a[]) //heapsort methods from data structures textbook, chapter 8.8. modified to accept arrays instead of tables 
    {
        buildHeap(a);
        shrinkHeap(a);
    }
    
    public void buildHeap(int[] a)
    {
        int n = 1;
        while(n < a.length)
        {
            n++;
            int child = n - 1;
            int parent = (child - 1)/2;
            while ((parent >= 0) && (a[parent] < a[child]))
            {
                swap(a, parent, child);
                
                child = parent;
                parent = (child - 1)/2;
            }
        }
    }
    
    public void shrinkHeap(int[] a)
    {
        boolean t = true;
        int n = a.length;
        while(n > 0)
        {
            n--;
            swap(a, 0, n);
            int parent = 0;
            while(true)
            {
                int leftC = 2 * parent + 1;
                if(leftC >= n)
                {
                    break;
                }
                int rightC = leftC + 1;
                int maxC = leftC;
                
                if(rightC < n && a[leftC] < a[rightC])
                {
                    maxC = rightC;
                }
                
                if(a[parent] < a[maxC])
                {
                    swap(a, parent, maxC);
                    
                    parent = maxC;
                }
                else
                {
                    break;
                } 
            }
        }
    }
    
    public void swap(int[] a, int i, int j) //used in both quick and heap sorts. from textbook, chapter 8.8
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public boolean validate(int [] a)
    {
        for(int i = 0; i < a.length-1; i++)
        {
            for(int j = 1; j < a.length-1; j++)
            {
                if(a[i] > a[j]) //for each value i, every value after (j) should be greater/equal. if not, return false.
                {
                    return false;
                }
            }
        }
        return true; //if false is not returned above, array is sorted. 
    }

    public int randInt() //generates ints used to fill array with random values
    {
        double tempDouble = (Math.random() * 10) +1; //int from 1 to 10
        int tempInt = (int)tempDouble;
        return tempInt;
    }

    public int[] fillArray(int count) //populates array to given amt of values (count)
    {
        int numbers[] = new int[count];
        for(int i = 0; i < count; i++)
        {
            numbers[i] = randInt();
        }
        return numbers;
    }
    
    public void testerMethod(double firstTime, double[] time, ArrayList<int[]> arrays) //abstracted tester from main method
    {
        bubbleSort(arrays.get(0));
        time[0] = System.currentTimeMillis() - firstTime;
        System.out.println("Bubble sort: " + time[0]);
        firstTime += time[0];
        
        selectionSort(arrays.get(1));
        time[1] = (System.currentTimeMillis() - firstTime);
        System.out.println("Selection sort: " + time[1]);
        firstTime += time[1];
        
        insertionSort(arrays.get(2));
        time[2] = (System.currentTimeMillis() - firstTime);
        System.out.println("Insertion sort: " + time[2]);
        firstTime += time[2];
        
        mergeSort(arrays.get(3));
        time[3] = (System.currentTimeMillis() - firstTime);
        System.out.println("Merge sort: " + time[3]);
        firstTime += time[3];
        
        shellSort(arrays.get(4));
        time[4] = (System.currentTimeMillis() - firstTime);
        System.out.println("Shell sort: " + time[4]);
        firstTime += time[4];
        
        qSort(arrays.get(5));
        time[5] = (System.currentTimeMillis() - firstTime);
        System.out.println("Quick sort: " + time[5]);
        firstTime += time[5];
        
        hSort(arrays.get(6));
        time[6] = (System.currentTimeMillis() - firstTime);
        System.out.println("Heap sort: " + time[6]);
        
    }
}
