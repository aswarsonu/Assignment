//Que-2 Write a program to convert any integer number between 1 to 500 in to Roman Expression.
//I, II, III, IV,V,VI,VII,VIII,IX,X
//50-L, 100-C, 500-D

import java.util.*;
import java.io.*;

public class Question2 {

    public static void intToRoman(int num) {

        int[] numbers = {500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder romanN = new StringBuilder();

        for(int i=0;i<numbers.length;i++) {
            while(num >= numbers[i]) {
                num -= numbers[i];
                romanN.append(romanLiterals[i]);
            }
        }
        System.out.println(romanN.toString());
      
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        intToRoman(num);
        
    }
}
