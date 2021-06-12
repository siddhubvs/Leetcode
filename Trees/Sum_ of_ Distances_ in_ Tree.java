class Solution{
public int[] sumOfDistancesInTree(int N, int[][] edges) {

	List<Integer>[] graph = new ArrayList[N];
	for (int i = 0; i < N; i++)
		graph[i] = new ArrayList<Integer>();

	for (int[] edge : edges) {
		graph[edge[0]].add(edge[1]);
		graph[edge[1]].add(edge[0]);
	}

	int[] count = new int[N];
	int[] distance = new int[N];

	boolean[] visited = new boolean[N];
	postOrder(N, 0, graph, visited, count, distance, 0);
    boolean[] visited2 = new boolean[N];
	preOrder(N, 0, graph, visited2, count, distance, -1);
	return distance;
}

public int postOrder(int N, int src, List<Integer>[] graph, boolean[] visited, int[] count, int[] distance,
		int dist) {

	visited[src] = true;
	distance[0] += dist;
	List<Integer> nbrs = graph[src];
	int subtree = 0;
	for (int nbr : nbrs) {
		if (!visited[nbr])
			subtree += postOrder(N, nbr, graph, visited, count, distance, dist + 1);
	}
	count[src] = subtree;
	return subtree + 1;
}

public static void preOrder(int N, int src, List<Integer>[] graph, boolean[] visited, int[] count, int[] distance,
		int parent) {

	if (parent != -1)
		distance[src] = distance[parent] + N - 2 * (1 + count[src]);

	visited[src] = true;
	List<Integer> nbrs = graph[src];
	for (int nbr : nbrs) {
		if (!visited[nbr])
			preOrder(N, nbr, graph, visited, count, distance, src);
	}
}
}
