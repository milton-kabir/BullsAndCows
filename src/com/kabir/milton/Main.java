package com.kabir.milton;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String st=sc.nextLine(),ts="9305";
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
        if(c==0&&b==0){
            System.out.println("Grade: None. The secret code is 9305.");
        }
        else if(c==0&&b!=0){
            System.out.println("Grade: "+b+" bull(s). The secret code is 9305.");
        }
        else if(c!=0&&b==0){
            System.out.println("Grade: "+c+" cow(s). The secret code is 9305.");
        }
        else{
            System.out.println("Grade: "+b+" bull(s) and "+c+" cow(s). The secret code is 9305.");
        }
    }
}
