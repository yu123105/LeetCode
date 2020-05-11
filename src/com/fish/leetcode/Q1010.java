package com.fish.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jerry Fish / fishruijie@163.com
 * @since 0.0.1
 * date 2020/4/29
 * Stay curious, stay childlike.
 */
public class Q1010 {

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> timeMap = new HashMap<>();
        int totalCount = 0;
        int roundTime = 60;
        for(int t : time){
            t %= roundTime;
            int leave = (roundTime - t ) % roundTime;
            if(timeMap.containsKey(leave)){
                totalCount += timeMap.get(leave);
            }
            if(timeMap.containsKey(t)){
                Integer temp = timeMap.get(t);
                timeMap.put(t, ++temp);
            } else {
                timeMap.put(t, 1);
            }
        }
        return totalCount;
    }

    /**
     * 	public int numPairsDivisibleBy60(int[] time) {
     int count = 0;
     int[] seconds = new int[60];
     for(int t : time) {
     seconds[t % 60] += 1;
     }
     count += combination(seconds[30], 2);
     count += combination(seconds[0], 2);
     int i = 1, j = 59;
     while(i < j) {
     count += seconds[i++] * seconds[j--];
     }
     return count;
     }

     // 求组合数
     public int combination(int n, int k) {
     long result = 1;
     for(int i = 1; i <= k; i++) {
     result = result * (n - i + 1) / i;
     }
     return (int)result;
     }

     作者：keen0126
     链接：https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/solution/java-2ms-ji-bai-10000-by-keen0126/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

}