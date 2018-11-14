//Alexander Cox
//Tuesday, November 14, 2018

public class TokenPass {

    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount)
    {
        board = new int[playerCount];
        for (int i = 0; i < board.length; i++)
            board[i] = (int)(Math.random() * 10) + 1;

        currentPlayer = (int)(Math.random() * board.length);
    }

    public void distributeCurrentPlayerTokens()
    {
        int nextPlayer = currentPlayer;
        int numToDistribute = board[currentPlayer];
        board[currentPlayer] = 0;

        while (numToDistribute > 0)
        {
            nextPlayer = (nextPlayer + 1) % board.length;
            board[nextPlayer]++;
            numToDistribute--;
        }
    }

    public void printBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            System.out.print("Player " + i + ": " + board[i] + " | ");
        }
        System.out.print("\n");
    }

    public void nextPlayer()
    {
        currentPlayer++;
    }

    public int gameOver()
    {
        int winnerIdx = -1;
        boolean gameOver = false;

        if (!gameOver)
        {
            for (int i: board)
            {
                if (i == 0)
                    gameOver = true;
            }
        }

        if(gameOver)
        {
            int winnerVal = -1;
            for (int i = 0; i < board.length; i++)
            {
                if (board[i] > winnerVal)
                    winnerIdx = i;
            }
        }

        return winnerIdx;
    }
}
