import java.util.*;
import java.io.*;

public class MazeSolver {
    public static void main(String[] args) throws IOException {
    		//----------FILE INPUT-----------------------------
    		File myFile = new File("samp.txt");
    		Scanner input = new Scanner (myFile);
            int numRows = input.nextInt();
            int numCols = input.nextInt();
            input.nextLine();
    		
            //----------SET START------------------------------
            int startX = 0;
            int startY = 0;
            
    		//----------SET MAZE-------------------------------
            char[][] maze = new char[numRows][numCols];

    		//----------PRINT MAZE-----------------------------
            for (int i = 0; i < numRows; i++) 
            {
                String nextLine = input.nextLine();
                for (int j = 0; j < numCols; j++) 
                {
                    char nextChar = nextLine.charAt(j);
                    maze[i][j] = nextChar;
                    System.out.print(nextChar);
                }
                System.out.println();
            }

    		//----------FIND START POINT-----------------------
            for (int i = 0; i < numRows; i++) 
            {
                for (int j = 0; j < numCols; j++) 
                {
                    if (maze[i][j] == '+') 
                    {
                        System.out.println("Starting coordinates: " + i + ", " + j);
                        startX = i;
                        startY = j;
                    }
                }
            }
            
    		//----------FIND END POINT------------------------
            for (int i = 0; i < numRows; i++) 
            {
                for (int j = 0; j < numCols; j++) 
                {
                    if (maze[i][j] == '-') 
                    {
                        System.out.println("End coordinates: " + i + ", " + j);
                    }
                }
            }
            
    		//----------START TIMER--------------------------
            long starttimer = System.currentTimeMillis();
            
    		//----------SOLVE MAZE---------------------------
            MazeEngine newMaze = new MazeEngine(maze);
            System.out.println();
            newMaze.findPath(startX, startY);
            newMaze.printMaze(numRows, numCols);
          
    		//----------END TIMER----------------------------
            long stoptimer = System.currentTimeMillis();
    		long elapsed = stoptimer - starttimer;
    		System.out.println("Solution found in: " + elapsed + " milliseconds");
    		
    		
    		//----------PRINT RESULTS TO FILE----------------
    		char [][] a = newMaze.fileout();
    		PrintWriter out = new PrintWriter("Answer.txt");
    		
    		for(int i = 0; i< numRows; i++)
    		{
    			for(int j=0; j< numCols; j++)
    			{
    				out.print(a[i][j]);
    			} out.println();
    		}
    		out.close();
    } //Main
}//Class    }
}
