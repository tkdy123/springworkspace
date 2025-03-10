package com.java.app.main;

import com.java.app.emp.EmpVO;
import com.java.app.product.RemoteControl;
import com.java.app.product.impl.AudioRemocon;
import com.java.app.product.impl.TvRemocon;

public class MainExample {
   
   public static void main(String[] args) { 
        interfaceExample();
   }
	
   public static void empExample() {
	    // EmpVO => Employee
	    EmpVO first = new EmpVO();
	    EmpVO second = new EmpVO(100, "Hong");
       
	    System.out.println(first);
        System.out.println(second);
   }
  
   public static void interfaceExample() {
	   RemoteControl remote = new TvRemocon();
	   
	   remote.turnOn();
	   remote.turnOff();
	   
	   remote = new AudioRemocon();
	   
	   remote.turnOn();
	   remote.turnOff();
   }
}
