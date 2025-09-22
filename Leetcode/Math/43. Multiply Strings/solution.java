class Solution {
    public String multiply(String num1, String num2) {
        // Handle edge case: if either number is 0
        if(num1.equals("0")|| num2.equals("0")){
            return "0";
        }

        // Create result array of size m + n
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        // Multiply each digit of num1 with each digit of num2
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                int digit1 = num1.charAt(i)-'0';
                int digit2 = num2.charAt(j)-'0';
                int multiply = digit1 * digit2;

                multiply += result[i+j+1];

                // Store current digit
                result[i + j + 1] = multiply % 10;

                // Add carry to previous position
                result[i + j] += multiply / 10;
            }
        }

        // Convert result array to string
        StringBuilder sb = new StringBuilder();
        int start = 0;

        // Skip leading zeros
        while(start < result.length && result[start] == 0){
            start++;
        }

        // add remaining digits
        while(start < result.length){
            sb.append(result[start]);
            start++;
        }

        return sb.toString();
    }
}
