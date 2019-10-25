package com.company;

public class Main {

    public static void main(String[] args) {

        int[] w = {10, 20, 1};
        int[] p = {10000, 7000, 2000};

        int bag = 20;

        int money = knapsack(w, p, bag);

        System.out.println(money);
    }

    private static int knapsack(int[] w, int[] p, int bag) {
        int[] d = new int[w.length];

        for (int i = 0; i < d.length; i++) {
            d[i] = p[i]/w[i];
        }

        selection(d, p, w);

        int money = 0;

        for (int i = d.length - 1; i >= 0 && bag > 0; i--) {

            if (w[i] <= bag){
                bag = bag - w[i];
                money = money + p[i];
            } else {
                money = money + d[i] * bag;
                bag = 0;
            }

        }

        return money;
    }

    public static void selection(int[] nums, int[] p, int[] w){

        for (int i = 0; i < nums.length; i++) {
            int maxIndex = max(nums, 0, nums.length - i - 1);
            swap(nums, maxIndex, nums.length - i - 1);
            swap(p, maxIndex, nums.length - i - 1);
            swap(w, maxIndex, nums.length - i - 1);
        }
    }

    public static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static int max(int[] nums, int start, int end){

        int m = start;

        for (int i = 0; i <= end; i++) {
            if (nums[m] < nums[i]){
                m = i;
            }
        }

        return m;
    }
}
