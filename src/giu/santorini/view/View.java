package giu.santorini.view;

import giu.santorini.Board;
import giu.santorini.players.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class View extends JFrame{
	Board game;
	JPanel board;
	JPanel text;
	public View(){
		JFrame inputwindow = new JFrame();
        inputwindow.setVisible(true);
        inputwindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inputwindow.setSize(500,500);
		JPanel input = new JPanel(new GridLayout(2,1));
		input.setVisible(true);
		input.setPreferredSize(new Dimension(500,500));
		inputwindow.add(input);
        JPanel inputpanel = new JPanel(new GridLayout(2,2));
        inputpanel.setSize(500,200);
        inputpanel.setVisible(true);
        JLabel instruction = new JLabel("<html>Cube can only move vertically and horizontally<br/>"
        		+ "Pyramid can only move diagonally<br/>"
        		+ "Colors will represent the tile's level<br/>"
        		+ "Light Gray: Level 0<br/>"
        		+ "Gray: Level 1<br/>"
        		+ "Dark Gray: Level 2<br/>"
        		+ "Black: Level 3<br/>"
        		+ "Red: Level 4</html>");
        input.add(instruction);
        input.add(inputpanel);
        JTextField name1field = new JTextField("Player1 name");
        JTextField name2field = new JTextField("Player2 name");
        JTextField type1field = new JTextField("Player1 type(1 for cube,2 for pyramid)");
        JTextField type2field = new JTextField("Player2 type(1 for cube,2 for pyramid)");
        inputpanel.add(name1field);
        inputpanel.add(name2field);
        inputpanel.add(type1field);
        inputpanel.add(type2field);
        inputwindow.revalidate();
        inputwindow.repaint();
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
        this.game = new Board(Player1,Player2);
        inputwindow.dispose();
        JFrame window = new JFrame();
        window.setVisible(true);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1500,1000);
        JPanel main = new JPanel(new BorderLayout());
        main.setPreferredSize(new Dimension(1500,1000));
        main.setVisible(true);
        main.setBackground(Color.WHITE);
        window.add(main);
        this.board = new JPanel(new GridLayout(game.SIDE,game.SIDE));
        this.board.setPreferredSize(new Dimension(1000,1000));
        this.board.setVisible(true);
        main.add(board, BorderLayout.CENTER);
        this.text = new JPanel();
        this.text.setPreferredSize(new Dimension(500,1000));
        this.text.setBackground(Color.white);
        this.text.setVisible(true);
        main.add(text, BorderLayout.EAST);
        window.revalidate();
        window.repaint();
	}
	public void updatedisplay(){
		for(int i = 0; i<this.game.SIDE; i++){
			for(int j = 0; j<this.game.SIDE; j++){
				JPanel m = new JPanel();
				m.setVisible(true);
				m.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				if(this.game.display()[i][j].charAt(0)== '0'){
					m.setBackground(Color.lightGray);
				}
				if(this.game.display()[i][j].charAt(0)=='1'){
					m.setBackground(Color.GRAY);
				}
				if(this.game.display()[i][j].charAt(0)=='2'){
					m.setBackground(Color.darkGray);
				}
				if(this.game.display()[i][j].charAt(0)=='3'){
					m.setBackground(Color.BLACK);
				}
				if(this.game.display()[i][j].charAt(0)=='4'){
					m.setBackground(Color.RED);
				}
				if(!(this.game.display()[i][j].length()==1)){
					if(this.game.display()[i][j].charAt(2)=='1'){
						if(this.game.display()[i][j].charAt(1)=='C'){
							JButton b = new JButton("CUBE");
							b.setBorder(BorderFactory.createLineBorder(Color.BLUE));
							m.add(b);
						}
						else{
							JButton b = new JButton("PYRAMID");
							b.setBorder(BorderFactory.createLineBorder(Color.BLUE));
							m.add(b);
						}
					}
					else{
						if(this.game.display()[i][j].charAt(1)=='C'){
							JButton b = new JButton("CUBE");
							b.setBorder(BorderFactory.createLineBorder(Color.GREEN));
							m.add(b);
						}
						else{
							JButton b = new JButton("PYRAMID");
							b.setBorder(BorderFactory.createLineBorder(Color.GREEN));
							m.add(b);
						}
					}
				}
				this.board.add(m);
			}
		}
		this.text.add(new JLabel("It is "+this.game.getTurn().name+"' turn."));
		revalidate();
		repaint();
	}
	public static void main(String[] args){
		View view =new View();
		view.updatedisplay();
		
	}
}
