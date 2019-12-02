/*  
Name: Olga Zhorzholiani    
Course: CNT 4714 Fall 2019      
Assignment title: Project 2 – Synchronized, Cooperating Threads Under Locking     
Due Date: October 6, 2019 
*/
package multithreadedbankingsimulator;

/**
 *
 * @author Olga
 */
public class MultiThreadedBankingSimulator{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Pass Balance object to all threads and start them.
        Balance Bal = new Balance();
      
        Thread D1 = new Thread(new DepositThread("D1", Bal));
        Thread D2 = new Thread(new DepositThread("D2", Bal));
        Thread D3 = new Thread(new DepositThread("D3", Bal));
        Thread D4 = new Thread(new DepositThread("D4", Bal));
        
        Thread W1 = new Thread(new WithdrawalThread("W1", Bal));
        Thread W2 = new Thread(new WithdrawalThread("W2", Bal));
        Thread W3 = new Thread(new WithdrawalThread("W3", Bal));
        Thread W4 = new Thread(new WithdrawalThread("W4", Bal));
        Thread W5 = new Thread(new WithdrawalThread("W5", Bal));
        Thread W6 = new Thread(new WithdrawalThread("W6", Bal));
        Thread W7 = new Thread(new WithdrawalThread("W7", Bal));
        Thread W8 = new Thread(new WithdrawalThread("W8", Bal));
        
        System.out.println("Deposit Threads         Withdrawal Threads      Balance\n");
        System.out.println("---------------         ------------------      ---------------\n");

        D1.start();
        D2.start();
        D3.start();
        D4.start();
        W1.start();
        W2.start();
        W3.start();
        W4.start();
        W5.start();
        W6.start();
        W7.start();
        W8.start();    
    } 
}