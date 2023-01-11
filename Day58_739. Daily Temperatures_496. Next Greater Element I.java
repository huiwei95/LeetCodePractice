// 739. Daily Temperatures
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int lens = temperatures.length;
        int[] res = new int[lens];

        Deque<Integer> stack = new LinkedList<>();
        stack.add(0);
        for (int i = 1; i < lens; i ++) {
            
            if (temperatures[i] <= temperatures[stack.getLast()]) {
                stack.addLast(i);
            } else {
                while (!stack.isEmpty()&&temperatures[i] > temperatures[stack.getLast()]) {
                    res[stack.getLast()] = i-stack.removeLast();

                }
                stack.addLast(i);
            }
        }

        return res;
    }
}





// 496. Next Greater Element I
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // 创建一个result数组，初始值为-1
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        // 创建HashMap，后序来判断nums2[i]是否在nums1中出现过。
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i ++) {
            map.put(nums1[i], i); 
        }
        
        // 创建stack
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums2.length; i ++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.empty() && nums2[i] > nums2[stack.peek()]) {
                    if (map.containsKey(nums2[stack.peek()])) {
                        Integer index = map.get(nums2[stack.peek()]);
                        result[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
}