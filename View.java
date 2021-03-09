import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class View extends JFrame{

    private Model model;
    private Controller con;

    private final int WIDTH, HEIGHT; 

    private JButton processButton, takePicButton;
    private JLabel outputField;
    public PictureDisplay pictureDisplay;


    /** Consrtuct a View object
     *  @param w an integer for the width attribute
     *  @param h an integer for the height attribute
     */
    public View(int w, int h){
        super("Would You Like to Play a Game?");

        WIDTH = w;
        HEIGHT = h;
        model = new Model(w, h, this);
        con = new Controller(model);

        JPanel display = makeDisplay();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(display);
        setLocation(0, -1);
        pack();
        setVisible(true);
    }

    /** Creates and arranges the maze pannel and GUI control widgets
     *  @return a JPanel to be displayed
     *  */
    private JPanel makeDisplay(){

        /* Buttons */
        takePicButton = new JButton("Take Pictures");
        takePicButton.setActionCommand("take");
        takePicButton.addActionListener(con);

        processButton = new JButton("Find Games");
        processButton.setActionCommand("process");
        processButton.addActionListener(con);
        processButton.setEnabled(false);
        /*************/

        /* Output Pannels */
        double horizScale = 1; /* Percentage of window taken up */
        double vertScale = 0.95;
        pictureDisplay = new PictureDisplay((int)(WIDTH*horizScale), (int)(HEIGHT*vertScale));

        /* Put it together */
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.add(takePicButton);
        panel.add(processButton);
        panel.setPreferredSize(new Dimension(WIDTH, (int)(HEIGHT * (1 -vertScale))));


        JPanel pan = new JPanel(new BorderLayout());
        pan.add(pictureDisplay, "Center");
        pan.add(panel, "North");
    
        return pan;
    }

    /** Forwards update requests to pannel
     */
    public void updatePics(){
        pictureDisplay.updatePics();
    }
    
    /** Forwards update requests to pannel
     */
    public void updateEdges(){
        pictureDisplay.updateEdges();
        processButton.setEnabled(true);
    }

    /** Forwards update requests to text box
     */
    public void updateText(String text){
        //outputField.setText(text);
        JOptionPane.showMessageDialog(null, text);
    }
}
