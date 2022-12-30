package tutorial;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Give you name and 2 numbers");
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.next();
        splitString(inputText);
    }

    static void splitString(String str) {
        StringBuffer alpha = new StringBuffer();
        StringBuffer num1 = new StringBuffer();
        StringBuffer num2 = new StringBuffer();
        StringBuffer special = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))){
                num1.append(str.charAt(i));
//            for (int j = 1; i< str.length(); j++){
//                if (Character.isDigit(str.charAt(j))) {
//                    num2.append(str.charAt(j));
//                }
//            }
            }
            else if (Character.isAlphabetic(str.charAt(i)))
                alpha.append(str.charAt(i));
            else
                special.append(str.charAt(i));
        }


        System.out.println(alpha);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(special);
       // int finalp = product(num1,num2);
       // System.out.println("The name "+ alpha + finalp);
    }


    public static int product(StringBuffer num1, StringBuffer num2){
        var nummer1 = new String(num1);
        int  number1 = Integer.parseInt(nummer1);
        var nummer2 = new String(num2);
        int  number2 = Integer.parseInt(nummer2);
        return number1*number2;
    }
}
