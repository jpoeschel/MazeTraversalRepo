/**
 * Class to traverse through a 12x12 two dimensional char array
 * @author Johnathan Poeschel
 * @version 1.0, 25 Nov 2019
 */
public class MazeTraversal {
    /**
     * private 2d char arrray to hold maze grid
     */
    private char[][] maze;
    /**
     * private int x coordinate of current location
     */
    private int x;
    /**
     * private int y coordinate of current location
     */
    private int y;
    /**
     * private boolean firstCall, stays true until after the first call of traverse
     */
    private boolean firstCall = true;

    /**
     * recursive constructor MazeTraversal updates maze and current location as it calls traverse
     * @param maze 2d char array of maze grid
     * @param x current location x coordinate
     * @param y current location y coordinate
     */
    public MazeTraversal(char[][] maze, int x, int y){
        this.maze = maze;
        this.x=x;
        this.y=y;
        maze[x][y] = 'x';
        try {
            Thread.sleep(1000);// slows down the program so user can visualize the maze being traversed
        }catch (InterruptedException ignored){

        }
        printMaze();
        traverse();
    }

    /**
     * private traverse helper function, gets called by constructor which makes the constructor recursive
     * @return Matraversal object with updated maze and current position
     */
    private MazeTraversal traverse(){

        try {
            if (maze[x + 1][y] == '.') {
                maze[x][y] = 'x';
                return new MazeTraversal(maze, x + 1, y);
            }
            else if (maze[x][y + 1] == '.') {
                maze[x][y] = 'x';
                return new MazeTraversal(maze, x, y + 1);
            }
            else if (maze[x - 1][y] == '.') {
                maze[x][y] = 'x';
                return new MazeTraversal(maze, x - 1, y);
            }
            else if (maze[x][y - 1] == '.') {
                maze[x][y] = 'x';
                return new MazeTraversal(maze, x, y - 1);
            }
            if (maze[x + 1][y] == 'x') {
                maze[x][y] = 'o';
                return new MazeTraversal(maze, x + 1, y);
            }
            else if (maze[x][y + 1] == 'x') {
                maze[x][y] = 'o';
                return new MazeTraversal(maze, x, y + 1);
            }
            else if (maze[x - 1][y] == 'x') {
                maze[x][y] = 'o';
                return new MazeTraversal(maze, x - 1, y);
            }
            else if (maze[x][y - 1] == 'x') {
                maze[x][y] = 'o';
                return new MazeTraversal(maze, x, y - 1);
            }
        }catch(ArrayIndexOutOfBoundsException a){ //if the starting point of the maze throws an exception,
            // check for next location in a different order to avoid searching outside maze
            if(firstCall){
                try{
                    if (maze[x - 1][y] == '.') {
                        maze[x][y] = 'x';
                        return new MazeTraversal(maze, x - 1, y);
                    }
                    else if (maze[x][y - 1] == '.') {
                        maze[x][y] = 'x';
                        return new MazeTraversal(maze, x, y - 1);
                    }
                    else if (maze[x + 1][y] == '.') {
                        maze[x][y] = 'x';
                        return new MazeTraversal(maze, x + 1, y);
                    }
                    else if (maze[x][y + 1] == '.') {
                        maze[x][y] = 'x';
                        return new MazeTraversal(maze, x, y + 1);
                    }
                    if (maze[x - 1][y] == 'x') {
                        maze[x][y] = 'o';
                        return new MazeTraversal(maze, x - 1, y);
                    }
                    else if (maze[x][y - 1] == 'x') {
                        maze[x][y] = 'o';
                        return new MazeTraversal(maze, x, y - 1);
                    }
                    else if (maze[x + 1][y] == 'x') {
                        maze[x][y] = 'o';
                        return new MazeTraversal(maze, x + 1, y);
                    }
                    else if (maze[x][y + 1] == 'x') {
                        maze[x][y] = 'o';
                        return new MazeTraversal(maze, x, y + 1);
                    }
                }catch (ArrayIndexOutOfBoundsException b){
                    deleteO();
                    printMaze();
                }
            }
        }
        firstCall = false;
        System.out.println("Maze solved");
        return null;
    }

    /**
     * private deleteO function, once the maze has been traversed, this method scans the 2d array and replaces all of the 'o's with '.'s
     */
    private void deleteO(){
        for(int x = 0; x<maze.length; x++){
            for(int y = 0; y<maze.length; y++){
                if(maze[x][y]=='o'){
                    maze[x][y] = '.';
                }
            }
        }
    }

    /**
     * private printMaze function, helper function that prints the maze
     */
    private void printMaze(){
        for(int x = 0; x<12; x++){
            for(int y = 0; y<12; y++){
                System.out.print(maze[x][y]+ " ");
            }
            System.out.println(" Row: "+x);
        }
        System.out.println();
    }
}

