import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=743 lang=java
 *
 * [743] 网络延迟时间
 */

// @lc code=start
class Solution {
    public static List<int[]>[] graph;

    public int networkDelayTime(int[][] times, int n, int k) {
        buildGraph(times, n);
        int[] distToTarget = new int[n + 1];
        Arrays.fill(distToTarget, Integer.MAX_VALUE);
        distToTarget[k] = 0;

        PriorityQueue<State> pq = new PriorityQueue<State>((a, b) -> a.distFromStart - b.distFromStart);
        pq.add(new State(k, 0));

        while (!pq.isEmpty()) {
            State state = pq.poll();
            if (state.distFromStart > distToTarget[state.id])
                continue;
            List<int[]> targets = graph[state.id];
            for (int[] target : targets) {
                int t = target[0];
                int w = target[1];
                int distFromStart = w + state.distFromStart;
                if (distToTarget[t] > distFromStart) {
                    distToTarget[t] = distFromStart;
                    pq.offer(new State(t, distFromStart));
                }
            }
        }
        int max = 0;
        for (int i = 1; i < distToTarget.length; i++) {
            max = Math.max(max, distToTarget[i]);
        }

        return max == Integer.MAX_VALUE ? -1 : max;

    }

    private static void buildGraph(int[][] times, int n) {
        List<int[]>[] list = new LinkedList[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }
        for (int[] g : times) {
            int from = g[0];
            int to = g[1];
            int weight = g[2];
            list[from].add(new int[] { to, weight });
        }
        graph = list;
    }
}

class State {
    public int id;
    public int distFromStart;

    public State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}
// @lc code=end
