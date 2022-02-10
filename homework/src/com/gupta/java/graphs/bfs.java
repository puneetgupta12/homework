package com.gupta.java.graphs;

// Breadth-First search: Look at our neighbors first. Keep as close as possible then spread out.
public class bfs {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A'); //0
        graph.addVertex('B'); //1
        graph.addVertex('C'); //2
        graph.addVertex('D'); //3
        graph.addVertex('E'); //4
        graph.addVertex('F'); //5
        graph.addVertex('G'); //6
        graph.addVertex('H'); //7
        graph.addVertex('I'); //8

        graph.addEdge(0, 1); //AB
        graph.addEdge(1, 5); //BF
        graph.addEdge(5, 7); //FH
        graph.addEdge(0, 2); //AC
        graph.addEdge(0, 3); //AD
        graph.addEdge(3, 6); //DG
        graph.addEdge(6, 8); //GI
        graph.addEdge(0, 4); //AE

        graph.bfs();
    }

    public static class CustomQueue {
        private int[] q;
        private final int SIZE = 20;
        private int front;
        private int rear;

        public CustomQueue() {
            q = new int[SIZE];
            front = 0;
            rear = -1;
        }

        public void add(int v) {
            if (rear == SIZE-1) {
                rear = -1;
            }

            q[++rear] = v;
        }

        public int remove() {
            int temp = q[front++];

            if (front == SIZE) {
                front = 0;
            }

            return temp;
        }

        public boolean empty() {
            return (rear + 1 == front || front + SIZE - 1 == rear);
        }
    }

    public static class Vertex {
        public char label;
        public boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }
    }

    public static class Graph {
        private final int MAX_VERTS = 20;
        private Vertex[] vertexList;
        private int adjMat[][];
        private int nVerts;
        private CustomQueue customQueue;

        public Graph() {
            vertexList = new Vertex[MAX_VERTS];
            adjMat = new int[MAX_VERTS][MAX_VERTS];
            nVerts = 0;
            for (int i=0; i<MAX_VERTS; i++) {
                for (int j=0; j<MAX_VERTS; j++) {
                    adjMat[i][j] = 0;
                }
            }
            customQueue = new CustomQueue();
        }

        public void addVertex(char lab) {
            vertexList[nVerts++] = new Vertex(lab);
        }

        public void addEdge(int start, int end) {
            adjMat[start][end] = 1;
            adjMat[end][start] = 1;
        }

        public void displayVertex(int v) {
            System.out.println(vertexList[v].label);
        }

        public int getAdjUnvisitedVertex(int v) {
            for (int i=0; i<nVerts; i++) {
                if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                    return i;
                }
            }

            return -1;
        }

        public void bfs() {
            vertexList[0].wasVisited = true;
            displayVertex(0); //begin at vertex 0
            customQueue.add(0);
            int v2;

            while (!customQueue.empty()) {
                int v1 = customQueue.remove(); //remove vertex at head

                while ((v2 = getAdjUnvisitedVertex(v1)) != -1) { // This will give adjacent of vertex 0 or A i.e. B, C, D, E
                    vertexList[v2].wasVisited = true;
                    displayVertex(v2);
                    customQueue.add(v2);
                }
            }

            // Queue is empty, so we are done
            for (int j=0; j<nVerts; j++) { //reset flags
                vertexList[j].wasVisited = false;
            }
        }
    }
}
