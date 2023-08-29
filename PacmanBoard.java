public class PacmanBoard {
    String[][] board;
    int rows;
    int cols;
   // private long ghostChar = '\u1F47B';

    public PacmanBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new String[rows][cols];
    }
    public void initialize() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == (rows - 1) || j == (cols - 1)) {
                    board[i][j] = "\uD83C\uDF38";
                } else {
                    board[i][j] = ".";
                }
            }
        }

        PseudoRandomNumber myRandom= new PseudoRandomNumber(System.currentTimeMillis());
        
        PacmanGameController.enR1=myRandom.generateRandomNumber(2,rows-2);
        PacmanGameController.enR2=myRandom.generateRandomNumber(2,rows-2);
        PacmanGameController.enR3=myRandom.generateRandomNumber(2,rows-2);
        PacmanGameController.enR4=myRandom.generateRandomNumber(2,rows-2);
        PacmanGameController.enC1=myRandom.generateRandomNumber(2,cols-2);
        PacmanGameController.enC2=myRandom.generateRandomNumber(2,cols-2);
        PacmanGameController.enC3=myRandom.generateRandomNumber(2,cols-2);
        PacmanGameController.enC4=myRandom.generateRandomNumber(2,cols-2);

        board[PacmanGameController.enR1][PacmanGameController.enC1] = "\uD83D\uDC7B"; // Ghost emoji
        board[PacmanGameController.enR2][PacmanGameController.enC2] = "\uD83D\uDC7B"; // Ghost emoji
        board[PacmanGameController.enR3][PacmanGameController.enC3] = "\uD83D\uDE08"; // Ghost 2 emoji
        board[PacmanGameController.enR4][PacmanGameController.enC4] = "\uD83D\uDE08"; // Ghost 2 emoji
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void placePacman(int row, int col) {
        board[row][col] = "\uD83C\uDF54";
    }

    public void clearPosition(int row, int col) {
        board[row][col] = " ";
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && board[row][col].equals(".");
    }
}