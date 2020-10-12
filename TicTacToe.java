import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args){

        char[][] gameBoard =  {{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}};

        printGameBoard(gameBoard);

        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose a position to place the piece (1-9)");
            int playerPos = scan.nextInt();
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){
                System.out.println("Position full. Pick another!");
                playerPos = scan.nextInt();
            }

            placePiece(gameBoard,playerPos,"player");

            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) +1;
            while(playerPositions.contains(cpuPos)||cpuPositions.contains(cpuPos) ){
                cpuPos = rand.nextInt(9) +1;
            }
            placePiece(gameBoard, cpuPos, "cpu");

            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            System.out.println(result);
        }
    }

    public static void printGameBoard(char[][] gameBoard){
        for(char[] row : gameBoard) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user){
    char symbol =' ';
       if(user.equals("player")) {
           symbol = 'X';
           playerPositions.add(pos);
       } else if(user.equals("cpu")) {
           symbol = '0';
           cpuPositions.add(pos);
       }

        switch(pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
        printGameBoard(gameBoard);
        System.out.println();
    }

    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List diag1 = Arrays.asList(1, 5, 9);
        List diag2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(diag1);
        winning.add(diag2);

        for(List l : winning) {
            if(playerPositions.containsAll(l)) {
                return "Player wins! :)";
            } else if(cpuPositions.containsAll(l)) {
                return "CPU wins! :(";
            } else if(playerPositions.size()+cpuPositions.size() == 9) {
                return "TIE. No winner";
            }
        }
        return "";
    }
}
//
//## TicTacToe
//        The program simulates a TicTacToe game against the cpu, giving the player the first move.
//        There are 9 possible positions (1-9) for the TicTacToe pieces and the cpu chooses a random move.
//        The player plays X and the cpu plays 0.
//        At the start the gameboard is printed and the player chooses his first move.
//        Two array lists are used to store the positions that have already been played and if the next position to be played is already filled, the program will ask for another position.
//        The winning list of lists contains 8 win conditions (the 3 rows, the 3 columns and the 2 diagonals). Each time a piece is placed, the program checks if any of the win conditions are met. If one of the win conditions is met, the program prints the winner and stops.
//        If there is no win condition met and the 9 pieces have all been placed, the program prints there is a tie.
//
//        Methods
//        The program has a main method and 3 other methods. The 3 methods are: -printGameBoard : prints the matrix we use as gameboard;
//        -placePiece : places a piece on the gameboard, x or 0 depending on the turn (we use a char called symbol that is given the value x if the user is "player" and 0 if the user is "cpu");
//        -checkWinner : checks in the list of lists winning if any win condition is met (if all the values of one of the 8 lists of 3 are found in playerPositions or in cpuPositions)
//         MAIN
//        The main method of the program initializes the gameboard matrix, prints it and enters a while loop. The while loop contains two moves ( one for the player and one for the cpu ).
//        A move is made by scanning the position (or randomizing in cpu's case), checking if the position is available (and if it is not, printing the message to pick another position and scanning it), placing the piece and checking if the game is over.
//
