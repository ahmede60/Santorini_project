package giu.santorini.view;

import giu.santorini.Board;
import giu.santorini.players.Player;

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
        String type1 = "";
        while(correct){
        	System.out.println("Player1: type 1 for cube and type 2 for pyramid");
        	type1 = sc.nextLine();
        	if ((type1.equals("1"))|(type1.equals("2")))
        		correct = false;		
        }
        correct = true;
        String type2 = "";
        while(correct){
        	System.out.println("Player2: type 1 for cube and type 2 for pyramid");
        	type2 = sc.nextLine();
        	if ((type2.equals("1"))|(type2.equals("2")))
        		correct = false;	
        }
        sc.close();
        Player Player1;
        if (type1.equals("1")){
        	Player1 = new Player(name1,1);
        }
        else{
        	Player1 = new Player(name1,2);
        }
        Player Player2;
        if (type2.equals("1")){
        	Player2 = new Player(name2,1);
        }
        else{
        	Player2 = new Player(name2,2);
        }
        Board game = new Board(Player1,Player2);
        System.out.print(game.Player1.name);
	}
	public static void main(String[] args){
		new View();
		
	}
}
