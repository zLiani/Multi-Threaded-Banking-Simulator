/*  
Name: Olga Zhorzholiani    
Course: CNT 4714 Fall 2019      
Assignment title: Project 2 – Synchronized, Cooperating Threads Under Locking     
Due Date: October 6, 2019 
*/
package multithreadedbankingsimulator;

import java.util.Random;

/**
 *
 * @author Olga
 */
public class DepositThread implements Runnable{
    
    Random r = new Random();
    int time,DepositAmount;
    String ThreadName;
    Balance Bal1 = new Balance();
    boolean b = true;
    
    public DepositThread(String name, Balance Bal){
        ThreadName = name;
        time = r.nextInt(2000);
        Bal1 = Bal;
    }
        
    public void run(){
        while(b){
        try{  
            Thread.sleep(time);
            DepositAmount = r.nextInt(251);
            Bal1.BalanceAmount = DepositAmount;
            Bal1.setDeposit(ThreadName, DepositAmount,Bal1);
        }catch(Exception e){}
        }
    }
}