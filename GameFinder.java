import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;

class GameFinder{

    private String color, shape;
    private Integer size;

    private ArrayList<String> matchAll, matchColorShape, matchColorSize, matchShapeSize;

    public GameFinder(String attrLine){
        this.matchAll = new ArrayList<String>();
        this.matchColorShape = new ArrayList<String>();
        this.matchColorSize = new ArrayList<String>();
        this.matchShapeSize = new ArrayList<String>();

        String[] tokens = attrLine.split("\\s+");
        this.size = Integer.parseInt(tokens[2]);
        this.shape = tokens[1];
        this.color = tokens[0];
        
        matchGames();
    }

    private void matchGames(){
        try (BufferedReader br = new BufferedReader(new FileReader("gameSheet.csv"))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(",");
                Integer testSize = Integer.parseInt(tokens[3]);
                String testShape = tokens[2];
                String testColor = tokens[1];
                System.out.println(line);
                if (testColor.equals(color)){
                    if ((testShape.equals(shape)) && ((testSize - 1 <= size) || (size < testSize + 1))) {
                        System.out.println("a");
                        matchAll.add(gameName(line));
                    } else if (testShape.equals(shape)) {
                        System.out.println("shp");
                        matchColorShape.add(gameName(line));
                    } else if ((testSize - 1 <= size) && (size < testSize + 1)) {
                        System.out.println("sz");
                        matchColorSize.add(gameName(line));
                    }
                } else if ((testShape.equals(shape)) && ((testSize - 1 <= size) || (size < testSize + 1))) { 
                    System.out.println("a");
                    matchShapeSize.add(gameName(line));
                }
            }
        } catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    private String gameName(String aline){
        String[] line = aline.split(",");
        return line[0];
    }

    private String makeResultString(){
        StringBuilder builder = new StringBuilder();
        builder.append("<html><pre>");

        builder.append("Piece is " + color + " " + shape + " " + size.toString() + "mm<br>");
        builder.append("------matching all attrs------<br>");
        for (String game : matchAll) {
            builder.append(game + "<br>");
        }
        
        builder.append("------matching color and size------<br>");
        for (String game : matchColorSize) {
            builder.append(game + "<br>");
        }
        
        builder.append("</pre></html>");
    
        return builder.toString();
    }

    public String getResultString(){
        matchGames();
        return makeResultString();
    }
}
