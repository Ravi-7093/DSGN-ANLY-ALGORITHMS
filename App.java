
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;
import java.util.Date;


public class App {

    public static void main(String[] args) throws IOException {
        File f = new File("D:\\arr.txt"); // Using File constructor to create instance of File
        PrintStream out = new PrintStream(f);// Print stream to write the formatted data to file
        Scanner s = new Scanner(System.in);// Scanner instance to read the input
        System.out.println("Enter the size of the array list for generation of random numbers");
        float n = s.nextFloat();// Input from the user
        
         if(n!=20 && n!=100 && n!=1000 && n!=4000){
          System.out.println("Enter valid array list size. Please try again!!!");
          System.exit(0);
          }
         

        int min = 0;
        int max = 6000;

        for (int x = 1; x <= n; x++) {
            int rand_num = (int) (Math.random() * (max - min)) + min;
            out.println(rand_num); // Using Random method to generate random numbers and PrintStream object
                                   // to write to file
        }

        System.out.println("Select a sorting algorithm.");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Quick Sort");
        int usr = s.nextInt();
        if (usr > 3 || usr < 0) {
            System.out.println("Invalid Input for the algorithm. Please try again!!!");
            System.exit(0);
        }
        if (usr == 2) {
            Merge_Sort mr = new Merge_Sort();
            int xrr[] = mr.Read_file("D:\\arr.txt");
            Date d = new Date();
            mr.mergeSort(xrr, xrr.length);
            mr.print(xrr, xrr.length);
            Date dn = new Date();
            System.out.println("Time =" + (dn.getTime() - d.getTime()) + " " + "milliseconds");
            s.close();// Closing the scanner class --avoiding memory leaks
            out.close();// Closing the PrintStream Class -- avoiding memory leaks
        } else if (usr == 1) {
            Insertion pr = new Insertion();
            int vrr[] = pr.Read_file("D:\\arr.txt");// Calling insertion class read_file method to read the integers
            Date d = new Date();                                        // from
            pr.Sort(vrr);// Calling the sort method and passing an array
            Date dn = new Date();//Using date class get current date
            System.out.println("Time =" + (dn.getTime() - d.getTime()) + " " + "milliseconds");
            s.close();// Closing the scanner class --avoiding memory leaks
            out.close();// Closing the PrintStream Class -- avoiding memory leaks
        } else if (usr==3) {
            Quick_Sort qs = new Quick_Sort();// Creating instance of Quick_sort 
            int[] qrr = qs.Read_file("D:\\arr.txt");
            Date d = new Date();
            int last = qrr.length;//Computing length to find last element of an array
            qs.quickSort(qrr, 0,last-1);//Calling quickSort method to sort the elements
            qs.print(qrr, qrr.length);//
            Date dn = new Date();
            System.out.println("Time =" + (dn.getTime() - d.getTime()) + " " + "milliseconds");
            s.close();// Closing the scanner class --avoiding memory leaks
            out.close();// Closing the PrintStream Class -- avoiding memory leaks
            
        }
    }

}
