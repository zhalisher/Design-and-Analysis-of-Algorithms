Report of this assignment 

1. MergeSort (D&C, Master Case 2) 
• Linear merge;  
• reusable buffer;  
• small-n cut-off (e.g., insertion sort). 
2. QuickSort (robust) 
• Randomized pivot;  
• recurse on the smaller partition, iterate over the larger one  
• (bounded stack ≈ O(log n) typical). 
3. Deterministic Select (Median-of-Medians, O(n)) 
• Group by 5, median of medians as pivot, in-place partition;  
• recurse only into the needed side (and prefer recursing into the smaller side). 
4. Closest Pair of Points (2D, O(n log n)) 
• Sort by x, recursive split, “strip” check by y order (classic 7–8 neighbor scan). 


• Architecture notes (how depth/allocations are controlled). 
1. MergeSort 
Basically all code is a merge sort with some inmprovements. I added a cuttof to optimize and effectively use the sorting method. I have a random array the size of 50 that uses a merge sort untill it reaches the size of 16
then with the help of cutoff that i added it starts sorting with insertion sort that basically is the best option for smaller datas due to its speed of On*2 in comparison merge sorts speed is only Onlogn.

2. QuickSort
Recrusion is minimized due to the  smaller partion. Pivot is choosen randomly to reduce the risk of worst case On*2

3. Deterministic Select
Divides the random array to group of 5 and with the help of recrusion finds the median of all gorups. Than with the help of thsose medians finds the medians of medians (pivot) then in sorts the part of array where it belongs
and doesnt interract with the other part.

4. Closest Pair of Points
In this assignment i didnt use recrusion split by x . Just didnt understand how to . All i did is find the smallest distacne with the distance formula then compare all pairs with nested loop then find the smallest value.



• Recurrence analysis for each algorithm (2–6 sentences each: method used and Θ-result; Master or 
Akra–Bazzi intuition). 
1. MergeSort
Recurrence: T(n) = 2T(n/2) + Θ(n)
Standard divide and conquer merge algoritm (o n log n) time complexity cutoff improves time complexity switching to O n*2 when the array becomes smaller

2. QuickSort
Recurrence: T(n) = T(k) + T(n-k-1) + Θ(n)
Using O n log n time complexity and randomized pivot. Sorts small partiotions

3. Deterministic Select
Recurrence: T(n) = T(n/5) + T(7n/10) + Θ(n)
With the help of median of medians ensures time limit O n

4. Closest Pair of Points
Ressurence : none, as ive written above i didnt use any complex methods just nested loops and Math methods

• Plots: time vs n; depth vs n; short discussion of constant-factor effects (cache, GC). 

| Algorithm            | Time vs n                             | Depth vs n      | Notes                                           |
| -------------------- | ------------------------------------- | --------------- | ----------------------------------------------- |
| MergeSort            | Log-linear                            | log n           | Cutoff reduces overhead; good cache behavior    |
| QuickSort            | Average: log-linear; Worst: quadratic | log n (average) | Smaller partition first reduces recursion depth |
| Deterministic Select | Linear                                | log n           | Predictable depth, small arrays for medians     |
| Closest Pair         | Quadratic                             | 1               | No recursion; inefficient for large n           |


• Summary: alignment/mismatch between theory and measurements 
1. MergeSort
Matches theory; O(n log n) measured. Cutoff improves runtime for small arrays
2. QuickSort
Average-case matches O(n log n); small datasets show minimal recursion depth differences. Worst-case rare due to random pivot
3. Deterministic Select
O(n) guaranteed; median-of-medians ensures predictable performance
4. Closest Pair of Pointsx
Simple On*2 . Simple to implement BUT inneficent in large projects
