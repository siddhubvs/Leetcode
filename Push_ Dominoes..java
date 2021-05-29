class Solution {
    public String pushDominoes(String dominoes) {
        char[] dominoesArr = dominoes.toCharArray();
        int L = -1, R = -1, idx = 0;
        
        while(idx < dominoesArr.length) {
            if (dominoesArr[idx] == 'R') {
                if (R > L) {
                    R++;
                    while(R < idx) dominoesArr[R++] = 'R';
                }
                R = idx;
            } else if (dominoesArr[idx] == 'L') {
                if (L >= R) {
                    L++;
                    while(L < idx) dominoesArr[L++] = 'L';
                } else {
                    int start = R + 1;
                    int end = idx - 1;
                    while(start < end) {
                        dominoesArr[start++] = 'R';
                        dominoesArr[end--] = 'L';
                    }
                }
                L = idx;
            } else {
                if (idx == dominoesArr.length - 1 && R > L) {
                    R++;
                    while(R <= idx) dominoesArr[R++] = 'R';
                }
            }
            idx++;
        }
        
        return String.valueOf(dominoesArr);
    }
}
