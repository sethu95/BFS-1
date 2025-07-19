// Time Complexity: O(V + E)
// Space Complexity: O(V + E)

// We first identify inDegree, and starting leaves, and form adjacency matrix for outgoing edges. We perform BFS, with all starting leaves and keep decrementing inDegree and add more new starting leaves. 


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || numCourses == 1) return true;

        int inDegree[] = new int[numCourses]; // to store inDegree
        Map<Integer, List<Integer>> adjMatrix = new HashMap<>(); // to store adjacency matrix

        for(int[] preReq : prerequisites) {
            if (preReq[0] == preReq[1]) return false; // circular dependency
            adjMatrix.putIfAbsent(preReq[1], new ArrayList<>());
            adjMatrix.get(preReq[1]).add(preReq[0]);
            inDegree[preReq[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i); // we only add to queue if indegree is 0 i.e. starting leaf
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int j : adjMatrix.getOrDefault(course, new ArrayList<>())) {
                inDegree[j]--;
                if (inDegree[j] == 0) {
                    queue.add(j); // we only add to queue if indegree is 0 i.e. starting leaf
                }
            }
        }

        for (int j : inDegree) {
            if (j != 0) return false; // if any indegree is still 0, we never got to that courses, indicating not possible to complete all courses
        }

        return true; // indicates all indegree was 0 

    }
}
