package HW6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HW6_CalculatorExercise {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);

//Handle all possible exceptions in Calculator Exercise.

        int select;

        ArrayList<Integer> results = new ArrayList();
        try {
            do {
                System.out.printf("Menu: %nEnter 1 to addition the numbers " +
                        "%nEnter 2 to subtraction the numbers" +
                        " %nEnter 3 to multiplication the numbers" +
                        "%nEnter 4 to division the numbers" +
                        "%nEnter 5 to modulus the numbers" +
                        "%nEnter 6 to find minimum number" +
                        "%nEnter 7 to find maximum number" +
                        "%nEnter 8 to find the average of numbers" +
                        "%nEnter 9 to print the last result in calculator" +
                        "%nEnter 10 to print the list of all results in calculator" +
                        "%nEnter 0 to quit");

                System.out.printf("%nSelect from the menu: ");
                select = data.nextInt();

                switch (select) {
                    case 1:
                        System.out.println("Enter 2 numbers (positive values only): ");
                        int num1 = data.nextInt();
                        int num2 = data.nextInt();
                            int add = addition(num1, num2);
                            System.out.printf(num1 + " + " + num2 + " = " + add + "%n");
                            results.add(add);
                        break;

                    case 2:
                        System.out.println("Enter 2 numbers: (First number grater than 0) ");
                        int num3 = data.nextInt();
                        int num4 = data.nextInt();
                        int sub = subtraction(num3, num4);
                        System.out.printf(num3 + " - " + num4 + " = " + sub + "%n");
                        results.add(sub);
                        break;

                    case 3:
                        System.out.println("Enter 2 numbers: ");
                        int num5 = data.nextInt();
                        int num6 = data.nextInt();
                        int mul = multiplication(num5, num6);
                        System.out.printf(num5 + " * " + num6 + " = " + mul + "%n");
                        results.add(mul);
                        break;

                    case 4:
                        System.out.println("Enter 2 numbers: ");
                        int num7 = data.nextInt();
                        int num8 = data.nextInt();
                        int div = division(num7, num8);
                        System.out.printf(num7 + " / " + num8 + " = " + div + "%n");
                        results.add(div);
                        break;

                    case 5:
                        System.out.println("Enter 2 numbers: ");
                        int num9 = data.nextInt();
                        int num10 = data.nextInt();
                        int mod = modulus(num9, num10);
                        System.out.println(num9 + " % " + num10 + " = " + mod);
                        results.add(mod);
                        break;

                    case 6:
                        System.out.println("Enter 2 numbers: ");
                        int num11 = data.nextInt();
                        int num12 = data.nextInt();
                        int min = minimum(num11, num12);
                        results.add(min);
                        break;

                    case 7:
                        System.out.println("Enter 2 numbers: ");
                        int num13 = data.nextInt();
                        int num14 = data.nextInt();
                        int max = maximum(num13, num14);
                        results.add(max);
                        break;

                    case 8:
                        System.out.println("Enter 2 numbers: ");
                        int num15 = data.nextInt();
                        int num16 = data.nextInt();
                        int avg = average(num15, num16);
                        System.out.printf("The average is : " + avg + "%n");
                        results.add(avg);
                        break;

                    case 9:
                        System.out.printf("The last result in calculator: " + results.get(results.size() - 1) + "%n");
                        break;

                    case 10:
                        System.out.println("The list of all results in calculator:" + results);
                        break;

                    default: checkNum(select);
                }

            } while (select != 0);
        }catch (InputMismatchException input){
            System.out.println("Invalid input! your input dose not match with input type and system read it as " + input.getMessage());
        } catch (ArithmeticException num){
            System.out.println("The number must not " + num.getMessage());
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        } catch (Exception myException){
            System.out.printf(myException.getMessage());
        }
    }

    public static int addition(int num1, int num2) throws Exception{
        if (num1 <0 || num2 <0) {
            throw new Exception("Invalid input! numbers must be positive");
        }
        return num2+ num1;
    }

    public static int subtraction(int num1, int num2) throws Exception{
        if(num1 <= 0){
            throw new Exception("Invalid input! first number must be grater than 0");
        }
        return  num1- num2;
    }

    public static int multiplication(int num1, int num2){
        return num1 * num2;
    }

    public static int division(int num1, int num2){
        return num1 / num2;
    }

    public static int modulus(int num1, int num2){
        return num1 % num2;
    }

    public static int minimum(int num1, int num2){
        if(num1<num2)
        {
            System.out.printf(" The minimum number is :"+ num1 +"%n");
            return  num1;
        } else if (num2 < num1) {
            System.out.printf(" The minimum number is :"+ num2 +"%n");
            return num2;
        } else
            System.out.printf(" The numbers are equality %n");
        return 0;
    }

    public static int maximum(int num1, int num2){
        if(num1>num2)
        {
            System.out.printf("The maximum number is: "+ num1 +"%n");
            return num1;
        } else if (num2 > num1) {
            System.out.printf("The maximum number is: "+ num2 +"%n");
            return num2;
        } else
            System.out.printf("The numbers are equality %n");
        return 0;
    }

    public static int average(int num1, int num2){
        return (num1 + num2) /2;
    }

    public static void checkNum(int select) throws Exception{
        if(select <0 || select >10) {
            throw new Exception("Invalid number! select from the menu!");
        }
    }
    }

