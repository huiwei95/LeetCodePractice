// 704. Binary Search Way 1: 左闭右闭 (NOTE :The sequense of the Binary search must be ordered.)
class Solution {
    public int search(int[] nums, int target) {
        
        // Left pointer points the beginning of the array; Right pointer points the end of the array.        
        int left = 0, right = nums.length -1; 
        
 	// left <= right satisfies [a,b]
        while (left <= right) {
            
            //use math to find middle fomula. 
            int middle = left + (right - left) / 2;
            
            /*
            if nums[middle] is to the right of the target, right pointer shoule move left(-);
            if nums[middle] is to the left of the target, left pointer shoule move right(+);
            if nums[middle] is equal to the target, return middle;
            */
            if (nums[middle] > target) 
                right = middle - 1;
            else if (nums[middle] < target)
                left = middle + 1;
            else 
                return middle;
        }
        
        // If target exists, then return its index. Otherwise, return -1.
        return -1;
    }
}




// 704. Binary Search Way 2 左闭右开

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length; // Because right is not close, so do not point nums.length - 1
        
        while (left < right) {
            int middle = left + (right - left) / 2; 
            
            if (nums[middle] > target) right = middle; // Because right is not close, so right point include middle
            else if (nums[middle] < target) left = middle +1;
            else return middle;
        }
        return -1;
    }
}




// 27. Remove Element
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;  // slow pointer in order to find the index.
        for (int fast = 0; fast < nums.length; fast ++) { // fast pointer in order to find the value we want.
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow ++;
            }
        }
        return slow;
    }
}


