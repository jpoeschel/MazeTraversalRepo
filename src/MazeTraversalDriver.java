/**
 * MazeTraversalDriver, creates instance of MazeTraversal
 * @author Johnathan Poeschel
 * @version 1.0, 25 Nov 2019
 */
public class MazeTraversalDriver {
    /**
     * main function which creates a maze and a starting point to pass into mazeTraversal
     */
    public static void main(String[] args) {
        System.out.println("MAZE TRAVERSAL");
        char[][] maze = {
                {'#','#','#','#','#','#','#','#','#','#','#','#'},
                {'#','.','.','.','#','.','.','.','.','.','.','#'},
                {'.','.','#','.','#','.','#','#','#','#','.','#'},
                {'#','#','#','.','#','.','.','.','.','#','.','#'},
                {'#','.','.','.','.','#','#','#','.','#','.','.'},
                {'#','#','#','#','.','#','.','#','.','#','.','#'},
                {'#','.','.','#','.','#','.','#','.','#','.','#'},
                {'#','#','.','#','.','#','.','#','.','#','.','#'},
                {'#','.','.','.','.','.','.','.','.','#','.','#'},
                {'#','#','#','#','#','#','.','#','#','#','.','#'},
                {'#','.','.','.','.','.','.','#','.','.','.','#'},
                {'#','#','#','#','#','#','#','#','#','#','#','#'}
        };
        int x = 2;
        int y = 0;
        MazeTraversal m = new MazeTraversal(maze, x,y);
    }
}
