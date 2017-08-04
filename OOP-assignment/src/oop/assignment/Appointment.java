/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JT
 */
public class Appointment {
    private int id;
    private static int nextId = 1001;
    private Customer cust;
    private Beautician beau;
    private Member memb;
    private Service serv;
    private Date date;
    
    public Appointment(Customer cust, Beautician beau, Service serv, Date date){
        this.id = nextId;
        nextId++;
        this.cust = cust;
        this.beau = beau;
        this.serv = serv;
        this.date = date;
    }
    
    public Appointment(Member memb, Beautician beau, Service serv, Date date){
        this.id = nextId;
        nextId++;
        this.memb = memb;
        this.cust = cust;
        this.beau = beau;
        this.serv = serv;
        this.date = date;
    }
    
    public String toString(){
        return String.format("%-49s %-49s %-68s %-19s", cust, beau, serv, date);
    }
}
