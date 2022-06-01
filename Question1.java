//Ques- 1 Write a program to print all the possible unique combinations of characters in a given string.
//i.e TRUE, RTUE, EUTR, UTRE………………………………….

import java.util.*;
import java.io.*;

public class Quesion1{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String str = "TRUE";
    solve(str,0,str.length()-1);
    
  }
  private static void solve(String str,int l,int r){
    if(l==r){
      System.out.print(str+" ");
      return;
    }
    for(int i=l;i<=r;i++){
      str=swap(str,l,i);
      solve(str,l+1,r);
      str=swap(str,l,i);
    }
  }
  private static String swap(String str,int i,int j){
        char arr[] = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        String st = new String();
        return st.valueOf(arr);
  }
}


