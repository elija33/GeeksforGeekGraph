# GeeksforGeekGraph
                                Shortest Path in an Unweighted Graph

Initialige dist[v] = {INF, INF, ... INF}
Dist[s] = 0
create a queue, q
Initialige: Virited[v] = {false, false, ... , false}
q.push(s), visited[s] = true
while(q is not empty){
    u = q.pop()
    for every adjacent v of u{
        if(visited[v] == false)
        {
            dist[v] = dist[u] + 1
            visited[v] = true;
            q.push(u).
        }
    }
}

print dist[]