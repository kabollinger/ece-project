/** File: Controller.java

    The class Controller handels events generated by the GUI widgets

    @author Kate Bollinger
*/

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Controller implements ActionListener{    
    private Model model;    
    
    /** Constructs a Controller object
        @param m the model object this controller speaks to
    */
    public Controller(Model m){
        model = m;
    }    
        
    /** Passes a command string to the model
        @param e an ActionEvent
    */
    public void actionPerformed(ActionEvent e){
        model.parse(e.getActionCommand());
    }
}
