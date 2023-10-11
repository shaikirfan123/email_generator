package org.example;

import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String department;
    private String password;
    private String alternateemail;
    private int mailboxcapacity;

    //constructor to recieve first and last name
    public Email(String firstname,String lastname){
        this.firstname=firstname;
        this.lastname=lastname;
        System.out.print("Email created " +this.firstname +this.lastname);
     this.department=setdepartment();
     System.out.print(department);
    }

    //Ask for department
    private String setdepartment(){
        System.out.print("Department codes:\n 1 for dev \n  2 for tester \n 3 for nothing\n ");
        Scanner sc=new Scanner(System.in);
        System.out.print("enter department code");
        int n=sc.nextInt();

        if(n==1){
            return "developer";

        }
        else if(n==2){
            return "tester";
        }
        else{
            return "nothing";
        }

    }

}

