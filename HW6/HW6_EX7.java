package HW6;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HW6_EX7 {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);

//Handle all possible exceptions in EX7 in HW4.

        int select;
        int[] array = null;
        int size2 = 0;

        try {
            do {
                System.out.printf("%n1.Accept elements of an array " +
                        "%n2.Display elements of an array" +
                        " %n3.Search the element within array" +
                        "%n4.Sort the array %n5.Stop %n");

                System.out.println("Select from the menu: ");
                select = data.nextInt();

                switch (select) {
                    case 1:
                        System.out.print("Enter the size of the array: ");
                        size2 = data.nextInt();
                        array = new int[size2];
                        for (int i = 0; i < size2; i++) {
                            System.out.print("Enter element " + (i + 1) + ": ");
                            array[i] = data.nextInt();
                        }
                        break;
                    case 2:
                        if (array != null) {
                            System.out.println(Arrays.toString(array));
                        } else checkArray(array);
                        break;
                    case 3:
                        if (array != null) {
                            System.out.print("Enter the element to search: ");
                            int searchElement = data.nextInt();
                            boolean found = false;
                            for (int i : array) {
                                if (i == searchElement) {
                                    found = true;
                                    break;
                                }
                            }
                            if (found) {
                                System.out.println(searchElement + " is present in the array.");
                            } else checkElementInArray(found);
                        } else checkArray(array);
                        break;
                    case 4:
                        if (array != null) {
                            Arrays.sort(array);
                            System.out.println("Sorted Array :" + Arrays.toString(array));
                        } else {
                            checkArray(array);
                        }
                        break;
                    case 5:
                        break;
                    default: checkNumber(select);

                }
            } while (select != 5);
        } catch (InputMismatchException input){
            System.out.println("Invalid input! your input dose not match with input type and system read it as " + input.getMessage());
        } catch (Exception myException){
        System.out.println(myException.getMessage());
    }
    }

    public static void checkNumber (int num) throws Exception{
        if(num <1 || num >5) {
            throw new Exception("Invalid number! select from the menu!");
        }
    }
    public static void checkArray (int [] array) throws Exception{
        if(array == null) {
            throw new Exception("Array is empty!");
        }
    }
    public static void checkElementInArray (boolean found) throws Exception{
        if(!found) {
            throw new Exception("The element is not present in the array.");
        }
    }

}
