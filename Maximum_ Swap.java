class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] maxArr = new int[arr.length];
        
        int max = Integer.MIN_VALUE;
        int maxPos = arr.length - 1;
        for (int i = maxPos; i >= 0; i--) {
            int n = arr[i] - '0';
            if (n > max) {
                max = n;
                maxPos = i;
            }
            maxArr[i] = maxPos;
        }
       for (int i = 0; i < arr.length; i++) {
            int j = maxArr[i];
            if (arr[i] != arr[j]) {
                swap(arr, i, j);
                return Integer.parseInt(String.valueOf(arr));
            }
        }
       return num;
    }
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
   }
   }
