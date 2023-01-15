package giu.santorini.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;

import javax.swing.JButton;

@SuppressWarnings("serial")
class CubeButton extends JButton {
    private Shape square = createTriangle();

    public void paintBorder( Graphics g ) {
        ((Graphics2D)g).draw(square);
    }
    public void paintComponent( Graphics g ) {
        ((Graphics2D)g).fill(square);
    }
    public Dimension getPreferredSize() {
        return new Dimension(200,200);
    }
    public boolean contains(int x, int y) {
        return square.contains(x, y);
    }

    private Shape createTriangle() {
        Polygon p = new Polygon();
        p.addPoint( 50   , 150 );
        p.addPoint( 150 , 150  );
        p.addPoint( 150 ,50  );
        p.addPoint( 50 ,50  );
        return p;
    }
}
