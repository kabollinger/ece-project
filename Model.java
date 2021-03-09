/** File: Model.java

    The class Model holds the data for the GUI to look at

    @author Kate Bollinger
*/
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Model{
    
    private int width, height;
    private View view;
    private GameFinder finder;
    
    private final Runtime rt = Runtime.getRuntime();


    /** Construct a Model object
        @param w an int for the GUI width in px
        @param h an int for the GUI height in px
        @param v the associated View object
    */
    public Model(int w, int h, View v){
        width = w;
        height = h;
        view = v;
    }

    public void parse(String command){
        if(command.equals("take")) {
            takeAndEdge();
        } else { /* command == "process" */
            processAndUpdate();
        }
    }

    private void takeAndEdge(){
        try {
            view.pictureDisplay.wipePics();
            view.updateText("Taking and Edging Pictures...");
            Process takePic = rt.exec("./takePic.sh");
            takePic.waitFor();
            view.updatePics();
            Process edges = rt.exec("octave edgeDetect.m");
            edges.waitFor();
            view.updateEdges();
            //view.updateText("Pictures Taken!");
        } catch(Exception e) {
            view.updateText("Error 1!");
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    private void processAndUpdate(){
	    try{
            view.updateText("Determining Attributes...");
	        String command = "octave processGames.m";
	        Process child = rt.exec(command);
	        child.waitFor();

	        BufferedReader in = new BufferedReader(new InputStreamReader(child.getInputStream()));
	        String line;
	        if ((line = in.readLine()) != null) {
	          System.out.println(line);
              finder = new GameFinder(line);
              view.updateText(finder.getResultString()); 
	        }
	        in.close();
	    } catch(Exception e) {}
    }
}

