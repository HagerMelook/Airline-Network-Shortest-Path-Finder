package shortestPath;
import java.util.Scanner;
public class graphRep {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        System.out.println("\nEnter the list of airports: ");
        String [] vertices = reader.nextLine().split(", ");
        graph graph = new graph(vertices);
        System.out.println("\nEnter the flights: ");
        String [] edges = reader.nextLine().split(", ");
        for(String edge: edges){
            if(!graph.airports.contains(edge.charAt(0))){
                System.out.println("Airport "+edge.charAt(0)+" is not found");
                reader.close();
                    return;
            }
            if(!graph.airports.contains(edge.charAt(2))){
                System.out.println("Airport "+edge.charAt(2)+" is not found");
                reader.close();
                    return;
            }
        }
        System.out.println("\nThe distance for each flights (in miles)");
        while(reader.hasNextLine()){
            String [] dist = reader.nextLine().split("-");
            if(dist.length<3) break;
            if(!graph.airports.contains(dist[0].charAt(0))){
                System.out.println("Airport "+dist[0].charAt(0)+" is not found");
                reader.close();
                    return;
            }
            if(!graph.airports.contains(dist[1].charAt(0))){
                System.out.println("Airport "+dist[1].charAt(0)+" is not found");
                reader.close();
                    return;
            }
            graph.setDist(dist[0].charAt(0),dist[1].charAt(0),Integer.parseInt(dist[2]));
        }
        System.out.println("Enter source airport: ");
        char start = reader.nextLine().charAt(0);
        if(!graph.airports.contains(start)){
            System.out.println("Airport not found !!");
            reader.close();
            return;
        }
        System.out.println("Enter destination airport: ");
        char end = reader.nextLine().charAt(0);
        if(!graph.airports.contains(end)){
            System.out.println("Airport not found !!");
            reader.close();
            return;
        }
        shortestPath shortestPath = new shortestPath();
        boolean checkSolution = shortestPath.dijkstraAlgo(graph, start, end);
        if(!checkSolution){
            System.out.println("\nThere is no flights to the distination airport !!");
            System.exit(0);
        }
        System.out.print("\nShortest Path from "+start+" to "+end+": ");
        int totalDist = shortestPath.getPath(start, end);
        System.out.println(end);
        System.out.println("Total distance: "+ totalDist +" miles ");
        reader.close();
    }
}
