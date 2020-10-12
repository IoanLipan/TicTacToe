# TicTacToe
The program simulates a TicTacToe game against the cpu, giving the player the first move.
There are 9 possible positions (1-9) for the TicTacToe pieces and the cpu chooses a random move.
The player plays X and the cpu plays 0.
At the start the gameboard is printed and the player chooses his first move.
Two array lists are used to store the positions that have already been played and if the next position to be played is already filled, the program will ask for another position.
The winning list of lists contains 8 win conditions (the 3 rows, the 3 columns and the 2 diagonals). Each time a piece is placed, the program checks if any of the win conditions are met. If one of the win conditions is met, the program prints the winner and stops.
If there is no win condition met and the 9 pieces have all been placed, the program prints there is a tie.

##Methods
The program has a main method and 3 other methods. The 3 methods are: -printGameBoard : prints the matrix we use as gameboard;
                                                                      -placePiece : places a piece on the gameboard, x or 0 depending on the turn (we use a char called symbol that                                                                                     is given the value x if the user is "player" and 0 if the user is "cpu");
                                                                      -checkWinner : checks in the list of lists winning if any win condition is met (if all the values of one of                                                                                        the 8 lists of 3 are found in playerPositions or in cpuPositions)
## MAIN
The main method of the program initializes the gameboard matrix, prints it and enters a while loop. The while loop contains two moves ( one for the player and one for the cpu ).
A move is made by scanning the position (or randomizing in cpu's case), checking if the position is available (and if it is not, printing the message to pick another position and scanning it), placing the piece and checking if the game is over.

