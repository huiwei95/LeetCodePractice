/**
242. Valid Anagram

Note: array is one of hashtable
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ary = new int[26];
         
        for (int i = 0; i < s.length(); i ++) {
            ary[s.charAt(i) - 'a']++;
        }
        
        for (int j = 0; j < t.length(); j ++) {
            ary[t.charAt(j) - 'a']--;
        }
        
        for (int count: ary) {
            if (count != 0) 
                return false;
        }
        return true;
    }
}






/**
349. Intersection of Two Arrays

Note:using Set to solve it.
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // create a Set interface, using HashSet to realize
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        
        // adding nums1 value from array to set
        for (int i: nums1) {
            set1.add(i);
        }
        
        // compare nums2 to nums1
        for (int i: nums2) {
            if (set1.contains(i)) {
                result.add(i);
            }
        }
        // convert result set to array;
        int[] ary = new int[result.size()];
        int j = 0;
        for (int i: result) {
            ary[j++] = i;
        }
        return ary;
    }
}






/**
202. Happy Number

Note: use Set to solve it
*/
class Solution {
    
    public int getSquareSum(int x) {
        int sum = 0, cur;
        while (x > 0) {
            cur = x % 10;
            sum = sum + cur * cur;
            x = x / 10;
        }
        return sum;
    }
       
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1) {
            n = getSquareSum(n);
            if (!set.add(n)) { // 如果 n 已经出现过，返回false
                return false;
            }
        }
        return true;
    }
}





/**
1. Two Sum

Note: use map to solve it
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}