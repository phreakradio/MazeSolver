public class MazeEngine{
	boolean wall = false;
    char[][] maze;
    boolean solved;
    int startX;
    int startY;
    
    public MazeEngine(char[][] input) 
    {
    	maze = input;
    }

    public void findPath(int row, int col) 
    {
    	/* 
    	 * If the value being looked at is the exit, 
    	 * we have solved the maze.
    	 */
        if (maze[row][col] == '-') 
        {
            solved = true;
            return;
        }

        maze[row][col] = '.';

        /* 
    	 * If the value on bottom is empty or is an exit,
    	 * we recall the function.
    	 */
        if (maze[row + 1][col] == ' ' || maze[row + 1][col] == '-') 
        {
            findPath(row + 1, col);
        }
        
        /* 
    	 * If the value on right is empty or is an exit, 
    	 */
        else if (maze[row][col + 1] == ' ' || maze[row][col + 1] == '-') 
        {
            findPath(row, col + 1);
        }
        
        /* 
    	 * If the value on top is empty or is an exit, 
    	 */
        else if (maze[row - 1][col] == ' ' || maze[row - 1][col] == '-') 
        {
            findPath(row -1, col);
        }
        
        /* 
    	 * If the value on left is empty or is an exit, 
    	 */
        else if (maze[row][col - 1] == ' ' || maze[row][col - 1] == '-') 
        {
            findPath(row, col - 1);
        }
        
        else 
        {
            wall = true;
            return;
        }

        if (wall) 
        {
            wall = false;
            findPath(row, col);
        }

        if (solved) 
        {
            maze[row][col] = '+';
        }

    }

    public void printMaze(int rows, int cols) 
    {
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                System.out.print(maze[i][j]);
            }

            System.out.println();
        }
    }
    
    public char[][] fileout()
    {
    	return maze;
    }
}
