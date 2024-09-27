package shortestPath;
import java.util.ArrayList;

public class graph {
    int [][] graphRep;
    ArrayList<Character> airports = new ArrayList<>();

    graph(String [] vertices){
        for(int i = 0; i<vertices.length; i++)
            airports.add(vertices[i].charAt(0));
        graphRep = new int[vertices.length][vertices.length];
    }

    public void setDist(char airport1, char airport2, int dist){
        if(dist<=0){
            System.out.println("Not valid!!");
            System.exit(0);
        }
        graphRep[airports.indexOf(airport1)][airports.indexOf(airport2)] = dist;
        graphRep[airports.indexOf(airport2)][airports.indexOf(airport1)] = dist;
    }
}
