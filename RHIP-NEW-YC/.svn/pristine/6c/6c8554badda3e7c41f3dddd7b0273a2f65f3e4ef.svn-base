package com.founder.rhip.ehr.service;

import com.founder.rhip.ehr.service.basic.EHRNumberServiceImpl;


public class Sync {  
    public static void main(String[] args) {  
        for (int i = 0; i < 3; i++) {  
            Thread thread = new MyThread();  
            thread.start();  
        }  
    }  
} 

class Main {  
        public  void test() {
            synchronized (EHRNumberServiceImpl.class) {
            	System.out.println("test开始..");  
            	 try {  
                     Thread.sleep(500);  
                 } catch (InterruptedException e) {  
                     e.printStackTrace();  
                 } 
            	 System.out.println("test结束..");  
            }
            
        }
       
    
 
}  
  
class MyThread extends Thread {  
  
    public void run() {  
    	Main main = new Main();  
    	main.test();  
    }  
}  
  
 