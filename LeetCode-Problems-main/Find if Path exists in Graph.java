class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[]graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int []edge : edges){
            int startNode =edge[0];
            int endNode=edge[1];

            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }
        return depth_first_search(graph,source,destination,new boolean[n]);
    }

    public boolean depth_first_search(ArrayList<Integer>[] graph,int source,int destination,boolean []visited){
        if(source == destination){
            return true;
        }

        visited[source]=true;
        for(int i=0;i<graph[source].size();i++){
            int node=graph[source].get(i);
            if(!visited[node]){
                if(depth_first_search(graph,node,destination,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
