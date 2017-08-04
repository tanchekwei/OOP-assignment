/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JT
 */
public class Customer extends Person {
    private static int nextCustId = 1001;
    
    public Customer(String ic, String contactNum, Name name){
        super(ic, contactNum, name);
        setCode('C');
        setId(Integer.toString(nextCustId));
        nextCustId++;
    }
}
