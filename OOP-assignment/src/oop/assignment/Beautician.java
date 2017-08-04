/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JT
 */
public class Beautician extends Person{
    private static int nextBeauId = 1001;//read from file
    
    public Beautician(String ic, String contactNum, Name name){
        super(ic, contactNum, name);
        setCode('B');
        setId(Integer.toString(nextBeauId));
        nextBeauId++;
    }
}
