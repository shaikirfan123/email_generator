package org.example;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

import static java.util.FormattableFlags.UPPERCASE;


public class Email {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS ="!@#$%^&*()-_+=<>?" ;
    int length = 12; // Change this to your desired password length
    boolean useLowercase = true;
    boolean useUppercase = true;
    boolean useDigits = true;
    boolean useSpecialCharacters = true;
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
        System.out.println("to create email,enter the department");
     this.department=setdepartment();

     String password1=generatePassword(length,useLowercase,useUppercase,useDigits,useSpecialCharacters);
      //  String password1 = this.password;
        this.password=password1;
     //   System.out.print("Generated password is :" +password1);
        generateMail(firstname,lastname,department,password);
    }
//generate email
    private void generateMail(String firstname,String lastname,String department,String password){
        System.out.println("******congratulations you have successfully created your mail id and password******");
        System.out.println("Genrated mail id: "+firstname+lastname+"."+department+"@gmail.com");
        System.out.println("Generated password: "+password);


    }
    //Ask for department
    private String setdepartment(){
        System.out.print("Department codes:\n 1 for dev \n  2 for tester \n 3 for nothing\n ");
        Scanner sc=new Scanner(System.in);
        System.out.print("enter department code:");
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

    //password
    public static String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useDigits, boolean useSpecialCharacters) {
        String allowedCharacters = "";
        if (useLowercase) {
            allowedCharacters += LOWERCASE;
        }
        if (useUppercase) {
            allowedCharacters += UPPERCASE;
        }
        if (useDigits) {
            allowedCharacters += DIGITS;
        }
        if (useSpecialCharacters) {
            allowedCharacters += SPECIAL_CHARACTERS;
        }

        if (allowedCharacters.isEmpty()) {
            throw new IllegalArgumentException("At least one character set must be allowed.");
        }

        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            password.append(allowedCharacters.charAt(randomIndex));
        }

        return password.toString();
    }

}

