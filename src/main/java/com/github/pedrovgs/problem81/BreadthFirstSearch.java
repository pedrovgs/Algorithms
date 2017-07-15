//Generic type BreadthFirstSearch implementation

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class BreadthFirstSearch<T> {
    // HasMap  of lists for Adjacency List Representation
    public HashMap<T, ArrayList<T>> adj = new HashMap<T, ArrayList<T>>();

    //Function to add an edge
    public void addEdges (T source, T destination) {
        if (adj.containsKey(source)) {
            // update the adjancy-list
            ArrayList<T> list = adj.get(source);
            list.add(destination);
            adj.put(source, list);
        } else {
            // init the adj-list
            ArrayList<T> list = new ArrayList<>();
            // adding destination node in list
            list.add(destination);
            // connect the edge and store into hash map adj
            adj.put(source, list);
        }
    }

    // BreadthFirstSearch search function with return path in a list
    public ArrayList<T> breadthFirstSearch (T source, T destination) {
        //init arraylist to store path
        ArrayList<T> bfsPath = new ArrayList<>();
        // Mark the current node as visited in a set
        Set<T> visited = new HashSet<>();
        //init list of queue
        ArrayList<T> queue = new ArrayList<>();
        // adding source in queue
        queue.add(source);
        //added init node of path into list
        bfsPath.add(source);
        // mark  as visited
        visited.add(source);
        // init flag to break loop after finding target node
        int flag = 0;
        // until the queue empty
        while (! queue.isEmpty()) {
            // get the front elemet of queue
            source = queue.get(0);
            // reomve the front element from  queue
            queue.remove(0);
            // init a temp list
            ArrayList<T> temp = new ArrayList<>();
            // check if key is present & adjancy list is not null
            if (adj.containsKey(source) && adj.get(source).size() > 0) {
                // put all the node of adjancy into temp list
                temp.addAll(adj.get(source));
            }
            // loop for all the adjacy list to visit.
            for (int i = 0; i < temp.size(); i++) {
                // check the node if not visited
                if (! visited.contains(temp.get(i))) {
                    // adding into path list
                    bfsPath.add(temp.get(i));
                    // if find the target node then break the for loop
                    if (temp.get(i).equals(destination)) {
                        flag = 1;
                        break;
                    }
                    // other wise added to queue
                    queue.add(temp.get(i));
                    // mark as visited
                    visited.add(temp.get(i));
                }
            }
            // break the while loop
            if (flag == 1) {
                break;
            }
        }
        // if not find target node
        if (flag == 0) {
            return null;
        }
        //return the list
        return bfsPath;
    }

    public static void main (String[] args) {
        // instace of class
        BreadthFirstSearch<String> obj = new BreadthFirstSearch<>();
        // input edges of grapgh
        obj.addEdges("A", "B");
        obj.addEdges("A", "D");
        obj.addEdges("B", "C");
        obj.addEdges("C", "D");
        // init list of path
        ArrayList<String> path = new ArrayList<>();
        // find the path form source and destination
        path = obj.breadthFirstSearch("A", "D");
        // print the path
        System.out.println("Following is Breadth First Search A to D");
        if (path != null) {
            System.out.println(path);
        } else {
            System.out.println("Path not found");
        }
    }
}
// This code is contributed by Jitendra Singh (jsroyal)

