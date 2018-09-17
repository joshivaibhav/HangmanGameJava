import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class ArtWork {

    //global constants for generating the artwork.
    static int ROW = 10;
    static int COL = 10;
    static String[][] artGrid = new String[ROW][COL];


    public static void main(String[] args) throws FileNotFoundException {


        File testFile = new File(args[0]);
        Scanner sc = new Scanner(testFile);
        int totalWords = 0;
        boolean flag = true;
        ArrayList words = new ArrayList();  // to store the words
        Random randInt = new Random();   //random number generator class

        while (sc.hasNextLine()) {

            words.add(sc.next());      //storing words in the list
        }

        for (int w = 0; w < words.size(); w++) {

            words.get(w).toString().toLowerCase(); //converting all words to lowercase
        }
        sc.close();

        boolean playingGame = true; //controls the game
        do{

        char[] randomWord = words.get(randInt.nextInt(words.size())).toString().toCharArray(); //takes a random word and converts to character array

        boolean correctGuess = false;   //to know whether the word is guessed correctly
        int incorrectGuess = 0;        // number of tries (which cannot exceed 9)





            char[] playerGuesses = new char[randomWord.length];   //to store player guesses.
            for (int i = 0; i < playerGuesses.length; i++) {
                playerGuesses[i] = '.';
            }

            while (!correctGuess && incorrectGuess < 9) {

                System.out.println("Current player guess");
                printGuesses(playerGuesses);
                System.out.println("You have " + (9 - incorrectGuess) + "  guesses remaining");
                System.out.println("Enter your guess word");
                Scanner scanner = new Scanner(System.in);
                char guess = scanner.nextLine().charAt(0);

                for (int n = 0; n < randomWord.length; n++) {

                    if (randomWord[n] == guess) {
                        System.out.println("Match Found  : " +guess);
                        playerGuesses[n] = guess;
                        flag = false;
                    }

                }
                if (!flag) {

                    flag = true;
                    if (wordisGuessed(playerGuesses)) {

                        correctGuess = true;
                        System.out.println("Well Done you guessed correctly");
                        System.out.println("The word is :");
                        printGuesses(playerGuesses);
                    }
                } else {


                    System.out.println("Oops! Wrong Guess.. ");
                    incorrectGuess++;
                    generateArtWork(incorrectGuess);


                }

            }

            System.out.println("Play another game? (y/n)? ");
            Scanner nextGame = new Scanner(System.in);
            if (nextGame.next().charAt(0) == 'n') {
                playingGame = false;
            }
            else{
                playingGame = true;
            }


        } while(playingGame);

    }

    public static void printGuesses(char[] playerGuesses) {

        for (int i = 0; i < playerGuesses.length; i++) {

            System.out.print(playerGuesses[i]);
        }
        System.out.println();

    }

    public static boolean wordisGuessed(char[] playerGuesses) {

        for (int index = 0; index < playerGuesses.length; index++) {

            if (playerGuesses[index] == '.')
                return false;

        }
        return true;
    }


    public static void generateArtWork(int incorrectGuess) {


        switch (incorrectGuess){
            case 1:

                for (int row = 0; row < ROW; row++) {
                    for (int col = 0; col < COL ; col++) {

                        artGrid[row][col] = "*";
                    }
                }
                artGrid[4][4] = "X";
                for (int row = 9; row < ROW; row++) {
                    for (int col = 0; col < COL/2 ; col++) {

                        artGrid[row][col] = "$";
                    }
                }
                printArtWork(artGrid,ROW,COL);
                break;

            case 2:
                for (int row = 9; row < 10; row++) {
                    for (int col = 0; col < COL; col++) {

                        artGrid[row][col] = "$";
                    }
                }
                printArtWork(artGrid,ROW,COL);
                break;
            case 3:
                for (int col = 9; col < COL; col++) {
                    for (int row = ROW/2; row < ROW ; row++) {

                        artGrid[row][col] = "$";
                    }

                }
                printArtWork(artGrid,ROW,COL);
                break;
            case 4:
                for (int col = 9; col < COL; col++) {
                    for (int row = 0; row < ROW/2 ; row++) {

                        artGrid[row][col] = "$";
                    }

                }
                printArtWork(artGrid,ROW,COL);
                break;
            case 5:
                for (int row = 0; row < 1; row++) {
                    for (int col = COL/2; col < COL; col++) {

                        artGrid[row][col] = "$";
                    }
                }
                printArtWork(artGrid,ROW,COL);
                break;
            case 6:
                for (int row = 0; row < 1; row++) {
                    for (int col = 0; col < COL/2; col++) {

                        artGrid[row][col] = "$";
                    }
                }
                printArtWork(artGrid,ROW,COL);
                break;
            case 7:
                for (int col = 0; col < 1; col++) {
                    for (int row = 0; row < ROW/2 ; row++) {

                        artGrid[row][col] = "$";
                    }

                }
                printArtWork(artGrid,ROW,COL);
                break;
                case 8:
                    for (int row = 4; row < ROW/2; row++) {
                        for (int col = 0; col < 2; col++) {

                            artGrid[row][col] = "$";
                        }
                    }
                    printArtWork(artGrid,ROW,COL);
                    break;
                case 9:
                    for (int row = 4; row < ROW/2; row++) {
                        for (int col = 2; col < 4; col++) {

                            artGrid[row][col] = "$";
                        }
                    }
                    printArtWork(artGrid,ROW,COL);
                    System.out.println("GAME OVER");
                    System.out.println("YOU'RE OUT OF GUESSES!");
                    break;


            default: System.out.println("Illegal");

        }

    }
    public static void printArtWork(String [][] artGrid,int ROW, int COL){

        for (int row = 0; row < ROW ; row++) {
            for (int col = 0; col < COL ; col++) {

                System.out.print(artGrid[row][col]+" ");
            }
            System.out.println();
        }

    }




}
