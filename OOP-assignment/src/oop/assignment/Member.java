/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JT
 */
import java.util.Scanner;
import java.io.*;
import java.util.Calendar;
import java.util.Date;

public class Member extends Person {
    private Date date = new Date();
    private int numOfPeopleIntroduced, year = 18;
    private int month = date.getMonth() + 1;
    private static int nextMemId;
    Scanner in = new Scanner(System.in);
    
    public Member(String ic, String contactNum, Name name){
        super(ic, contactNum, name);
        setCode('M');
        setId(Integer.toString(nextMemId));
    }
    
    public void addMember() throws IOException{
        //When file nothing inside, program crash, need fix
        //Validations required
        
        //Get the latest id number for next member
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Member.txt")));
        String s1, s2 = "";
        while(true){
            s1 = reader.readLine();
            if(s1 != null){
                s2 = s1;
            }
            else 
                break;
        }
        reader.close();
        s2 = s2.substring(1, 5);
        nextMemId = Integer.parseInt(s2);//Convert string to int
        nextMemId++;//increase id by 1 for new member
        
        //Add Member
        System.out.println("Add Member");
        System.out.println("----------");
        System.out.print("Enter first name    : ");
        String fName = in.nextLine();
        System.out.print("Enter last name     : ");
        String lName = in.nextLine();
        System.out.print("Enter ic number     : ");
        String icNo = in.nextLine();
        System.out.print("Enter contact number: ");
        String contactNo = in.nextLine();
        
        Member newMember = new Member(icNo, contactNo, new Name(fName, lName));
        
        System.out.println("Member ID     : " + newMember.getCode() + newMember.getId());
        System.out.println("Full Name     : " + lName + " " + fName);
        System.out.println("IC Number     : " + icNo);
        System.out.println("Contact Number: " + contactNo);
        System.out.println("Expired Date  : " + month + "/" + year);
        System.out.println("Confirm create new member? ");
        System.out.println("1 - YES   0 - NO");
        System.out.print  ("Answer: ");
        int ans = in.nextInt();
        
        if(ans == 1){
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File("Member.txt"), true));
        
            writer.println(newMember.toString() + "," + month + "," + year);
        
            writer.close();
        }
        else
            System.out.println("Canceled operation.");
    }
    
    public void delMember() throws IOException{
        System.out.println("Delete Member");
        System.out.println("-------------");
        System.out.print  ("Enter Member ID that wish to delete: ");
        String id = in.next();
        //Better show member record
        System.out.println("Confirm delete existed member? ");
        System.out.println("1 - YES   0 - NO");
        System.out.print  ("Answer: ");
        int ans = in.nextInt();
        if(ans == 1){
            //Copy all lines to new file except specificed line
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Member.txt")));
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File("tempMember.txt"), true));        
            String s1;
            while(true){
                s1 = reader.readLine();
                if(s1 != null){
                    if(s1.substring(0, 5).compareToIgnoreCase(id) != 0)
                        writer.println(s1);
                }
                else break;
            }
            writer.close();
            reader.close();

            //Delete old file and rename the new file
            File oldFile = new File("Member.txt");
            File newFile = new File("tempMember.txt");
            oldFile.delete();
            newFile.renameTo(oldFile);
            System.out.println("Deleted member's record successfully.");
        }
        else
            System.out.print("Canceled operation.");
    }
    
    public void modifyMember() throws IOException{
        System.out.println("Modify Member Information");
        System.out.println("-------------------------");
        System.out.println("* Only contact number are able to modify");
        System.out.print  ("Enter Member ID that wish to modify: ");
        String id = in.next();
        //loop and search
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Member.txt")));
        PrintWriter writer = new PrintWriter(new FileOutputStream(new File("tempMember.txt"), true));
        String s1, s2 = "";
        while(true){
            s1 = reader.readLine();
            if(s1 != null){
                if(s1.substring(0, 5).compareToIgnoreCase(id) != 0){
                    writer.println(s1);
                }
                else{
                    s2 = s1;
                }
            }
            else break;
        }
        String s3[] = s2.split(",");
        reader.close();
        //----------
        System.out.println("Current contact number: " + s3[2]);
        System.out.print  ("New contact number    : ");
        String newContactNum = in.next();
        
        System.out.println("Confirm modify current data? ");
        System.out.println("1 - YES   0 - NO");
        System.out.print  ("Answer: ");
        int ans = in.nextInt();
        
        if(ans == 1){
            writer.println(s3[0] + "," + s3[1] + "," + newContactNum + "," + s3[3] + "," + s3[4] + "," + s3[5] + "," + s3[6]);
            System.out.println("Modified member's contact number successfully.");
        }
        else{
            writer.println(s2);
            System.out.println("Canceled Operation.");
        }
        writer.close();
        
        //Delete old file and rename the new file
        File oldFile = new File("Member.txt");
        File newFile = new File("tempMember.txt");
        oldFile.delete();
        newFile.renameTo(oldFile);
    }
    
    public void searchMember() throws IOException{
        System.out.println("Search Member Information");
        System.out.println("-------------------------");
        System.out.print  ("Enter Member ID that wish to search: ");
        String id = in.next();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Member.txt")));
        String s1, s2 = "";
        while(true){
            s1 = reader.readLine();
            if(s1 != null){
                if(s1.substring(0, 5).compareToIgnoreCase(id) == 0){
                    s2 = s1;
                    break;
                }
            }
            else
                break;
        }
        String s3[] = s2.split(",");
        System.out.println("Member ID              : " + s3[0]);
        System.out.println("First Name             : " + s3[3]);
        System.out.println("Last Name              ; " + s3[4]);
        System.out.println("IC Number              : " + s3[1]);
        System.out.println("Contact Number         : " + s3[2]);
        System.out.println("Membership Expired Date: " + s3[5] + "/" + s3[6]);
    }
    
    public void displayMember() throws IOException{
        int count = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Member.txt")));
        String s1;
        
        System.out.println("ID    IC NUMBER    CONTACT NO. FIRST NAME LAST NAME  EXP DATE(MM/YY)");
        System.out.println("----- ------------ ----------- ---------- ---------- ---------------");
        while(true){
            s1 = reader.readLine();
            if(s1 != null){
                System.out.println(s1);
                count++;
            }
            else
                break;
        }
        System.out.println("Total " + count + " records.");
        System.out.println("Report generated by " + date.getDate() + "-" + (date.getMonth() + 1) + "-" + (date.getYear() + 1900) + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
        reader.close();
    }
    
    //Delete expired membership
    public void clearMember(){
        
    }
}
