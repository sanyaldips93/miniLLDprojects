public class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;

    public Game(Player player1, Player player2) {
        board = new Board();
        players = new Player[]{player1, player2};
        currentPlayerIndex = 0;
    }

    public void start() {
        while (!board.isFull()) {
            board.display();
            Player currentPlayer = players[currentPlayerIndex];
            int[] move = currentPlayer.makeMove(board);
            board.placeSymbol(move[0], move[1], currentPlayer.getSymbol());

            if (checkWinner(currentPlayer.getSymbol())) {
                board.display();
                System.out.println(currentPlayer.getName() + " wins!");
                return;
            }

            currentPlayerIndex = 1 - currentPlayerIndex;  // Switch player
        }
        board.display();
        System.out.println("It's a draw!");
    }

    private boolean checkWinner(char symbol) {
        char[][] grid = board.getGrid();

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) return true;
            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) return true;
        }

        // Check diagonals
        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) return true;
        return grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol;
    }
}
