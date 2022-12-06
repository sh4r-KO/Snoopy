package snoopy.Model;

import snoopy.Controller.JeuDeBaseController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Board {
    public int[][] board;
    private Snoopy noop;
    private ShowFadeBlock showFadeBlock;
    private PushingBlock pushingBlock;

    //1 bouger snoopy
    //2 faire disparaitre un bloc
    //3 faire bouger un bloc poussable
    // tapis roulant


    JeuDeBaseController JeuDeBaseControler;
    /*player has coordinates, lives, score, level, direction enum, current leve
    player has a board, a board is a 2d array of int, each int is a type of block!
    0 (case vide)
    1 (bloc cassable)
    2 (bloc poussable)
    3 (bloc piégé)
    4 (bloc invincible)
    5 (bloc disparition/apparition)
    6 (bloc de tapis roulant)
    7 (balle)
    8 (Snoopy)
    9 (oiseau)
    */

    /**
    constructor of board, which incarne snoopy in the game
     */

    public Board() {
        this.board = this.setBoardFromTextFile("test.txt", 12, 22);
        //System.out.println(noop.getX());
        //System.out.println(noop.getY());

        printBoard();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 22; j++) {
                if (board[i][j] == 8) {
                    this.noop = new Snoopy(i, j, this, Direction.OUEST);
                }
            }
        }


        //localisation Bloc Show/fade
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 22; j++) {
                if (board[i][j] == 5) {//locatlisation showFadeBlock
                    showFadeBlock = new ShowFadeBlock(i, j, this, noop);
                }else if (board[i][j] == 2) {        //localisation Bloc pushing block
                    pushingBlock = new PushingBlock(i, j,this,noop);
                }
            }
        }



    }



    public void moveUp() {
        if(noop.getX() > 1 && noop.getDirection() == Direction.NORD) {
            if(pushingBlock.isPushedToTheTop()){

            }else{
                int tmp=board[noop.getX()][noop.getY()];
                this.board[noop.getX()][noop.getY()] = board[noop.getX()-1][noop.getY()];
                board[noop.getX()-1][noop.getY()] = tmp;
                noop.setX(noop.getX()-1);
            }

        }else{
            noop.setDirection(Direction.NORD);
        }

        showFadeBlock.fade();
        //x = x - 1;
        MVT();
    }

    public void moveDown() {
        if (noop.getX() < 10 && noop.getDirection() == Direction.SUD) {
            if(pushingBlock.isPushedToTheBottom()){

            }else{
                int tmp = board[noop.getX()][noop.getY()];
                this.board[noop.getX()][noop.getY()] = board[noop.getX() + 1][noop.getY()];
                board[noop.getX() + 1][noop.getY()] = tmp;
                noop.setX(noop.getX()+1);
            }

        }else {
            noop.setDirection(Direction.SUD);
        }
        showFadeBlock.fade();
        //x = x+1
        MVT();
    }
    public void moveRight() {
        if(noop.getY() < 20 && noop.getDirection() == Direction.EST) {
            if(pushingBlock.isPushedToTheRight()) {

            }else{
                int tmp = board[noop.getX()][noop.getY()];
                this.board[noop.getX()][noop.getY()] = board[noop.getX()][noop.getY() + 1];
                board[noop.getX()][noop.getY() + 1] = tmp;
                noop.setY(noop.getY() + 1);
            }

            System.out.println("movedright");
        }else {
            noop.setDirection(Direction.EST);
        }
        showFadeBlock.fade();
        MVT();
        //y =y +1
    }
    public void moveLeft() {
        if(noop.getY() > 1 && noop.getDirection() == Direction.OUEST) {
            if(pushingBlock.isPushedToTheLeft()) {

            }else{
                int tmp=board[noop.getX()][noop.getY()];
                this.board[noop.getX()][noop.getY()] = board[noop.getX()][noop.getY()-1];
                board[noop.getX()][noop.getY()-1] = tmp;
                noop.setY(noop.getY()-1);
            }
        } else {
            noop.setDirection(Direction.OUEST);
        }
        showFadeBlock.fade();
        MVT();
        //y = y-1;
    }

    public void fade() {
        /*
        if(board[noop.getX()][noop.getY()] == board[showFadeBlock.getX() - 1][showFadeBlock.getY()]){
            board[showFadeBlock.getX()][showFadeBlock.getY()] = 0;
        } if (board[noop.getX()][noop.getY()] == board[showFadeBlock.getX() + 1][showFadeBlock.getY()]){
            board[showFadeBlock.getX()][showFadeBlock.getY()] = 0;
        } if(board[noop.getX()][noop.getY()] == board[showFadeBlock.getX()][showFadeBlock.getY() - 1]){
            board[showFadeBlock.getX()][showFadeBlock.getY()] = 0;
        } if(board[noop.getX()][noop.getY()] == board[showFadeBlock.getX()][showFadeBlock.getY() + 1]){
            board[showFadeBlock.getX()][showFadeBlock.getY()] = 0;
        }

        System.out.println("Fade Block");
        MVT();
        */


    }

    public void push() {
        if(board[noop.getX()][noop.getY()] == board[pushingBlock.getX() - 1][pushingBlock.getY()]) {
            board[pushingBlock.getX()][pushingBlock.getY()] = 0;
        }

        System.out.println("Fade Block");
        //MVT();

    }

 

    public void MVT(){
        printBoard();
    }

    public int[][] setBoardFromTextFile(String NameFile, int x, int y){
        /*
        TODO add more than number to be readable by this method
        char[] charArray = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (char a : charArray) {
            int b = a;
            System.out.println("char "+a+" :"+b);
        }
        */
        String ret = null;
        int[][] t = new int[x][y];
        try {
            ret = Files.readString(new File("src/main/resources/levels/"+NameFile).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        char[] chararray = ret.toCharArray();

        int rowCount = 0;
        int columnCount = 0;
        for(int i=0;i<chararray.length;i++){
            Character tmp = chararray[i];
            if(tmp.equals('\n')){
                rowCount++;
                columnCount=0;
            }else if(tmp.equals('0') || tmp.equals('1') || tmp.equals('2') || tmp.equals('3') || tmp.equals('4') || tmp.equals('5') || tmp.equals('6') || tmp.equals('7') || tmp.equals('8') || tmp.equals('9')){
                t[rowCount][columnCount] =Integer.parseInt(String.valueOf(tmp));
                columnCount++;
            }
        }


        return t;
    }

    public Snoopy getNoop() {
        return noop;
    }

    public void setNoop(Snoopy noop) {
        this.noop = noop;
    }


    private void printBoard(){
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    //getters of board
    public int[][] getBoard() {
        return board;
    }
}