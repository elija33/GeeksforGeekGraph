package GraphRepresentationAdjaMatrix;

public class GraphRepresentationAdja {
    private boolean adjMatrix[][];
    private int numVertices;

    public GraphRepresentationAdja(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    // Adding Edges
    public void addEdge(int num, int numb) {
        adjMatrix[num][numb] = true;
        adjMatrix[numb][num] = true;
    }

    // Remove edges
    public void removeEdge(int num, int numb) {
        adjMatrix[num][numb] = false;
        adjMatrix[numb][num] = false;
    }

    // Print out the matrix
    public String toString() {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            name.append(i + " : ");
            for (boolean names : adjMatrix[i]) {
                name.append((names ? 1 : 0) + " ");
            }
            name.append("\n");
        }
        return name.toString();
    }

    public static void main(String[] args) {
        GraphRepresentationAdja grap = new GraphRepresentationAdja(4);
        grap.addEdge(0, 1);
        grap.addEdge(0, 2);
        grap.addEdge(1, 2);
        grap.addEdge(2, 0);
        grap.addEdge(2, 3);

        System.out.print(grap.toString());
    }
}