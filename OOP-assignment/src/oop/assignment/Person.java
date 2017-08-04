/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JT
 */
public class Person {
    private char code;
    private String id, ic, contactNum;
    private Name name;
    
    public Person(String ic, String contactNum, Name name){
        this.ic = ic;
        this.contactNum = contactNum;
        this.name = name;
    }
    
    public String toString(){
        return String.format("%c%4s %-12s %-12s %-20s", code, id, ic, contactNum, name);
    }
    
    //Mutator
    public void setCode(char code){
        this.code = code;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setIc(String ic){
        this.ic = ic;
    }
    public void setContactNum(String contactNum){
        this.contactNum = contactNum;
    }
    
    //Accessor
    public char getCode(){
        return code;
    }
    public String getId(){
        return id;
    }
    public String getIc(){
        return ic;
    }
    public String getContactNum(){
        return contactNum;
    }
}

class Name{
    private String firstName, lastName;
    
    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String toString(){
        return String.format("%-10s %-10s", firstName, lastName);
    }
    
    //Mutator
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    //Accessor
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
}
