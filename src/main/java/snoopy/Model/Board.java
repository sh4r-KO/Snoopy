package snoopy.Model;

import snoopy.Controller.JeuDeBaseController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Board {
    public int[][] board;
    private Snoopy noop;
    private ShowFadeBlock showFadeBlock;
    private PushingBlock pushingBlock;
    private BreakingBlock breakingBlock;
    private TrappedBlock trappedBlock;
    //TODO make an arraylist for each type of block
    /*
    idéalement on devrai avoir une seule méthode move, avec un parcours d'arraylist avec multi-types, et chaque block a une methode Execute/ do SMT qui est trèes spécifique à chaque type de block
    ensuite, apres avoir checker le comportement de chaque block on bouge snoopy
     */
    //1 bouger snoopy
    //2 faire disparaitre un bloc
    //3 faire bouger un bloc poussable
    // tapis roulant


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
                }else if(board[i][j] == 1){        //localisation Bloc breaking block
                    breakingBlock = new BreakingBlock(i,j,this,noop);
                }else if (board[i][j] == 3){        //localisation Bloc trapped block
                    trappedBlock = new TrappedBlock(i,j,noop);
                }
            }
        }
    }

    public void moveUp() {
        trappedBlock.trappedBlock();
        if(noop.getX() > 1 && noop.getDirection() == Direction.NORD) {
            if(pushingBlock.isPushedToTheTop()){
                board[noop.getX()][noop.getY()] -= 8;
                noop.setX(noop.getX()-1);
                board[noop.getX()][noop.getY()] += 8;
            }else{

                if(board[noop.getX()-1][noop.getY()] == 0||board[noop.getX()-1][noop.getY()] == 3){
                    board[noop.getX()][noop.getY()] -= 8;
                    noop.setX(noop.getX()-1);
                    board[noop.getX()][noop.getY()] += 8;
                }
            }
        }else{
            noop.setDirection(Direction.NORD);
        }

        showFadeBlock.fade();
        //x = x - 1;
    }
    public void moveDown() {
        trappedBlock.trappedBlock();
        if (noop.getX() < 10 && noop.getDirection() == Direction.SUD) {
            if(pushingBlock.isPushedToTheBottom()){
                board[noop.getX()][noop.getY()] -= 8;
                noop.setX(noop.getX()+1);
                board[noop.getX()][noop.getY()] += 8;
            }else{
                /*
                int tmp = board[noop.getX()][noop.getY()];
                this.board[noop.getX()][noop.getY()] = board[noop.getX() + 1][noop.getY()];
                board[noop.getX() + 1][noop.getY()] = tmp;
                noop.setX(noop.getX()+1);
                 */
                if(board[noop.getX()+1][noop.getY()] == 0 || board[noop.getX()+1][noop.getY()] == 3){
                    board[noop.getX()][noop.getY()] -= 8;
                    noop.setX(noop.getX()+1);
                    board[noop.getX()][noop.getY()] += 8;
                }
            }

        }else {
            noop.setDirection(Direction.SUD);
        }
        showFadeBlock.fade();
        //x = x+1
    }
    public void moveRight() {
        trappedBlock.trappedBlock();
        if(noop.getY() < 20 && noop.getDirection() == Direction.EST) {
            if(pushingBlock.isPushedToTheRight()) {
                board[noop.getX()][noop.getY()] -= 8;
                noop.setY(noop.getY() + 1);
                board[noop.getX()][noop.getY()] += 8;

            }else{
                //TODO change le tmp method by a  =0 & = 8 ou un -8 + 8 dans ce cas faut rajouter des conditions en mode ya rien derriere == 0 en l'occurence a droite wich is logic reprend la version de Pushing block en cas de doute
                /*int tmp = board[noop.getX()][noop.getY()];
                this.board[noop.getX()][noop.getY()] = board[noop.getX()][noop.getY() + 1];
                board[noop.getX()][noop.getY() + 1] = tmp;
                noop.setY(noop.getY() + 1);
                 */
                if(board[noop.getX()][noop.getY()+1] == 0||board[noop.getX()][noop.getY()+1] == 3){
                    board[noop.getX()][noop.getY()] -= 8;
                    noop.setY(noop.getY() + 1);
                    board[noop.getX()][noop.getY()] += 8;
                }
            }

            System.out.println("movedright");
        }else {
            noop.setDirection(Direction.EST);
        }
        showFadeBlock.fade();
        //y =y +1
    }
    public void moveLeft() {
        trappedBlock.trappedBlock();
        if(noop.getY() > 1 && noop.getDirection() == Direction.OUEST) {
            if(pushingBlock.isPushedToTheLeft()) {

                board[noop.getX()][noop.getY()] -= 8;
                noop.setY(noop.getY() -1);
                board[noop.getX()][noop.getY()] += 8;

            }else{
               /* int tmp=board[noop.getX()][noop.getY()];
                this.board[noop.getX()][noop.getY()] = board[noop.getX()][noop.getY()-1];
                board[noop.getX()][noop.getY()-1] = tmp;
                noop.setY(noop.getY()-1);
                */
                if(board[noop.getX()][noop.getY()-1] == 0 || board[noop.getX()][noop.getY()-1] == 3){
                    board[noop.getX()][noop.getY()] -= 8;
                    noop.setY(noop.getY() -1);
                    board[noop.getX()][noop.getY()] += 8;
                }
            }

        } else {
            noop.setDirection(Direction.OUEST);
        }
        showFadeBlock.fade();
        //y = y-1;
    }
    public void breakBlock(){
        breakingBlock.breakBlock();
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
    ArrayList<Entity> allEntityList  = new ArrayList<Entity>();
    public int[][] setBoardFromTextFile2(String NameFile, int x, int y) {
        int[][] t = new int[x][y];
        String ret = null;
        try {
            ret = Files.readString(new File("src/main/resources/levels/" + NameFile).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        char[] chararray = ret.toCharArray();

        int rowCount = 0;
        int columnCount = 0;

        for (int i = 0; i < chararray.length; i++) {
            //if  char at i is a space increase column count
            Character tmp = chararray[i];
            if (chararray[i] == ' ') {
                columnCount++;
            } else if (tmp.equals('\n')) {
                rowCount++;
                columnCount = 0;
            } else {

                switch (tmp) {
                    case '0':
                        t[rowCount][columnCount] = 0;
                        break;
                    case '1':
                        t[rowCount][columnCount] = 1;
                        break;
                    case '2':
                        t[rowCount][columnCount] = 2;
                        break;
                    case '3':
                        t[rowCount][columnCount] = 3;
                        break;
                    case '4':
                        t[rowCount][columnCount] = 4;
                        break;
                    case '5':
                        t[rowCount][columnCount] = 5;
                        break;
                    case '6':
                        t[rowCount][columnCount] = 6;
                        break;
                    case '7':
                        t[rowCount][columnCount] = 7;
                        break;
                    case '8':
                        t[rowCount][columnCount] = 8;
                        break;
                    case '9':
                        t[rowCount][columnCount] = 9;
                        break;
                }
                //if not, check if it's a number, if it is :
                //depending on the number, add the direction wich will always be the charactere at tehe right (i+1)
                // if this number does not
            }
        }
        return null;
    }

    public Snoopy getSnoopy() {
        return noop;
    }

    private void printBoard(){
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    public int[][] getBoard() {
        return board;
    }
}