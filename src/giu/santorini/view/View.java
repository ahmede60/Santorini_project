package giu.santorini.view;

import java.util.Scanner;

import javax.swing.JFrame;
public class View extends JFrame{
	public View(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first player's name");
        String name1 = sc.nextLine();
        System.out.println("Enter the second player's name");
        String name2 = sc.nextLine();
        boolean correct = true;
        while(correct){
        	System.out.println("Player1: type 1 for cube and type 2 for pyramid");
        	String type1 = sc.nextLine();
        	if ((type1.equals("1"))|(type1.equals("2")))
        		correct = false;		
        }
        correct = true;
        while(correct){
        	System.out.println("Player2: type 1 for cube and type 2 for pyramid");
        	String type2 = sc.nextLine();
        	if ((type2.equals("1"))|(type2.equals("2")))
        		correct = false;	
        }
	}
}
