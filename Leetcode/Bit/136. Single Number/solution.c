int singleNumber(int* nums, int numsSize) {
    // Input validation - handle null pointer and empty array
    if (nums == NULL || numsSize == 0) {
        return 0;  // Or could return -1 to indicate error
    }

    // Initialize to 0 (identity element for XOR)
    int result = 0;

    // XOR all numbers together. Pairs will cancel out (a ^ a = 0), leaving only the single number
    for (int i = 0; i < numsSize; i++) {
        result ^= nums[i];
    }

    return result;
}
