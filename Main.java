/** File: Main.java
    
    Java main function for Putting the Pieces Together

    @author Kate Bollinger
*/

class Main{
    private static final int WIDTH = 800, /* calculated by trial and error */
                             HEIGHT = 448;
    
    /** Main makes view.
        @param args the command line args
    */
    public static void main(String[] args){
        new View(WIDTH, HEIGHT);
    }
}
