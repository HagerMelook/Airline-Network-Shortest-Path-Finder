package shortestPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
public class shortestPath {
    HashMap<Character,Integer> values = new HashMap<>();
    HashMap<Character,Character> path = new HashMap<>();
    HashSet<Character> explored = new HashSet<>();

    public boolean dijkstraAlgo(graph graph, char start, char end){
        for(int i = 0; i< graph.airports.size(); i++){
            if(graph.airports.get(i)==start){
                values.put(start, 0);
                path.put(start, start);
                continue;
            }
            values.put(graph.airports.get(i), Integer.MAX_VALUE);
            path.put(graph.airports.get(i),null);
        }
        while(explored.size()!=graph.airports.size()-1){
            explored.add(start);
            for(char vertex: graph.airports){
                if(graph.graphRep[graph.airports.indexOf(start)][graph.airports.indexOf(vertex)]!=0 && values.get(vertex)> (values.get(start)+graph.graphRep[graph.airports.indexOf(start)][graph.airports.indexOf(vertex)])){
                    values.remove(vertex);
                    values.put(vertex,(values.get(start)+graph.graphRep[graph.airports.indexOf(start)][graph.airports.indexOf(vertex)]));
                    path.remove(vertex);
                    path.put(vertex, start);
                    if(explored.contains(vertex)) explored.remove(vertex);
                }
            }
            start = minUnExplored(graph.airports);
            if(start == end){
                return true;
            }
        }
        return false;
    }

    private char minUnExplored(ArrayList<Character> airports){
        int min = Integer.MAX_VALUE;
        char minChar = 'A';
        for(char airport: airports){
            if(!explored.contains(airport) && min>=values.get(airport)){
                min = values.get(airport);
                minChar = airport;
            }
        }
        if(min==Integer.MAX_VALUE){
            System.out.println("There is no flights to the distination airport !!");
            System.exit(0);
        }
        return minChar;
    }
    public int getPath(char start, char end){
        if(path.get(end)==null || values.get(end)==Integer.MAX_VALUE){
            System.out.println("There is no flights to the distination airport !!");
            System.exit(0);
        }
        char pathNode = path.get(end);
            
        if(pathNode == start){
            System.out.print(pathNode+" - ");
            return values.get(end);
        }
        getPath(start,pathNode);
        System.out.print(pathNode+" - ");
        return values.get(end);
    }
}
