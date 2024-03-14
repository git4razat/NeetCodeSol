package com.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadder {
	
	class Cell {
		int cellNumber;
		int hopCount;
	}
	
	public int snakesAndLadders(int[][] board) {
        int n = board.length; // its a square
        int[] moves = new int[1 + n * n]; // 2D -> 1D
        for (int i = 0; i < n; ++i)
	      for (int j = 0; j < n; ++j)
	        moves[(n - 1 - i) * n + ((n - i & 1) == 1 ? j + 1 : n - j)] = board[i][j];
        
        return getMinDiceThrows(moves, moves.length);
    }

    public int getMinDiceThrows(int[] moves,int N) {
		boolean visited[]=new boolean[N];
		Arrays.fill(visited, false);
		Queue<Cell> q=new LinkedList<Cell>();
		
		Cell cell=new Cell();
		cell.cellNumber=0;
		cell.hopCount=0;
		visited[0]=true;
		q.offer(cell);
		
		Cell currentCell=null;
		while(!q.isEmpty()) {
			currentCell=q.poll();
			int index=currentCell.cellNumber;
			
			if(index==N-1)
				break;
			
			for(int i=index+1;i<=(index+6) && i<N;i++) {
				if(visited[i]==false) {
					Cell newCell=new Cell();
					newCell.hopCount=currentCell.hopCount+1;
					visited[i]=true;
					if(moves[i]!=-1)
						newCell.cellNumber=moves[i];
					else
						newCell.cellNumber=i;
					
					q.offer(newCell);
					
				}
			}	
		}
		return currentCell.hopCount;
	}
	
	
	public static void main(String[] args) {
		// -1 means normal box ; other number means snake or a ladder..
		int[][] board = {
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,35,-1,-1,13,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,15,-1,-1,-1,-1}
		};
		SnakesAndLadder obj = new SnakesAndLadder();
		System.out.println(obj.snakesAndLadders(board));
	}

}
