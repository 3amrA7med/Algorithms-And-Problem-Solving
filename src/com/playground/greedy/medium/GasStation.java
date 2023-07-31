package com.playground.greedy.medium;

/**
 *  134. Gas Station
 */
public class GasStation {

    // Bad memory consumption
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumOfGas = 0;
        int sumOfCost = 0;
        int[] diff = new int[gas.length];
        for(int i = 0; i < gas.length; i++){
            sumOfGas += gas[i];
            sumOfCost += cost[i];
            diff[i] = gas[i] - cost[i];
        }

        if(sumOfGas < sumOfCost) return -1;

        int total = 0;
        int result = 0;
        for(int i = 0; i < diff.length; i++) {
            total += diff[i];
            if(total < 0) {
                result = i + 1;
                total = 0;
            }
        }

        return result;
    }


    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int tank = 0;
        for(int i = 0; i < gas.length; i++)
            tank += gas[i] - cost[i];

        if(tank < 0) return -1;

        int total = 0;
        int result = 0;
        for(int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if(total < 0) {
                result = i + 1;
                total = 0;
            }
        }

        return result;
    }

}
