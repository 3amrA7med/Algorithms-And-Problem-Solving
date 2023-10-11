# Trees

- Notes
  - Generally speaking, if the problem requires level actions, it may be a good solution to use bfs

- Properties
  - Height = Max(L, R) + 1
  - Diameter = Hl + Hr + 2 (Path between 2 nodes)
  - Height balanced Tree: is a binary tree in which the depth of the two subtrees 
  in every node never differs by more than one
  - Some problems require to be solved by two different recursion functions:
    - EX: is subtree
  - Complete binary tree is a tree in which all levels are filled with two children except the last 
  level it should be filled from left to right

## Binary Search Trees (BST)

- Left <= Parent <= Right
- Why or when to use? 
  - Min/Max/Predecessor/Successor
  - Easy for range queries
  - Easier to implement
  - O(Log n) (if self-balancing) in all cases while Hash Tables can be resized

- Self Balancing Trees:
  - AVL
    - LL - RR -> One rotation
    - LR - RL -> Two
    - Insertion O(n log n) 
    - In order traversal O(n)
    - AVL > RB in search
  - Red-Black Trees
    - Rb > AVL in insert & delete & memory utilization

## Trie

- Reference: https://www.youtube.com/watch?v=-urNrIAQnNo
- A trie, also called digital tree and sometimes radix tree or prefix tree (as they can be searched by prefixes)
- The complexity of creating a trie is O(W*L), where W is the number of words, and L is an average length of the word:
  you need to perform L lookups on the average for each of the W words in the set.
- The same goes for looking up words later: you perform L steps for each of the W words.
- Hash insertions and lookups have the same complexity: for each word you need to check equality, which takes O(L), 
  for the overall complexity of O(W*L). 
- If you need to look up entire words, hash table is easier. However, you cannot look up words by their prefix using 
  a hash table; If prefix-based lookups are of no interest to you, use a hash table; otherwise, use a trie.