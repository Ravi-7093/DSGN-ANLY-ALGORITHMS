import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Insertion {
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

    public void Sort(int[] arr) {
        for (int x = 1; x < arr.length; x++) {//Looping through the array
            int temp = arr[x];//Storing the first element into temp variable
            int j = x - 1;//Initializing j value to point 1st index of the array 
            while (j >= 0 && temp <= arr[j]) { //While j is greater than or equal to zero and comparing the second element with first element 
                arr[j + 1] = arr[j];//Store the first element to second position
                j = j - 1;//Decrementing j value
            }
            arr[j + 1] = temp;//Moving the temporary element to the first position in the array (ie second element to)
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]); //Printing the array elements
        }

    }

}
