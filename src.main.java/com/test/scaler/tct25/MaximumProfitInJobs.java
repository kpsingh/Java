package com.test.scaler.tct25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumProfitInJobs {

    // maximum number of jobs are 50000
    int[] memo = new int[50001];

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 50}, {3, 5, 20}, {6, 19, 100}, {2, 100, 200}};
        MaximumProfitInJobs maximumProfitInJobs = new MaximumProfitInJobs();
        int ans = maximumProfitInJobs.solve(arr);
        System.out.println(ans);

    }

    private int findNextJob(int[] startTime, int lastEndingTime) {
        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (startTime[mid] >= lastEndingTime) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }

    private int findMaxProfit(List<Pair> jobs, int[] startTime, int n, int position) {
        // 0 profit if we have already iterated over all the jobs
        if (position == n) {
            return 0;
        }

        // return result directly if it's calculated
        if (memo[position] != -1) {
            return memo[position];
        }

        // nextIndex is the index of next non-conflicting job
        int nextIndex = findNextJob(startTime, jobs.get(position).end);

        // find the maximum profit of our two options: skipping or scheduling the current job
        int maxProfit = Math.max(findMaxProfit(jobs, startTime, n, position + 1),
                jobs.get(position).profit + findMaxProfit(jobs, startTime, n, nextIndex));

        // return maximum profit and also store it for future reference (memoization)
        return memo[position] = maxProfit;
    }

    public int solve(int[][] arr) {
        List<Pair> jobs = new ArrayList<>();

        // marking all values to -1 so that we can differentiate
        // if we have already calculated the answer or not
        Arrays.fill(memo, -1);

        // storing job's details into one list
        // this will help in sorting the jobs while maintaining the other parameters
        int length = arr.length;
        for (int i = 0; i < length; i++) {
           Pair p = new Pair(arr[i][0], arr[i][1], arr[i][2]);
           jobs.add(p);
        }
        jobs.sort((j1, j2) -> j1.start = j2.start);
        int[] startTime = new int[length];
        // binary search will be used in startTime so store it as separate list
        for (int i = 0; i < length; i++) {
            startTime[i] = jobs.get(i).start;
        }

        return findMaxProfit(jobs, startTime, length, 0);
    }
}

class Pair {
    int start;
    int end;
    int profit;

    Pair(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
