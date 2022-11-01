# GeeksforGeekGraph
                                    BFS Based Solution
Store indegree of every vertex.
Create a Queue, q
Add all 0 indegree vertices to the q
while(q is not empty){
    a) u = q.pop();
    b) print u
    c) for every adjacent v of u
        i) Reduce indegree of v by u
        ii) if indegree of v becomes add v to the q.
}