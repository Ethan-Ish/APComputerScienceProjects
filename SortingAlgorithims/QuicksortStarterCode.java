import java.util.*;
import java.util.concurrent.TimeUnit;

public class QuicksortStarterCode
{
    public static int partition(int[] arr, int lo, int hi)
    {
       // Partitions arr[lo]...arr[hi] around a pivot.
       // The pivot could be the first element in this section of the array
       // or perhaps a random element in the array.
       // Returns the final resting index of the pivot element
       // (needed for the quicksort recursion)
       for(int i = lo; i < hi; i++)
       {
           if(arr[i] > arr[hi])
           {
               int temp = arr[hi];
               arr[hi] = arr[i];
               arr[i] = temp;
           }
       }
       return (hi);

    }
    
    public static void quickSort(int[] arr, int lo, int hi)
    {
        if (lo < hi ) // base case is when lo >= hi (nothing to sort)
        {
            // 1. partion the array around the pivot, p
            int p = partition(arr,lo,hi);
            // 2. sort the elements to the left of the pivot
            quickSort(arr,lo,p-1);
            // 3. sort the elements to the right of the pivot
            quickSort(arr,p+1,hi);    
        }
    }
    
    // this method allows for a more client friendly way of 
    // invoking a sort
    public static void sort(int[] arr) 
    {
        quickSort(arr,0,arr.length-1);
    }
    
    private static void print(int[] arr)
    {
        System.out.print("[");
        for (int i =0; i < arr.length-1; i++)
            System.out.print(arr[i] + ",");
        System.out.println(arr[arr.length-1] + "]");
    }   
        
    
    //tester code  
    public static void main (String[] args)
    {    
        //int[] numbers = {3,1,4,5,9,2};
        int[] numbers = {5,1,9,2,8,3,7,4,6};
        int[] grades = {92,85,76,76,45,95,100,100,64,47,99};
        sort(numbers);
        sort(grades);
        print(numbers);
        print(grades);
                       
    }
}
    
    
    
    