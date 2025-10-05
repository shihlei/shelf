class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        int total = 0;
        dfs(total, cur, 0, candidates, target);
        return result;
    }
    
    public void dfs(int total, List<Integer> cur, int i, int[] candidates, int target){
        // base case
        if(total == target){
            result.add(new ArrayList(cur));
            return;
        }

        // stop keep looking
        if(total > target || i >= candidates.length){
            return;
        }

        // Decision to include candidates
        cur.add(candidates[i]);
        dfs(total + candidates[i], cur, i, candidates, target);

        // Decision not to include candidates
        cur.remove(cur.size()-1);
        dfs(total, cur, i + 1, candidates, target);
    }
}
