import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Merge_Sort {
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
    public  void mergeSort(int[] arr, int n) {
        if (n < 2) {// If one element then return
            return;
        }
        int mid = n / 2;//Calculating the mid of the array
        int[] left = new int[mid];//Left subarray
        int[] right = new int[n - mid];//Right subarray
    
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];// Append arr values to left sub array
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];// Append arr values to left right array(from middle to last elemnt)
        }
        mergeSort(left, mid);//Recursive call made for left subarray
        mergeSort(right, n - mid);//Recursive call made for right subarray
    
        merge(arr, left, right, mid, n - mid);//Call made to merge elements
    }
    public static void merge(
  int[] arr, int[] left, int[] right, int l, int r) {
 
    int i = 0, j = 0, k = 0;
    while (i < l && j < r) {//Comparing first subarray index to less than mid and right array index to less than last element index
        if (left[i] <= right[j]) {// Left sub array element is less than right array sub array element 
            arr[k] = left[i];//Then push the left element to main array. 
            k++;
            i++;//Increment the indexes
        }
        else {
            arr[k] = right[j];
            k++;
            j++;//Increment the indexes
        }
    }
    while (i < l) {
        arr[k++] = left[i++];//if there are pending elements in left subarray push to main array
    }
    while (j < r) {
        arr[k++] = right[j++];//if there are pending elements in right subarray push to main array
    }
    }

public void print(int[]arr, int n){//Using for loop to print elements
    for(int x=0; x<arr.length;x++){
      System.out.println(arr[x]);
    }
}
}
