import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class Quick_Sort {
    public int[] Read_file(String file) throws FileNotFoundException {
        File f = new File(file); // Using the file created for generating Random Numbers
        Scanner s = new Scanner(f); // Creating Scanner class Object and passing the file instance to read the file
        int count = 0;// Intializing the counter to zero
        while (s.hasNextInt()) { // Using Scannner class built in method to read each line of the file
            count++;// Incrementing counter
            s.nextInt();// Reading the integers
        }
        int[] arr = new int[count];// Initializing the array
        Scanner s1 = new Scanner(f);

        for (int i = 0; i < arr.length; i++) {// Looping through the elements
            arr[i] = s1.nextInt();//Appending values to the array

        }
        return arr;// Return the array

    }
    public void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int splitting_index = split(arr, start, end);//Calling split function
    
            quickSort(arr, start, splitting_index-1);//Calling quick sort after creating partition to the left side of splitting index
            quickSort(arr, splitting_index+1, end);//Calling quick sort after creating partition to the right side of splitting index
        }
    }
    private int split(int arr[], int start, int end) {
        int pivot_ele = arr[end];//pivot is last element
        int i = (start-1);// Initially i index is negative 
    
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot_ele) {// Swap if element is less than pivot 
                i++;
    
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;//Swapping done
            }
        }
    
        int temp = arr[i+1];//Pushing the ith index element greater than pivot_ele
        arr[i+1] = arr[end];
        arr[end] = temp;//Swapping done
    
        return i+1;
    }
    public void print(int[]arr, int n){
        for(int x=0; x<arr.length;x++){
          System.out.println(arr[x]);
        }
    }
}