package com.kabir.milton;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please, enter the secret code's length:");
        Scanner sc = new Scanner(System.in);
        String tt=sc.nextLine();
        int sz = Integer.parseInt(tt);
        if(sz>10){
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
        for(int i=0;i<sz;i++){
            st+=ar[i];
        }
        System.out.println(st);
        System.out.println("Okay, let's start a game!");
        int cnt=1;
        while(true){
            System.out.println("Turn "+cnt+":");
            cnt++;
            String ts=sc.nextLine();
            int b=0,c=0;
            for(int i=0;i<st.length();i++){
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
