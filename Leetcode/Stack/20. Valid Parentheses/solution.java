class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
         
        for(char c: s.toCharArray()){
            // open brackets
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            // close brackets
            else{
                if(!stack.isEmpty()){
                    char closing = stack.pop();
                    if((closing == '(' && c == ')') || (closing == '{' && c == '}') || (closing == '[' && c == ']')){
                        continue;
                    }
                    return false;
                }
                else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
