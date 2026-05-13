class Solution {
    public int countComponents(int n, int[][] edges) {
        if (edges.length == 0) return 0;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        boolean vis[] = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]){
                bfs(graph, i, vis);
                cnt++;
            } 
        }

        return cnt;
    }

    private void bfs(List<List<Integer>> graph, int src, boolean vis[]){
        vis[src] = true;
        Queue<Integer> q = new LinkedList<>();

        q.add(src);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i : graph.get(curr)) {
                if (!vis[i]) {
                    vis[i] = true;
                    q.add(i);
                }
            } 
        }
    }
}
