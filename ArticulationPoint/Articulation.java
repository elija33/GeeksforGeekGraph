package ArticulationPoint;

import java.beans.beancontext.BeanContext;
import java.util.Iterator;
import java.util.LinkedList;

public class Articulation {
    private int V;

    private LinkedList<Integer> name[];
    int time = 0;
    static final int NIL = -1;

    Articulation(int v) {
        V = v;
        name = new LinkedList[V];
        for (int i = 0; i < v; ++i) {
            name[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        name[v].add(w);
        name[w].add(v);
    }

    void APUtil(int u, boolean visited[], int disc[], int low[], int parent[], boolean ap[]) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        Iterator<Integer> names = name[u].iterator();
        while (names.hasNext()) {
            int v = names.next();
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);
                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == NIL && children > 1) {
                    ap[u] = true;
                }

                if (parent[u] != NIL && low[v] >= disc[u]) {
                    ap[u] = true;
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void AP() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        boolean ap[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
            visited[i] = false;
            ap[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                APUtil(i, visited, disc, low, parent, ap);
            }
        }
    }

}
