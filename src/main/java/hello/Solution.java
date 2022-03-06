package hello;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3};
        
        int i = deleteAndEarn(nums);
        System.out.println("i = " + i);


    }

    static public int deleteAndEarn(int[] nums) {

        Map<Integer, Integer> sumMap = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            sumMap.merge(num, num, (k, v) -> k + v);
        }
        log.info("{}", sumMap);
        while(!sumMap.isEmpty()) {
            int maxKey = 0;
            int max = -1;
            for (Integer k : sumMap.keySet()) {
                Integer v = sumMap.get(k);
                if (v > max) {
                    max = v;
                    maxKey = k;
                }
            }

            result += sumMap.remove(maxKey);
            sumMap.remove(maxKey + 1);
            sumMap.remove(maxKey - 1);
        }
        return result;
    }
}
