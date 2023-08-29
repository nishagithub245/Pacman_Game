class PacmanGameController {
    static final int ROWS = 20;
    static final int COLS = 85;

    PacmanBoard board;
    static int pacmanRow;
    static int pacmanCol;

    static int enR1, enR2, enR3, enR4, enC1, enC2, enC3, enC4;

    private boolean gameOver;

    public PacmanGameController() {
        PseudoRandomNumber pseudoRandomNumber = new PseudoRandomNumber(System.currentTimeMillis());
        board = new PacmanBoard(ROWS, COLS);
        pacmanRow = pseudoRandomNumber.generateRandomNumber(1, ROWS-1);
        pacmanCol = pseudoRandomNumber.generateRandomNumber(1, COLS-1);
        gameOver = false;
    }

    public void initializeBoard() {
        board.initialize();
        board.placePacman(pacmanRow, pacmanCol);
    }

    public void displayBoard() {
        board.display();
    }

    public void movePacman(String direction) {
        int newRow = pacmanRow;
        int newCol = pacmanCol;
        
        switch (direction) {
            case "up":
                newRow--;
                break;
            case "down":
                newRow++;
                break;
            case "left":
                newCol--;
                break;
            case "right":
                newCol++;
                break;
            default:
                System.out.println("Invalid direction!");
                return;
        }

        if (board.isValidMove(newRow, newCol)) {
            ghosttMovement();
            board.clearPosition(pacmanRow, pacmanCol);
            pacmanRow = newRow;
            pacmanCol = newCol;
            board.placePacman(pacmanRow, pacmanCol);
        } else {
            gameOver = true; // Pacman hit the wall or obstacle, game over
        }
        System.out.println(pacmanRow + " " + pacmanCol);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    void ghosttMovement() {
        // ENEMY 1 
        board.board[enR1][enC1]=".";
        if (pacmanRow > enR1) {
            enR1++;
        } else if(pacmanRow < enR1) {
            enR1--;
        }else if (pacmanCol > enC1) {
            enC1++;
        } else if(pacmanCol < enC1) {
            enC1--;
        }
        board.board[enR1][enC1] = "\uD83D\uDC7B";



        board.board[enR2][enC2]=".";
        if (pacmanRow > enR2) {
            enR2++;
        } else if(pacmanRow < enR2) {
            enR2--;
        }else if (pacmanCol > enC2) {
            enC2++;
        } else if(pacmanCol < enC2) {
            enC2--;
        }
        board.board[enR2][enC2] = "\uD83D\uDC7B";



        board.board[enR3][enC3]=".";
        if (pacmanRow > enR3) {
            enR3++;
        } else if(pacmanRow < enR3) {
            enR3--;
        }else if (pacmanCol > enC3) {
            enC3++;
        } else if(pacmanCol < enC3) {
            enC3--;
        }
        board.board[enR3][enC3] = "\uD83D\uDE08";



        board.board[enR4][enC4]=".";
        if (pacmanRow > enR4) {
            enR4++;
        } else if(pacmanRow < enR4) {
            enR4--;
        }else if (pacmanCol > enC4) {
            enC4++;
        } else if(pacmanCol < enC4) {
            enC4--;
        }
        board.board[enR4][enC4] = "\uD83D\uDE08";

    }
        


    }

