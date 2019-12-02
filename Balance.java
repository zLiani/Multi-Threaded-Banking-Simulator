/*  
Name: Olga Zhorzholiani    
Course: CNT 4714 Fall 2019      
Assignment title: Project 2 – Synchronized, Cooperating Threads Under Locking     
Due Date: October 6, 2019 
*/
package multithreadedbankingsimulator;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Olga
 */
public class Balance {
    int BalanceAmount, sum;
    boolean occupied = false;
    private Lock lock = new ReentrantLock();
    private Condition canDeposit = lock.newCondition();
    private Condition canWithdraw = lock.newCondition();
    
    public Balance(){
        int BalanceAmount = 0;
        int sum = 0;
    }
   
    public void setDeposit(String ThreadName, int DepositAmount, Balance Bal)throws InterruptedException{
        /*
        lock.lock();
        try{
            while(occupied){
                canDeposit.await();
            }

            //occupied = true;
            Bal.sum = Bal.sum + DepositAmount;
            System.out.printf("Thread %s deposits $%-30s", ThreadName,DepositAmount);
            System.out.printf("Balance: $%-10s\n", sum);
            Bal.BalanceAmount = sum;
            canDeposit.signalAll();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        } 
        */
        Bal.sum = Bal.sum + DepositAmount;
        System.out.printf("Thread %s deposits $%-30s", ThreadName,DepositAmount);
        System.out.printf("Balance: $%-10s\n", sum);
        Bal.BalanceAmount = sum;
   
    }
    public void getWithdrawal(String ThreadName, int WithdrawalAmount, Balance BalAmount){
        lock.lock();
        try{
            while(occupied){
               canWithdraw.await();
            }
            if(WithdrawalAmount > this.sum){
                System.out.printf("                        Thread %s withdraws $%-5s - BLOCKED - Insufficient Funds.\n" ,ThreadName,WithdrawalAmount);
            }
            else{
                this.sum = this.sum - WithdrawalAmount;            
                System.out.printf("                        Thread %s withdraws $%-5s" ,ThreadName,WithdrawalAmount);
                System.out.printf("Balance: $%-10s\n", this.sum);
                this.BalanceAmount = this.sum;
            }
            canDeposit.signalAll();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
         lock.unlock(); // unlock this object
        }
    }
}