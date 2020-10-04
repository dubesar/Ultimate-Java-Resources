**N Queen Problem**

This problem is to find an arrangement of N queens on a chess board, such that no queen can attack any other queens on the board.

The chess queens can attack in any direction as horizontal, vertical, horizontal and diagonal way.

A binary matrix is used to display the positions of N Queens, where no queens can attack other queens.

The solution to this problem can be solve by backtracking. 

We first place the first queen anywhere arbitrarily and then place the next queen in any of the safe places. We continue this process until the number of unplaced queens becomes zero (a solution is found) or no safe place is left. If no safe place is left, then we change the position of the previously placed queen.


**Explanation of the code**

**is_attack(int i,int j)** →  This is a function to check if the cell (i,j) is under attack by any other queen or not. We are just checking if there is any other queen in the row ‘i’ or column ‘j’. Then we are checking if there is any queen on the diagonal cells of the cell (i,j) or not. Any cell (k,l) will be diagonal to the cell (i,j) if k+l is equal to i+j or k-l is equal to i-j.

**N_queen** → This is the function where we are really implementing the backtracking algorithm.


 
**if(n==0)** → If there is no queen left, it means all queens are placed and we have got a solution.

**if((!is_attack(i,j)) && (board[i][j]!=1))** → We are just checking if the cell is available to place a queen or not.
**is_attack** function will check if the cell is under attack by any other queen and **board[i][j]!=1** is making sure that the cell is vacant. If these conditions are met then we can put a queen in the cell – **board[i][j] = 1**.

**if(N_queen(n-1)==1)** → Now, we are calling the function again to place the remaining queens and this is where we are doing backtracking. If this function (for placing the remaining queen) is not true, then we are just changing our current move – **board[i][j] = 0** and the loop will place the queen on some another position this time.

**Example**

Input:
If, the size of a chess board is 8 x 8.
Output:
The matrix that represents in which row and column the N Queens can be placed.
- 1 0 0 0 0 0 0 0
- 0 0 0 0 0 0 1 0
- 0 0 0 0 1 0 0 0
- 0 0 0 0 0 0 0 1
- 0 1 0 0 0 0 0 0
- 0 0 0 1 0 0 0 0
- 0 0 0 0 0 1 0 0
- 0 0 1 0 0 0 0 0

In this output, the value 1 indicates the correct place for the queens.

The 0 denotes the blank spaces on the chess board.
