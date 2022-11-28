package snoopy.Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import snoopy.Controller.JeuDeBaseController;
import java.lang.reflect.Field;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class Player {
    protected int lives;
    protected int score;
    protected int level;
    protected int x;
    protected int y;

    private int[][] board;

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
    constructor of player, wich incarne snoopy in the game
     */
    public Player() {
        this.board = this.setBoardFromTextFile("level1.txt",12,22);
        printBoard();
    }

    private void init(){
    }
    /*
    files should be like this
        01234567890123456789012
        01234567890123456789012
        01234567890123456789012
        01234567890123456789012
        01234567890123456789012
        01234567890123456789012
        01234567890123456789012
        01234567890123456789012
        01234567890123456789012
        01234567890123456789012
        01234567890123456789012
     */

    private int[][] setBoardFromTextFile(String NameFile, int x, int y){
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
                //System.out.println("i "+i+" columnCount="+columnCount+" rowCount="+rowCount+" chararray[i]=/"+tmp+" chararray.legnth"+chararray.length);
                columnCount++;
            }



        }

        //System.out.println("ret = \n"+ret);

        return t;
    }

    //give value to board manually filling each cell with 0 without using loop
    private int [][] setBoardManually(){

         return board = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            };

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
