package HW6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HW6_Project {

//Handle all possible exceptions in project1

    public static String[][] border = new String[3][3];
    public static int chose;
    public static String user = "O";
    public static String computer = "X";

    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);

        boolean isFinish = false;
        String currentPlayer = user;

        initializeBorders();
        displayBorders();

        try {
            do {
                if (currentPlayer.equals(user)) {
                    System.out.println("Where would you like to play? (1-9)");
                    chose = data.nextInt();
                }
                if (currentPlayer.equals(user)) {
                    boolean isValid = userPosition();
                    if (isValid) {
                        currentPlayer = computer;
                    }
                } else {
                    int random = computerPosition();
                    System.out.println("Computer chose " + random);
                    currentPlayer = user;

                }
                displayBorders();
                if (checkWin(user)) {
                    System.out.println("You win!");
                    isFinish = true;
                } else if (checkWin(computer)) {
                    System.out.println("Computer wins!");
                    isFinish = true;
                }

            } while (!isFinish);

        } catch (ArrayIndexOutOfBoundsException index){
            System.out.println(index.getMessage());
        } catch (InputMismatchException input){
            System.out.println("Invalid input! your input dose not match with input type and system read it as " + input.getMessage());
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void initializeBorders() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                border[row][col] = " ";
            }
        }
    }

    public static void displayBorders() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(border[row][col]);
                if (col < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("-+-+-");
            }
        }
    }

    public static boolean userPosition() {
        boolean isValid= false;;
        int row = (chose - 1) / 3;
        int col = (chose - 1) % 3;
        try {
            if (border[row][col].equals(" ")) {
                border[row][col] = user;
                isValid = true;
            } else  invalidMove(isValid);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return isValid;
    }

    public static int computerPosition() {
        boolean isValid = false;
        int random = 0;
        while (!isValid) {
            int randomNum = (int) Math.floor((Math.random() * 9) + 1);
            random = randomNum;
            int row = (randomNum - 1) / 3;
            int col = (randomNum - 1) % 3;
            if (border[row][col].equals(" ")) {
                border[row][col] = computer;
                isValid = true;
            }
        }
        return random;
    }

    public static boolean checkWin(String player) {
        for (int i = 0; i < 3; i++) {
            if (border[i][0].equals(player) && border[i][1].equals(player) && border[i][2].equals(player)) {
                return true;
            }
            if (border[0][i].equals(player) && border[1][i].equals(player) && border[2][i].equals(player)) {
                return true;
            }
        }
        if (border[0][0].equals(player) && border[1][1].equals(player) && border[2][2].equals(player)) {
            return true;
        }
        if (border[0][2].equals(player) && border[1][1].equals(player) && border[2][0].equals(player)) {
            return true;
        }

        return false;
    }

    public static void invalidMove(boolean hasValue) throws Exception{
        if (!hasValue)
            throw new Exception("This position is not a valid");
    }
}
