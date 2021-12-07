import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.println(v);
        List<Integer> neighbors = adj[v];
        for (Integer n : neighbors) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    void DFSIteratively(int v) {
        Stack<Integer> nodes = new Stack<>();
        boolean visited[] = new boolean[V];
        nodes.push(v);
        // HashSet<Integer> visited = new HashSet<>();
        while (!nodes.isEmpty()) {
            Integer temp = nodes.pop();
            // visited.add(temp);
            visited[temp] = true;
            System.out.println(temp);
            LinkedList<Integer> neighbors = adj[temp];
            for (Integer n : neighbors) {
                if (!visited[n])
                    nodes.push(n);
            }

        }
    }

    void BFSIteratively(int v) {
        boolean visited[] = new boolean[V];
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(v);
        visited[v] = true;
        while (!nodes.isEmpty()) {
            Integer temp = nodes.poll();
            System.out.println(temp);
            List<Integer> neighbors = adj[temp];
            for (Integer n : neighbors) {
                if (!visited[n]) {
                    visited[n] = true;
                    nodes.add(n);
                }
            }
        }
    }

    ArrayList<Integer> getPath(Integer[] pred, int end) {
        ArrayList<Integer> path = new ArrayList<>();
        path.add(end);
        while (pred[end] != -1) {
            path.add(pred[end]);
            end = pred[end];
        }
        Collections.reverse(path);
        return path;
    }

    void printPath(ArrayList<Integer> path) {
        System.out.println(path.toString());
    }

    void shortestPathAlgorithm(int start, int end) {
        boolean[] visited = new boolean[V];
        Integer[] pred = new Integer[V];
        for (int i = 0; i < pred.length; ++i)
            pred[i] = -1;
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(start);
        visited[start] = true;

        while (!nodes.isEmpty()) {
            Integer temp = nodes.poll();

            List<Integer> neighbors = adj[temp];
            for (Integer n : neighbors) {
                if (!visited[n]) {
                    visited[n] = true;
                    nodes.add(n);
                    pred[n] = temp;
                    if (n == end)
                        printPath(getPath(pred, end));
                }

            }

        }
    }

    int heauristic(int[] point, int[] end) {
        return (Math.abs(point[0] - end[0]) + Math.abs(point[1] - end[1])) * 10;
    }

    private boolean[] isValid(int x, int y, int[][] graph) {
        boolean[] res = new boolean[2];
        int val = -1;
        try {
            val = graph[x][y];
        } catch (IndexOutOfBoundsException e) {
            res[0] = false;
            res[1] = false;
            return res;

        }
        if (val == 1) {
            res[1] = true;
            res[0] = false;
        }
        else {
            res[0] = true;
            res[1] = false;
        }
        return res;
    }

    private ArrayList<GraphNode> getNeighbors(GraphNode n, int[][] graph) {
        ArrayList<GraphNode> temp = new ArrayList<>();
        int x = n.getX();
        int y = n.getY();
        boolean[] res1 = isValid(x + 1, y, graph);
        boolean[] res2 = isValid(x - 1, y, graph);
        boolean[] res3 = isValid(x, y + 1, graph);
        boolean[] res4 = isValid(x, y - 1, graph);
        if (res1[0]) {
            temp.add(new GraphNode(x + 1, y));
        }
        if (res1[0]) {
            temp.add(new GraphNode(x - 1, y));
        }
        if (res3[0]) {
            temp.add(new GraphNode(x, y + 1));
        }
        if (res4[0]) {
            temp.add(new GraphNode(x, y - 1));
        }
        return temp;
    }

    private void getPath(GraphNode n, int[][] graph) {
        int distance = 0;
        char[][] res = new char[graph.length][graph[0].length];
        Stack<GraphNode> path = new Stack<>();
        path.push(n);
        graph[n.getX()][n.getY()] = (char) 35;
        while (n.getPrevious() != null) {
            distance += 10;
            n = n.getPrevious();
            graph[n.getX()][n.getY()] = (char) 35;
            path.push(n);
        }
        distance /= 10;
        StringBuilder sb = new StringBuilder();
        while (!path.isEmpty()) {
            sb.append(path.pop().toString() + "\n");
        }
        System.out.println("The Path:\n" + sb.toString());
        System.out.println("The Distance: " + Integer.toString(distance));

        System.out.println("The Route:");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 35)
                    System.out.print((char) graph[i][j] + " ");
                else
                    System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    void aStar(int[][] graph, int[] start, int[] end) {
        PriorityQueue<GraphNode> unvisited = new PriorityQueue<>((x, y) -> x.getF() - y.getF());
        HashSet<GraphNode> visited = new HashSet<>();
        int x = start[0];
        int y = start[1];
        GraphNode startNode = new GraphNode(x, y, 0, 0);
        ArrayList<GraphNode> neighborStart = getNeighbors(startNode, graph);
        startNode.setNeighbors(neighborStart);
        unvisited.add(startNode);

        while (!unvisited.isEmpty()) {
            GraphNode temp = unvisited.poll();
            if (temp.getX() == end[0] && temp.getY() == end[1]) {
                getPath(temp, graph);
                break;
            }

            if (visited.contains(temp))
                continue;
            visited.add(temp);

            for (GraphNode n : temp.getNeighbors()) {
                int hValue = heauristic(new int[] { n.getX(), n.getY() }, end);
                int gValue = temp.getG() + 10;
                int fValue = gValue + hValue;

                if (fValue < n.getF()) {
                    n.setF(fValue);
                    n.setPrevious(temp);
                }
                if (n.getNeighbors().size() == 0)
                    n.setNeighbors(getNeighbors(n, graph));
                unvisited.add(n);

            }

        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

        g.DFS(2);

        System.out.println("Following is Depth First Traversal Iteratively" + "(starting from vertex 2)");
        g.DFSIteratively(2);

        System.out.println("Following is Breadth First Traversal Iteratively" + "(starting from vertex 2)");
        g.BFSIteratively(2);

        System.out.println("Shortest Path: ");
        g.shortestPathAlgorithm(0, 3);
        g.shortestPathAlgorithm(2, 1);

        int[][] graph = { { 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0 } };
        g.aStar(graph, new int[] { 0, 0 }, new int[] { 5, 5 });

    }

    private class GraphNode {
        private int x;
        private int y;
        private int g;
        private int f;
        private boolean canBeBroken;
        private GraphNode previous;
        private ArrayList<GraphNode> neighbors;

        public GraphNode(int x, int y) {
            this.x = x;
            this.y = y;
            this.f = Integer.MAX_VALUE;
            this.g = 0;
            this.canBeBroken = true;
            this.previous = null;
            this.neighbors = new ArrayList<>();
        }

        public GraphNode(int x, int y, int g, int f) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.f = f;
            this.canBeBroken = true;
            this.previous = null;
            this.neighbors = new ArrayList<>();
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            GraphNode other = (GraphNode) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "(" + getX() + ", " + getY() + ")";
        }

        public boolean getCanBebroken() {
            return canBeBroken;
        }

        public void setNeighbors(ArrayList<GraphNode> t) {
            this.neighbors = t;
        }

        public ArrayList<GraphNode> getNeighbors() {
            return neighbors;
        }

        public GraphNode getPrevious() {
            return previous;
        }

        public void setPrevious(GraphNode n) {
            this.previous = n;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getG() {
            return g;
        }

        public void setG(int g) {
            this.g = g;
        }

        public int getF() {
            return f;
        }

        public void setF(int f) {
            this.f = f;
        }

    }
}