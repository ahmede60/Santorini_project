package giu.santorini.view;

import giu.santorini.Board;
import giu.santorini.players.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class View extends JFrame{
	JPanel board;
	JPanel messages;
	public View(){
		JFrame input = new JFrame();
        input.setVisible(true);
        input.setDefaultCloseOperation(EXIT_ON_CLOSE);
        input.setSize(500,200);
        JPanel inputpanel = new JPanel(new GridLayout(2,2));
        inputpanel.setSize(500,500);
        inputpanel.setVisible(true);
        input.add(inputpanel);
        JTextField name1field = new JTextField("Player1 name");
        JTextField name2field = new JTextField("Player2 name");
        JTextField type1field = new JTextField("Player1 type(1 for cube,2 for pyramid)");
        JTextField type2field = new JTextField("Player2 type(1 for cube,2 for pyramid)");
        inputpanel.add(name1field);
        inputpanel.add(name2field);
        inputpanel.add(type1field);
        inputpanel.add(type2field);
        input.revalidate();
        input.repaint();
        String name1 = "";
        String name2 = "";
        String type1 = "";
        String type2 = "";
        Player Player1;
        Player Player2;
        boolean correct = true;
        while(correct){
        	type1 = type1field.getText();
        	name1 = name1field.getText();
        	if ((type1.equals("1"))|(type1.equals("2")))
        		correct = false;
        }
        correct = true;
        while(correct){
        	type2 = type2field.getText();
        	name2 = name2field.getText();
        	if ((type2.equals("1"))|(type2.equals("2")))
        		correct = false;
        }
        if (type1.equals("1")){
        	Player1 = new Player(name1,1);
        }
        else{
        	Player1 = new Player(name1,2);
        }
        if (type2.equals("1")){
        	Player2 = new Player(name2,1);
        }
        else{
        	Player2 = new Player(name2,2);
        }
        Board game = new Board(Player1,Player2);
        input.dispose();
        JFrame window = new JFrame();
        window.setVisible(true);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1500,1000);
        JPanel main = new JPanel(new BorderLayout());
        main.setSize(1500,1000);
        main.setVisible(true);
        main.setBackground(Color.black);
        window.add(main);
        this.board = new JPanel(new GridLayout(game.SIDE,game.SIDE));
        this.board.setPreferredSize(new Dimension(1000,1000));
        this.board.setBackground(Color.black);
        this.board.setVisible(true);
        main.add(board, BorderLayout.CENTER);
        this.messages = new JPanel();
        this.messages.setPreferredSize(new Dimension(500,1000));
        this.messages.setBackground(Color.white);
        this.messages.setVisible(true);
        main.add(messages, BorderLayout.EAST);
	}
	public static void main(String[] args){
		new View();
		
	}
}
