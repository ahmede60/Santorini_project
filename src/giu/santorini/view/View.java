package giu.santorini.view;

import java.util.Scanner;

import javax.swing.JFrame;
public class View extends JFrame{
	public View(){
		
	}
	public class ScannerClassInput{
		
	
		
		public void main(String args[])
	    {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter a String");
	        String str = sc.nextLine();
	        System.out.println("The input String is: " +str);
	    }
	}
}
