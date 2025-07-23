import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int[] makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print(name + " (" + symbol + "), enter row (0-2): ");
            row = scanner.nextInt();
            System.out.print("Enter column (0-2): ");
            col = scanner.nextInt();
        } while (!board.isValidMove(row, col));
        return new int[]{row, col};
    }
}
