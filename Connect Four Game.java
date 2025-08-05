/*
Class: CSE 1321L
Section: J04
Term: Fall 2022
Instructor: Aarthi Poovalingam
Name: Sam Miller
Assignment#: Assignment6C
*/
import java.util.Scanner;
public class Assignment6C {
    public static void printArray(String[][] array){ //design of connect 4 game
        for (int i = 0; i < array.length; i++) {
            System.out.print("|");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+"|");
            }
            System.out.println(); // white space
        }
    }
    public static boolean isBoardFull(String[][] array){ //boolean method that checks if it is t/f
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j].equals(" "))
                    return false;
            }
        }
        return true;
    }
   public static  void addDisc(String[][] array, int column, char player){
       for (int i = array.length -1; i >= 0 ; i--) {
           if (array[i][column].equals(" ")){
               array[i][column] = player+"";
               return;
           }
       }
    }
    public static boolean winVertical(String[][] array, char player){ //sets up vertical play
        for (int i = 0; i < array.length; i++) {
            if (array[i][0].equals(player+"") && array [i][1].equals(player+"") && (array[i][2].equals(player+"") && array [i][3].equals(player+"")))
            return true;
        }
        return false;
    }
    public static boolean winHorizontal(String[][] array, char player){ //sets up horizontal play
        for (int i = 0; i < array.length; i++) {
            if (array[0][i].equals(player + "") && array[1][i].equals(player + "") && (array[2][i].equals(player + "") && array[3][i].equals(player + "")))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        String array[][] = new String[4][4];
        char Player1 = 'O';
        int playernum = 1;
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = " ";
            }

        }
        System.out.print("[Connect Four]");
        do {

            if (Player1 == 'O'){
                Player1 = 'X';
                playernum = 1;
            } else {
                Player1 = 'O';
                playernum = 2;
            }
            System.out.println();
            System.out.print("Player " +playernum+ ", enter a column: ");
            System.out.print("");
            addDisc(array,scan.nextInt(),Player1);
            System.out.println();
            printArray(array);
        } while(!winHorizontal(array, Player1) && !winVertical(array, Player1) && !isBoardFull(array));
        if (isBoardFull(array)) {
            System.out.println("No one wins!");
        } else {
            System.out.println();
            System.out.println("Player " +playernum+ " wins!");
        }
    }

}
