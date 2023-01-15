package giu.santorini.view;

import giu.santorini.Board;
import giu.santorini.players.Player;
import giu.santorini.tiles.Cube;
import giu.santorini.tiles.Piece;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener{
	Board game;
	JPanel board;
	JPanel text;
	JFrame window;
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
        JLabel instruction = new JLabel("<html>Cubes can move vertically and horizontally<br/>"
        		+ "Pyramids can only move diagonally<br/>"
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
        	type2 = type2field.getText();
        	name2 = name2field.getText();
        	if (((type1.equals("1"))|(type1.equals("2")))&
        	((type2.equals("1"))|(type2.equals("2"))))
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
        window = new JFrame();
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
		this.board.removeAll();
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
				if((this.game.Piece1a.Location.y==i)&(this.game.Piece1a.Location.x==j)){
					JButton p1a;
					if(this.game.Piece1a instanceof Cube)
						p1a = new CubeButton();
					else
						p1a = new PyramidButton();
					p1a.setForeground(Color.BLUE);
					p1a.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							move(game.Piece1a);
						}
					});
					m.add(p1a);
				}
				if((this.game.Piece1b.Location.y==i)&(this.game.Piece1b.Location.x==j)){
					JButton p1b;
					if(this.game.Piece1b instanceof Cube)
						p1b = new CubeButton();
					else
						p1b = new PyramidButton();
					p1b.setForeground(Color.BLUE);
					p1b.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							move(game.Piece1b);
						}
					});
					m.add(p1b);
				}
				if((this.game.Piece2a.Location.y==i)&(this.game.Piece2a.Location.x==j)){
					JButton p2a;
					if(this.game.Piece2a instanceof Cube)
						p2a = new CubeButton();
					else
						p2a = new PyramidButton();
					p2a.setForeground(Color.GREEN);
					p2a.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							move(game.Piece2a);
						}
					});
					m.add(p2a);
				}
				if((this.game.Piece2b.Location.y==i)&(this.game.Piece2b.Location.x==j)){
					JButton p2b;
					if(this.game.Piece2b instanceof Cube)
						p2b = new CubeButton();
					else
						p2b = new PyramidButton();
					p2b.setForeground(Color.GREEN);
					p2b.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							move(game.Piece2b);
						}
					});
					m.add(p2b);
				}
				this.board.add(m);
			}
		}
		this.text.add(new JLabel("<html>Player 1 is blue<br/>"
				+ "Player 2 is green<br/>"
				+ "It is "+this.game.getTurn().name+"' turn to move.</html>"));
		this.window.revalidate();
		this.window.repaint();
	}
	
	
	
	
	
	
	public void move(Piece Piece){
		board.removeAll();
		for(int i = 0; i<game.SIDE; i++){
			for(int j = 0; j<game.SIDE; j++){
				JPanel m = new JPanel();
				m.setVisible(true);
				m.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				if(game.display()[i][j].charAt(0)== '0'){
					m.setBackground(Color.lightGray);
				}
				if(game.display()[i][j].charAt(0)=='1'){
					m.setBackground(Color.GRAY);
				}
				if(game.display()[i][j].charAt(0)=='2'){
					m.setBackground(Color.darkGray);
				}
				if(game.display()[i][j].charAt(0)=='3'){
					m.setBackground(Color.BLACK);
				}
				if(game.display()[i][j].charAt(0)=='4'){
					m.setBackground(Color.RED);
				}
				if((game.Piece1a.Location.y==i)&(game.Piece1a.Location.x==j)){
					JButton p1a;
					if(game.Piece1a instanceof Cube)
						p1a = new CubeButton();
					else
						p1a = new PyramidButton();
					p1a.setForeground(Color.BLUE);
					m.add(p1a);
				}
				if((game.Piece1b.Location.y==i)&(game.Piece1b.Location.x==j)){
					JButton p1b;
					if(game.Piece1b instanceof Cube)
						p1b = new CubeButton();
					else
						p1b = new PyramidButton();
					p1b.setForeground(Color.BLUE);
					m.add(p1b);
				}
				if((game.Piece2a.Location.y==i)&(game.Piece2a.Location.x==j)){
					JButton p2a;
					if(game.Piece2a instanceof Cube)
						p2a = new CubeButton();
					else
						p2a = new PyramidButton();
					p2a.setForeground(Color.GREEN);
					m.add(p2a);
				}
				if((game.Piece2b.Location.y==i)&(game.Piece2b.Location.x==j)){
					JButton p2b;
					if(game.Piece2b instanceof Cube)
						p2b = new CubeButton();
					else
						p2b = new PyramidButton();
					p2b.setForeground(Color.GREEN);
					m.add(p2b);
				}
				for(int k = 0; k < Piece.possibleMoves().size();k++){
					if((Piece.possibleMoves().get(k).y==i)&(Piece.possibleMoves().get(k).x==j)){
						HighlightButton highlight = new HighlightButton();
						highlight.setForeground(Color.YELLOW);
						m.add(highlight);
					}
				}
				this.board.add(m);
			}
		}
		this.window.revalidate();
		this.window.repaint();
	}
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args){
		View view =new View();
		view.updatedisplay();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
