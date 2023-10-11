# DP 

- Sub-problems are repeated, solving optimization problems 
- When you see that the problem contains Min, Max, Number of ways, etc. You Kinda
  get a hint that the problem may be solved with Dynamic Programming
- 3 characteristic:
  - 1- Max/Min/Longest/Shortest/Num of ways to do something/ if possible to reach (maybe greedy can fit also)
  - when dp? 2-Adding a condition that affects others elements (Choose 1 but can't choose 2)
  - 3- Future decisions depends on earlier decisions
  - Any top down can be changes to bottom up with the correct ordering.

## Fibonacci series questions

- in these type of questions our dp is 1D and only depends on 2 values,
  so we can easily use O(1) memory instead of O(n) 
- how to know if it is fibonacci ? the dp must depend on only 2 values.

## 0/1 Knapsack

- Coin change problem coins[1,2,3]
- Also, we can have unbounded knapsack problem

## Longest Common Subsequence

## Palindromic substring problem

- can be solved with 2 ways, first one with dp and trying to find palindrome
  from the whole string first then decrement it
- second solution will be O(n^2) which is much better in this type of problem
  which we need to try to find the longest palindrome for each character as 
  mid-character for the palindrome in case of odd, special case for even,
  no dp in this solution
- This is called expanding algorithm
  - Pick a character
  - Expand left & right
  - Check the expanded part (as the middle is already a palindrome)
  - Check special cases for even palindrome
  
## Other DP Approaches
- DFS + Memorization
- Backtracking + Memorization
  - not all backtracking problems can have this optimization usually the problems
    that needs to generate all the combinations of the output not just the count
    is solved with backtracking
- State Machine

## Problems to solve again

- 