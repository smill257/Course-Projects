/*
Class: CSE 1321L
Section: J04
Term: Fall 2022
Instructor: Aarthi Poovalingam
Name: Sam Miller
Assignment#: Assignment6A
*/
import java.util.Scanner;
import java.util.Random;
public class Assignment6A {
    static void create_random_array (int[] array, int array_size){
        Random random = new Random();
        for (int i = 0; i < array_size; i++) {
            array[i] = random.nextInt(1001)-500;
        }
        String tmpArray = "";
        for (int i = 0; i < array_size; i++) {
            tmpArray += array[i] +", ";

        }
        System.out.println(tmpArray.replaceAll(", $", ""));
        System.out.println();
    }
    static boolean is_array_sorted (int[] array, int array_size){
        int prev= array[0];
        for (int i = 0; i < array_size; i++) {
            if (array[i]<prev){
                return false;
            }
            prev = array[i];
        }
        return true;
    }
   static void sort_array (int[] array, int array_size){
        int minPos;
            for (int i = 0; i <array_size; i++) {
                minPos = i;
                for (int j = i+1; j < array_size ; j++) {
                    if(array[j] < array[minPos]){
                        minPos = j;
                    }
                }
                if(i != minPos && minPos < array_size) {
                    int temp = array[minPos];
                    array[minPos] = array[i];
                    array[i] = temp;
                }

            }

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int array_size = 10;
        int menu = 0;
        int[] userInput = new int [array_size];
        String name = null;

        System.out.println("[Is It Sorted?]");
        System.out.print("Random Array: ");create_random_array(userInput, array_size);
        System.out.println();
        do{
            System.out.println("What do you want to do?");
            System.out.println("1) generate a new random array");
            System.out.println("2) Is the array sorted?");
            System.out.println("3) Sort the array");
            System.out.println("4) Quit");
            System.out.println();
            System.out.print("Choice: ");
            menu = scan.nextInt();
            System.out.println();
            switch (menu) {
                case 1:
                    System.out.print("Random Array: ");
                    create_random_array(userInput, array_size);
                    break;
                case 2:
                    if (is_array_sorted(userInput, array_size) == true){
                        System.out.println("The array is sorted.");
                    } else {
                        System.out.println("The array is not sorted.");
                    }
                    break;
                case 3:
                    sort_array(userInput, array_size);

                    String sArray = "";
                    System.out.print("Sorted Array: ");
                    for (int i = 0; i < array_size; i++) {
                        sArray += userInput[i]+", ";
                    }
                    System.out.println(sArray.replaceAll(", $", ""));
                    System.out.println();
                    break;
            }
            System.out.println();
        } while (menu != 4);

    }
}
