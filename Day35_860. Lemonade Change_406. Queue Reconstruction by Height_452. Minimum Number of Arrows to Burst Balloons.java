// 860. Lemonade Change
class Solution {
/**
只需要维护三种金额的数量，5，10和20。

有如下三种情况：

情况一：账单是5，直接收下。
情况二：账单是10，消耗一个5，增加一个10
情况三：账单是20，优先消耗一个10和一个5，如果不够，再消耗三个5
 */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i ++) {
            // 情况一
            if (bills[i] == 5) {
                five ++;
            // 情况二
            } else if (bills[i] == 10) {
                ten ++;
                five --;
            // 情况三
            } else if (bills[i] == 20) {
                if (ten > 0) {
                    ten --;
                    five --;
                } else {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0) return false;
        }
        return true;
    }
}





// 406. Queue Reconstruction by Height
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1],p);
        }

        return que.toArray(new int[people.length][]);
    }
}






// 452. Minimum Number of Arrows to Burst Balloons
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // sort by x_end
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p: points) {
            xStart = p[0];
            xEnd = p[1];
            // if the current balloon starts after the end of another one,
            // one needs one more arrow
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }

        return arrows;
    }
}