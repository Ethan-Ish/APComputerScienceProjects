public class MergeSortStarterCode
{
    // temp is a temporary array that we will use as a copy 
    // of the original array so we won't overwrite values 
    // in the original; much the same way as we use a temp
    // variable when we swap two values in an array
    private static int[] temp;
    
    private static void print(int[] arr)
    {
        System.out.print("[");
        for (int i =0; i < arr.length-1; i++)
            System.out.print(arr[i] + ",");
        System.out.println(arr[arr.length-1] + "]");
    }  
    
    public static void sort(int[] arr)
    {
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }
    
    private static void mergeSort(int[] arr, int low, int high)
    {
        if (low >= high)
            return; // base case
        int middle = (low + high)/2;  
        
        mergeSort (arr, low, middle); // sort the left half of the array (it's magic!)
        mergeSort (arr, middle+1, high); // sort the right half of the array
        merge (arr, low, middle, high); // merge the two sorted halves
    }
    
    private static void merge(int[] arr, int low, int middle, int high)
    {
       
        // merges the two sorted halves:
        // arr[low] to arr[middle] is the left half.
        // arr[middle+1] to arr[high] is the right half.
        
       
        // store a copy of arr[low] to arr[high]
        // in temp[low] to temp[high]
        // thus, when merging, we can copy the values
        // from temp and store them in arr without worrying
        // about overwriting values in arr.
        for (int i = low; i <= high; i++)
        {
            temp[i] = arr[i];
        }
        int l = low;
        int r = middle + 1;
        int k = low;
        while (l <= middle && r <= high)
        {
            if(arr[l] < arr[r]){
                temp[k] = arr[l];
                l++;
            }
            else
            {
                temp[k] = arr[r];
                r++;
            }
            k++;
        }
        while (l <= middle)
        {
            temp[k] = arr[l];
                l++;
                k++;
        }
        while (r <= middle)
        {
            temp[k] = arr[r];
                r++;
                k++;
        }
        for (int i = low; i <= high; i++)
        {
            arr[i] = temp[i];
        }
    }  
    
    //tester code  
    public static void main (String[] args)
    {    
        int[] test = {38, 27, 43, 10};
        int[] numbers = {3,1,4,5,9,2};
        int[] grades = {92,85,76,76,45,95,100,100,64,47,99};
        sort(test);
        sort(numbers);
        sort(grades);
        print(test);
        print(numbers);
        print(grades);
                       
    }
             
}
