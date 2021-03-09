import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.File;

class PictureDisplay extends JPanel {

    private Icon blank;
    private Dimension picSize;
    
    private final int WIDTH, HEIGHT;
    private int imWidth, imHeight;

    private JLabel camA, camB, edgeA, edgeB;

    public PictureDisplay(int w, int h){
        super(new GridLayout(2, 2, 10, 10));
        this.WIDTH = w;
        this.HEIGHT = h;
        this.imWidth = (int)(WIDTH * 0.5);
        this.imHeight = (int)(HEIGHT * 0.5);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        blank = scaledImage("blank.png");

        camA = new JLabel(blank);
        camB = new JLabel(blank);
        edgeA = new JLabel(blank);
        edgeB = new JLabel(blank);

        camA.setPreferredSize(new Dimension(imWidth, imHeight));
        camB.setPreferredSize(new Dimension(imWidth, imHeight));
        edgeA.setPreferredSize(new Dimension(imWidth, imHeight));
        edgeB.setPreferredSize(new Dimension(imWidth, imHeight));
        
        this.add(camA);
        this.add(camB);
        this.add(edgeA);
        this.add(edgeB);
    }

    public void wipePics() {
        camA.setIcon(blank);
        camB.setIcon(blank);
        edgeA.setIcon(blank);
        edgeB.setIcon(blank);
    }

    public void updateEdges() {
        edgeA.setIcon(scaledImage("aEdge.jpg"));
        edgeB.setIcon(scaledImage("bEdge.jpg"));
    }
    
    public void updatePics() {
        wipePics();
        camA.setIcon(scaledImage("camA.jpg"));
        camB.setIcon(scaledImage("camB.jpg"));
    }

    private ImageIcon scaledImage(String filename){
        File file = new File(filename);
        if (file.exists()){
            ImageIcon temp = new ImageIcon(filename);
            Image image = temp.getImage();  
            Image newimg = image.getScaledInstance(imWidth, imHeight, java.awt.Image.SCALE_SMOOTH);  
            return new ImageIcon(newimg);
        } else {
            return new ImageIcon("error.png");
        }
    }
}
