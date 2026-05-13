class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> vis = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, -1});
        vis.add(0);

        while (!q.isEmpty()) {
            int arr[] = q.poll();
            int curr = arr[0];
            int parent = arr[1];
            
            for (int i : graph.get(curr)) {
                if (!vis.contains(i)) {
                    q.offer(new int[]{i, curr});
                    vis.add(i);
                }
                else {
                    if (i != parent) return false;
                }
            }
        }

        return vis.size() == n;
    }
}
