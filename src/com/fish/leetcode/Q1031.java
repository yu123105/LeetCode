package com.fish.leetcode;


/**
 * @author Jerry Fish / fishruijie@163.com
 * @since 0.0.1
 * date 2020/4/29
 * Stay curious, stay childlike.
 * 给出非负整数数组 A ，返回两个非重叠（连续）子数组中元素的最大和，子数组的长度分别为 L 和 M。（这里需要澄清的是，长为 L 的子数组可以出现在长为 M 的子数组之前或之后。）
 *
 * 从形式上看，返回最大的 V，而 V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) 并满足下列条件之一：
 *
 *  
 *
 * 0 <= i < i + L - 1 < j < j + M - 1 < A.length, 或
 * 0 <= j < j + M - 1 < i < i + L - 1 < A.length.
 *  
 *
 * 示例 1：
 *
 * 输入：A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 * 
 * 示例 2：
 *
 * 输入：A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
 * 输出：29
 * 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
 * 示例 3：
 *
 * 输入：A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
 * 输出：31
 * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
 *  
 *
 * 提示：
 *
 * L >= 1
 * M >= 1
 * L + M <= A.length <= 1000
 * 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-of-two-non-overlapping-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1031 {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[][] sumL = sumAndIndex(A, L);
        int[][] sumM = sumAndIndex(A, M);
        sortByValue(sumL, 0, sumL[0].length - 1);
        sortByValue(sumM, 0, sumM[0].length - 1);
        int[] sortedIndexL = sumL[1];
        int[] sortedIndexM = sumM[1];
        int max = Integer.MIN_VALUE;
        for(int i = 0, il = sortedIndexL.length; i < il; i++){
            //如果下表不符合标准 continue
            int lIndex = sortedIndexL[i];
            if(lIndex < M && lIndex + M + L >= A.length){
                continue;
            }
            for(int j = 0, jl = sortedIndexM.length; j < jl; j++){
                //如果下标符合标准 跟max比较，获取最大值
                int mIndex = sortedIndexM[j];
                if(mIndex + M - 1 < lIndex || lIndex + L - 1 < mIndex){
                    int l = sumL[0][i];
                    int m = sumM[0][j];
                    if(l + m > max){
                        max = l + m;
                    }
                    break;
                }
            }
        }
        return max;
    }


    private int[][] sumAndIndex(int[] a, int len) {
        int[][] sumIndex = new int[2][a.length - len + 1];
        for(int i = 0, l = a.length - len; i <= l; i++){
            sumIndex[1][i] = i;
            if(i > 0){
                sumIndex[0][i] = sumIndex[0][i - 1] - a[i - 1] + a[i + len - 1];
            } else {
                for(int j = 0; j < len; j++){
                    sumIndex[0][i] += a[j];
                }
            }
        }
        return sumIndex;
    }



    public void sortByValue(int arr[][],int start,int end) {
        int pivot = arr[0][start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i<j)&&(arr[0][j]<pivot)) {
                j--;
            }
            while ((i<j)&&(arr[0][i]>pivot)) {
                i++;
            }
            if ((arr[0][i]==arr[0][j])&&(i<j)) {
                i++;
            } else {
                int temp = arr[0][i];
                arr[0][i] = arr[0][j];
                arr[0][j] = temp;
                int tempIndex = arr[1][i];
                arr[1][i] = arr[1][j];
                arr[1][j] = tempIndex;
            }
        }
        if (i-1>start) sortByValue(arr,start,i-1);
        if (j+1<end) sortByValue(arr,j+1,end);
    }

    public static void main(String[] args) {
        System.out.println(new Q1031().maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4}, 1, 2));
        System.out.println(new Q1031().maxSumTwoNoOverlap(new int[]{3,8,1,3,2,1,8,9,0}, 3, 2));
        System.out.println(new Q1031().maxSumTwoNoOverlap(new int[]{2,1,5,6,0,9,5,0,3,8}, 4, 3));
        System.out.println(new Q1031().maxSumTwoNoOverlap(new int[]{1, 0, 3}, 1, 2));
    }
    

}