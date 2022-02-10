package com.gupta.java.graphs;

// DFS: Depth first search. They use stacks. Here the pointer gets away from vertex as fast as possible.
public class dfs {
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

        graph.dfs();
    }

    public static class Graph {
        private final int MAX_VERTICES = 20;
        private Vertex vertexList[]; // list of vertices
        private int adjMat[][]; // adjacency matrix
        private int nVerts; // current number of vertices
        private CustomStack customStack;

        // Initialize all stuff
        public Graph() {
            vertexList = new Vertex[MAX_VERTICES];
            adjMat = new int[MAX_VERTICES][MAX_VERTICES];
            nVerts = 0;
            customStack = new CustomStack();

            for (int i=0; i<MAX_VERTICES; i++) {
                for (int j=0; j<MAX_VERTICES; j++) {
                    adjMat[i][j] = 0;
                }
            }
        }

        public void addVertex(char label) {
            vertexList[nVerts++] = new Vertex(label);
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

        public void dfs() { // begin at vertex 0
            vertexList[0].wasVisited = true;
            displayVertex(0);
            customStack.push(0);

            while (!customStack.isEmpty()) {
                // get an unvisited vertex adjacent to stack top
                int v = getAdjUnvisitedVertex(customStack.peek());

                if (v == -1) { //if there are no adjacent vertex
                    customStack.pop();
                } else {
                    vertexList[v].wasVisited = true;
                    displayVertex(v);
                    customStack.push(v);
                }
            }

            // stack is empty so we are done
            for (int i=0; i<nVerts; i++) {
                vertexList[i].wasVisited = false;
            }
        }
    }

    public static class Vertex {
        public char label;
        public boolean wasVisited;

        public Vertex(char lab) {
            label = lab;
            wasVisited = false;
        }
    }

    public static class CustomStack {
        private final int size = 20;
        private int[] st;
        private int top;

        public CustomStack() {
            st = new int[size];
            top = -1;
        }

        public void push(int j) {
            st[++top] = j;
        }

        public int pop() {
            return st[top--];
        }

        public int peek() {
            return st[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }
}
