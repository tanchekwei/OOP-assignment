/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JT
 */
public class Date {
    private int day, month, year;
    private int startTime, endTime;
    
    public Date(int day, int month, int startTime, int endTime){
        this.day = day;
        this.month = month;
        this.year = 2017;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public String toString(){
        return String.format("%2d-%2d-%4d %d:00-%d:00", day, month, year, startTime, endTime);
    }
    
    //Mutator
    public void setDay(int day){
        this.day = day;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setStartTime(int startTime){
        this.startTime = startTime;
    }
    public void setEndTime(int endTime){
        this.endTime = endTime;
    }
    
    //Accessor
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public int getStartTime(){
        return startTime;
    }
    public int getEndTime(){
        return endTime;
    }
    
}
