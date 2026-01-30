class Solution {
    // Map each course to its prerequisites 
    HashMap<Integer, List<Integer>> preMap = new HashMap<>();
    // Store visiting course -> check for loop
    HashSet<Integer> visitSet = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build a graph where each course points to its prerequisites.
        for(int i=0;i<numCourses;i++){
            preMap.put(i, new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        // dfs
        for(int i=0;i<numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    // Use a visiting set to track the current DFS path
    boolean dfs(int curCourse){
        // base case: empty list -> no prerequisites for current course
        if(preMap.get(curCourse).isEmpty()){
            return true;
        }
        // base case: If the course is already in visiting, return false (cycle)
        if(visitSet.contains(curCourse)){
            return false;
        }
        
        visitSet.add(curCourse);

        // loop through the prerequisites for current course
        for(int pre: preMap.get(curCourse)){
            if(!dfs(pre)){
                return false;
            }
        }

        // After successfully processing a course, clear its prerequisite list (mark as done).
        visitSet.remove(curCourse);
        // set it to empty list
        preMap.put(curCourse, new ArrayList<>());

        return true;
    }
}

/**
HashMap to store (course/prerequisites)
DFS -> recursive to check if each course can be complicated
- If we visit a course already in the current path → cycle found.
- If a course has no prerequisites left, it’s safe.

time/space : O(v+E) 
v is the number of courses(nodes) and e is the number of prerequisites(edges)
 */
