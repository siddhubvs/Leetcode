class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       List<Integer> res = new ArrayList<>();
	if (n == 1) {
		res.add(0);
		return res;
	}

	int[] indegree = new int[n];
	ArrayList<Integer>[] adj = new ArrayList[n];
	for(int i=0; i<n; i++) 
		adj[i] = new ArrayList<>();
	for(int[] edge: edges){
		adj[edge[0]].add(edge[1]);
		adj[edge[1]].add(edge[0]);
		indegree[edge[0]]++;
		indegree[edge[1]]++;
	}

	Queue<Integer> queue = new LinkedList<>();
	for(int i=0; i<n; i++){
		if(indegree[i] == 1)
			queue.offer(i);
	}

	while(!queue.isEmpty()){
		int size = queue.size();
		res = new ArrayList<>();

		for(int i=0; i<size; i++){
			int node = queue.poll();
			res.add(node);
			for(int j: adj[node]){
				indegree[j]--;
				if(indegree[j] == 1)
					queue.offer(j);
			}
		}
	}
	return res;
    }
}
