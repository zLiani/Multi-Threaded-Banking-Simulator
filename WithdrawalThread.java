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
public class WithdrawalThread implements Runnable{
    
    Random r = new Random();
    int time, WithdrawalAmount;
    String ThreadName;
    Balance Bal1 = new Balance();
    boolean a = true;
    
    public WithdrawalThread(String name, Balance Bal){
        ThreadName = name;
        time = r.nextInt(1000);
        Bal1 = Bal;
    }
    
    public void run(){
        while(a){
        try{
            Thread.sleep(time);
            WithdrawalAmount = r.nextInt(51) + 1;
            Bal1.BalanceAmount = WithdrawalAmount;
            Bal1.getWithdrawal(ThreadName, WithdrawalAmount, Bal1);
        }catch(Exception e){}
    }
    }
}