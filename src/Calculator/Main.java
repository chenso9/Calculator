package Calculator;

import Calculator.Roman;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static com.metanit.Main.arabValues;
import static com.metanit.Main.romanValues;


public class Main {
    public static String[] arabValues;
    public static String[] romanValues;

    public static void main(String[] args) {
        play();
    }

    public static void play(){
        System.out.println("Input");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] value = new String[3];
        value = str.split(" ");

        try {
            int test1 = Integer.parseInt(value[0]);
            int test2 = Integer.parseInt(value[2]);
            arabValues = value;
        } catch (NumberFormatException ex1) {
            romanValues = value;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Неверное количество символов");
            System.exit(0);
        }


        try {
            if (Arrays.equals(romanValues, null)) {
                Arabic arab = new Arabic();
                arab.a = arab.getOperand1();
                arab.b = arab.getOperand2();
                arab.operation = arabValues[1].charAt(0);
                arab.c = arab.calc();
                System.out.println("Output");
                arab.oneToTen();
            } else if (Arrays.equals(arabValues, null)) {
                CalcRoman roman = new CalcRoman();
                roman.a = romanValues[0];
                roman.b = romanValues[2];
                roman.x = roman.getOperand1();
                roman.y = roman.getOperand2();
                roman.operation = romanValues[1].charAt(0);
                roman.z = roman.calc();
                roman.result = roman.decToRoman();
                System.out.println("Output");
                roman.showRResult();

            }
        } catch (ArrayIndexOutOfBoundsException ex2) {
            System.out.println("Неверное количество символов");
        }
    }
}



class Arabic {
    int a;
    int b;
    char operation;
    int c;


    int getOperand1() {
        a = Integer.parseInt(arabValues[0]);
        return a;
    }

    int getOperand2() {
        b = Integer.parseInt(arabValues[2]);
        return b;
    }

    int calc() {
        switch (operation) {
            case '+':
                this.c = a + b;
                break;
            case '-':
                this.c = a - b;
                break;
            case '*':
                this.c = a * b;
                break;
            case '/':
                if (a % b == 0) {
                    c = a / b;
                } else {
                    System.out.println("Число не делится");
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Неправильная операция");
                System.exit(0);
        }
        return c;
    }

    void oneToTen() {
        try {
            if (a < 1 | a > 10 | b < 1 | b > 10) {
                throw new IOException();

            } else if (a > 1 | a <= 10 | b >= 1 | b <= 10) {
                System.out.println(c);
            }
        } catch (IOException ex) {
            System.out.println("Введите числа от 1 до 10");
            System.exit(0);
        }
    }
}


class CalcRoman {

    String a;
    String b;
    int x;
    int y;
    char operation;
    int z;
    String result;


    int getOperand1() {
        romanValues[0] = romanValues[0].toUpperCase();
        int x = 0;
        switch (romanValues[0]) {
            case "I":
                x = 1;
                break;
            case "II":

                x = 2;
                break;
            case "III":
                x = 3;
                break;
            case "IV":
                x = 4;
                break;
            case "V":
                x = 5;
                break;
            case "VI":
                x = 6;
                break;
            case "VII":
                x = 7;
                break;
            case "VIII":
                x = 8;
                break;
            case "IX":
                x = 9;
                break;
            case "X":
                x = 10;
                break;
            default:
                System.out.println("Введите значения нужного типа");
                System.exit(0);

        }
        return x;
    }

    int getOperand2() {
        b = b.toUpperCase();
        int y = 0;
        switch (b) {
            case "I":
                y = 1;
                break;
            case "II":

                y = 2;
                break;
            case "III":
                y = 3;
                break;
            case "IV":
                y = 4;
                break;
            case "V":
                y = 5;
                break;
            case "VI":
                y = 6;
                break;
            case "VII":
                y = 7;
                break;
            case "VIII":
                y = 8;
                break;
            case "IX":
                y = 9;
                break;
            case "X":
                y = 10;
                break;
            default:
                System.out.println("Введите значения нужного типа");
                System.exit(0);

        }
        return y;
    }

    int calc() {
        switch (operation) {
            case '+':
                z = x + y;
                break;
            case '-':
                z = x - y;
                break;
            case '*':
                z = x * y;
                break;
            case '/':
                if (x % y == 0) {
                    z = x / y;
                } else {
                    System.out.println("Число не делится");
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Неправильная операция");
                System.exit(0);
        }
        return z;
    }

    String decToRoman() {
        StringBuilder roman = new StringBuilder();
        Roman[] values = Roman.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (this.z >= values[i].weight) {
                roman.append(values[i]);
                this.z -= values[i].weight;
            }
        }
        return roman.toString();
    }

    void showRResult() {
        System.out.println(result);
    }
}



