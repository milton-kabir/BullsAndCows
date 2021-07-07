package com.kabir.milton;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Input the length of the secret code:");
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        if(strArr.length>1||!isNumeric(strArr[0])){
            String sss=strArr[0];
            for(int i=1;i<strArr.length;i++){
                sss+=" "+strArr[i];
            }
            System.out.println("Error: \""+sss+"\" isn't a valid number.");
            return;
        }
        int sz = Integer.parseInt(strArr[0]);
        if(sz>36||sz==0){
            System.out.println("Error: can't generate a secret number with a length of "+sz+" because there aren't enough unique digits.");
            return;
        }
        int[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Random rnd = new Random();
        for (int i = 0; i < ar.length; i++) {
            int randomIndexToSwap = rnd.nextInt(ar.length);
            int temp = ar[randomIndexToSwap];
            ar[randomIndexToSwap] = ar[i];
            ar[i] = temp;
        }
        String st="";
        int mn=Math.min(sz,10);
        for(int i=0;i<mn;i++){
            st+=ar[i];
        }

//        System.out.println(st);
        System.out.println("Input the number of possible symbols in the code:");
        strArr = sc.nextLine().split(" ");
        if(strArr.length>1||!isNumeric(strArr[0])){
            String sss=strArr[0];
            for(int i=1;i<strArr.length;i++){
                sss+=" "+strArr[i];
            }
            System.out.println("Error: \""+sss+"\" isn't a valid number.");
            return;
        }
        int sz1 = Integer.parseInt(strArr[0]);
        if(sz1>36){
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).\n");
            return;
        }
        if(sz1<sz){
            System.out.println("Error: it's not possible to generate a code with a length of "+sz+" with "+sz1+" unique symbols.");
            return;
        }


        if(sz1>36){
            System.out.println("Error: can't generate a secret number with a length of "+sz+" because there aren't enough unique digits.");
            return;
        }
        int x=sz1-10;
        if(x<1){
            x=1;
        }
        String ss="abcdefghijklmnopqrstuvwxyz";
        for(int i=sz;i<x;i++){
            st+=ss.charAt(i);
        }
//        System.out.println(ss.charAt(x-1));
        String xx="";
        for(int i=0;i<sz;i++){
            xx+='*';
        }
        System.out.println("The secret is prepared: "+xx+" (0-9, a-"+ss.charAt(x-1)+").");


        System.out.println("Okay, let's start a game!");
        int cnt=1;

        while(true){
            System.out.println("Turn "+cnt+":");
            cnt++;
            String ts=sc.nextLine();
            int b=0,c=0;
            for(int i=0;i<ts.length();i++){
                if(st.charAt(i)==ts.charAt(i)){
                    b++;
                    ts=ts.substring(0,i)+'x'+ts.substring(i+1);
                }
            }
            for(int i=0;i<st.length();i++){
                for(int j=0;j<ts.length();j++){
                    if(st.charAt(i)==ts.charAt(j)){
                        c++;
                        ts=ts.substring(0,j)+'x'+ts.substring(j+1);
                        break;
                    }
                }
            }
            if(b==sz){
                System.out.println("Grade: "+b+" bulls\n" +
                        "Congratulations! You guessed the secret code.");
                break;
            }
            if(c==0&&b==0){
                System.out.println("Grade: None.");
            }
            else if(c==0&&b!=0){
                System.out.println("Grade: "+b+" bull(s).");
            }
            else if(c!=0&&b==0){
                System.out.println("Grade: "+c+" cow(s).");
            }
            else{
                System.out.println("Grade: "+b+" bull(s) and "+c+" cow(s).");
            }
        }
    }
}
