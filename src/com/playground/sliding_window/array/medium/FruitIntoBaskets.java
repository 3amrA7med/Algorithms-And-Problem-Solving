package com.playground.sliding_window.array.medium;

/**
 * 904. Fruit Into Baskets
 * ==========================
 * You are visiting a farm that has a single row of fruit trees arranged from left to right.
 * The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 * You only have two baskets, and each basket can only hold a single type of fruit.
 * There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree
 * (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 * =============================
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * Example 2:
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 */
public class FruitIntoBaskets {

    public void run() {
        System.out.println(this.totalFruit(new int[] {1,2,1}));
    }

    /**
     * Runtime 7ms Beats 90.80%
     * Memory 54.30MB Beats 73.29%
     * can be solved with a hashmap and check the size of the map if above 2, make it valid again
     */
    public int totalFruit(int[] fruits) {
        if(fruits.length <= 2) return fruits.length;

        int start = 0;
        int maxCount = 0;
        int basket1 = -1;
        int basket2 = -1;
        int basket1Count = 0;
        int basket2Count = 0;

        for(int i = 0; i < fruits.length; i++) {
            if(fruits[i] == basket1) basket1Count++;
            else if(fruits[i] == basket2) basket2Count++;
            else if(basket1 == -1) {
                basket1 = fruits[i];
                basket1Count = 1;
            }
            else if(basket2 == -1) {
                basket2 = fruits[i];
                basket2Count = 1;
            }
            else {
                while(start < i && basket1Count != 0 && basket2Count != 0) {
                    if(fruits[start] == basket1) basket1Count--;
                    else basket2Count--;
                    start++;
                }
                if(basket1Count == 0) {
                    basket1 = basket2;
                    basket1Count = basket2Count;
                }
                basket2 = fruits[i];
                basket2Count = 1;
            }

            maxCount = Math.max(maxCount, basket1Count + basket2Count);
        }

        return maxCount;
    }
}
