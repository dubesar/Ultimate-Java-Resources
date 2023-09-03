public boolean isValidSudoku(char[][] board) {
        return checkValidity(board, 0, 0);
    }
    
    boolean checkValidity(char[][] board, int i, int j){
        if(i == board.length)
            return true;
        //next row
        int ni = 0;
        //next column 
        int nj = 0;
        //if end of row move to next row else increment column index in same row.
        if(board[0].length - 1 == j){
            ni = i + 1;
            nj = 0;
        }else{
            ni = i;
            nj = j + 1;
        }
        if(board[i][j] == '.')
            return checkValidity(board, ni, nj);
        else{
            for(int c = 0; c < board.length; c++){
                if(board[i][j] == board[c][j] && c != i)
                    return false;
                if(board[i][j] == board[i][c] && c != j)
                    return false;
            }
			//verify the sub 3*3 matrix for the specific index.
			int smi = i/3 * 3;
			int smj = j/3 * 3;
			for(int mi = 0; mi < 3; mi++){
				for(int mj = 0; mj < 3; mj++){
					if(mi + smi != i && mj + smj != j && board[i][j] == board[mi + smi][mj + smj])
						return false;
				}
			}
            return checkValidity(board, ni, nj);
        }
    }
