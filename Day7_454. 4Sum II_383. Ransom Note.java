/**
454. 4Sum II

Algorithm
For each a in A. For each b in B.
If a + b exists in the hashmap m, increment the value.
Else add a new key a + b with the value 1.

For each c in C. For each d in D.
Lookup key 0 -(c + d) in the hashmap m.
Add its value to the count cnt.
Return the count cnt.
*/

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums1) {
            for (int j: nums2) {
                map.put(i + j, map.getOrDefault((i + j), 0) + 1);
            }
        }
        int count = 0;
        for (int i: nums3) {
            for (int j: nums4) {
                if (map.containsKey(0 - (i + j))) {
                    count = count + map.get(0 - (i + j));
                }
            }
        }
        return count;
    }
}





/**
383. Ransom Note

Note: use array as hashtable to solve
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ary = new int[26];
        
        for (int i = 0; i < magazine.length(); i ++) {
            ary[magazine.charAt(i) - 'a'] ++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            ary[ransomNote.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < ary.length; i ++) {
            if (ary[i] < 0) 
                return false;
        }
        
        return true;
    }
}




class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // sort array
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    
                    right--; 
                    left++;
                }
            }
        }
        return result;
    }
}