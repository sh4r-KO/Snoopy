package snoopy.Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private Snoopy noop;

    private  ArrayList<Entity> allEntityList  = new ArrayList<Entity>();
    private String[][] fullBoard;
    //TODO make an arraylist for each type of block
    /*
    idéalement on devrai avoir une seule méthode move, avec un parcours d'arraylist avec multi-types, et chaque block a une methode Execute/ do SMT qui est trèes spécifique à chaque type de block
    ensuite, apres avoir checker le comportement de chaque block on bouge snoopy
     */

    public Board() {
        //this.board = this.setBoardFromTextFile("test.txt", 12, 22);
        this.fullBoard = this.setBoardFromTextFile2("test.txt", 12, 22);
        System.out.println("board created:\n"+this.toString());


        /*for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 22; j++) {
                if (board[i][j] == 8) {
                    this.noop = new Snoopy(i, j, this, Direction.OUEST);
                }
            }
        }

         */
        //localisation Bloc Show/fade
       /* for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 22; j++) {
                if (board[i][j] == 5) {//locatlisation showFadeBlock
                    showFadeBlock = new ShowFadeBlock(i, j, this, noop);
                }else if (board[i][j] == 2) {        //localisation Bloc pushing block
                    pushingBlock = new PushingBlock(i, j,this,noop, Direction.OUEST);
                }else if(board[i][j] == 1){        //localisation Bloc breaking block
                    breakingBlock = new BreakingBlock(i,j,this,noop);
                }else if (board[i][j] == 3){        //localisation Bloc trapped block
                    trappedBlock = new TrappedBlock(i,j,noop);
                }
            }
        }

        */
    }
    //TODO change le tmp method by a  =0 & = 8 ou un -8 + 8 dans ce cas faut rajouter des conditions en mode ya rien derriere == 0 en l'occurence a droite wich is logic reprend la version de Pushing block en cas de doute
    public void spacePressed(){
        for (Entity entity : allEntityList) {
            if (entity instanceof BreakingBlock BrkBlk) {
                BrkBlk.setSpacePressed(true);
            }
        }
    }

    public void moveUp() {
        this.move(Direction.N,-1,0);
        /*
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

         */
    }
    public void moveDown() {
        this.move(Direction.S,+1,0);

        /*
        trappedBlock.trappedBlock();
        if (noop.getX() < 10 && noop.getDirection() == Direction.SUD) {
            if(pushingBlock.isPushedToTheBottom()){
                board[noop.getX()][noop.getY()] -= 8;
                noop.setX(noop.getX()+1);
                board[noop.getX()][noop.getY()] += 8;
            }else{

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
        */
    }
    public void moveRight() {
        this.move(Direction.E,0,+1);
        /*
        trappedBlock.trappedBlock();
        if(noop.getY() < 20 && noop.getDirection() == Direction.EST) {
            if(pushingBlock.isPushedToTheRight()) {
                board[noop.getX()][noop.getY()] -= 8;
                noop.setY(noop.getY() + 1);
                board[noop.getX()][noop.getY()] += 8;

            }else{

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
        */
    }
    public void moveLeft() {
        this.move(Direction.O,0,-1);
        /*
        trappedBlock.trappedBlock();
        if(noop.getY() > 1 && noop.getDirection() == Direction.OUEST) {
            if(pushingBlock.isPushedToTheLeft()) {

                board[noop.getX()][noop.getY()] -= 8;
                noop.setY(noop.getY() -1);
                board[noop.getX()][noop.getY()] += 8;

            }else{
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
        */
    }
    public void move(Direction pressedDirection,int Xmodifier,int Ymodifier) {
        for (Entity entity : allEntityList) {
            /*
             if (!(entity instanceof PushingBlock pushB) && !(entity instanceof TrappedBlock tb && tb.triggered())){
            }else if(entity instanceof TrappedBlock tb && tb.triggered()){
            }else{
                entity.Action();
            }
             */
            if (!(entity instanceof PushingBlock pushB) && !(entity instanceof TrappedBlock tb && tb.triggered())){
                entity.Action();
            }
        }
        System.out.println("move"+noop.getX()+","+noop.getY());
        if(     noop.getDirection() == pressedDirection){

            if((noop.getY()<20 && pressedDirection==Direction.E )|| (noop.getY() > 1 && noop.getDirection() == Direction.O)|| (noop.getX() < 10 && noop.getDirection() == Direction.S)|| (noop.getX() > 1 && noop.getDirection() == Direction.N )){  //snoopy goes on a empty case
                //normal or trap bloc
                if(fullBoard[noop.getX()+Xmodifier][noop.getY()+Ymodifier].equals("0") || fullBoard[noop.getX()+Xmodifier][noop.getY()+Ymodifier].equals("3")){

                    fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("8"+pressedDirection , "");
                    noop.setX(noop.getX() + Xmodifier);
                    noop.setY(noop.getY() + Ymodifier);
                    fullBoard[noop.getX()][noop.getY()] += ("8"+pressedDirection);
                //Bird touched
                }else if(fullBoard[noop.getX()+Xmodifier][noop.getY()+Ymodifier].contains("9")){

                    fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("8"+pressedDirection , "");
                    noop.setX(noop.getX() + Xmodifier);
                    noop.setY(noop.getY() + Ymodifier);
                    fullBoard[noop.getX()][noop.getY()] += ("8"+pressedDirection);

                }
                //pushing bloc in front/near snoopy
                //wnoopy pushes a block
                else if(((fullBoard[noop.getX()+Xmodifier][noop.getY()+Ymodifier].contains("2N")&&pressedDirection==Direction.N)|| (fullBoard[noop.getX()+Xmodifier][noop.getY()+Ymodifier].contains("2S")&&pressedDirection==Direction.S)|| (fullBoard[noop.getX()+Xmodifier][noop.getY()+Ymodifier].contains("2E")&&pressedDirection==Direction.E)|| (fullBoard[noop.getX()+Xmodifier][noop.getY()+Ymodifier].contains("2O")&&pressedDirection==Direction.O)) && 1<noop.getX()+Xmodifier && noop.getX()+Xmodifier < 10 && 1< noop.getY()+Ymodifier && noop.getY()+Ymodifier < 20){//empty space behind the pushing block
                    for (Entity entity : allEntityList) {
                        if (entity instanceof PushingBlock pushB){
                            pushB.Action();
                            allEntityList.remove(pushB);
                        }
                    }

                    fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("8"+pressedDirection , "");
                    noop.setX(noop.getX() + Xmodifier);
                    noop.setY(noop.getY() + Ymodifier);
                    fullBoard[noop.getX()][noop.getY()] += ("8"+pressedDirection);
                }
                //snoopy walks on a trap
                else if(fullBoard[noop.getX()+Xmodifier][noop.getY()+Ymodifier].contains("3") && 1<noop.getX()+Xmodifier && noop.getX()+Xmodifier < 10 && 1< noop.getY()+Ymodifier && noop.getY()+Ymodifier < 20){

                    fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("8"+pressedDirection , "");
                    noop.setX(noop.getX() + Xmodifier);
                    noop.setY(noop.getY() + Ymodifier);
                    fullBoard[noop.getX()][noop.getY()] += ("8"+pressedDirection);

                }
            }

        }else if (  noop.getDirection() != pressedDirection){
            fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("8" + noop.getDirection(), "8"+pressedDirection);
            noop.setDirection(pressedDirection);
        }
        for (Entity entity : allEntityList) {
            if (entity instanceof PushingBlock pushB){
                //pcushingBlock.setSpacePressed(true);
                //dont do anything
            }else{
                entity.Action();
            }
        }
    }
            /*
            public void move(Direction pressedDirection,int Xmodifier,int Ymodifier) {
        for (Entity entity : allEntityList) {
            entity.Action();
        }
        System.out.println("move"+noop.getX()+","+noop.getY());
        if(     noop.getDirection() == pressedDirection){


            if(noop.getY()<20 && pressedDirection==Direction.E && fullBoard[noop.getX()+Xmodifier][noop.getY()+Ymodifier].equals("0")){
                fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("8E" , "");
                noop.setX(noop.getX() + Xmodifier);
                noop.setY(noop.getY() + Ymodifier);
                fullBoard[noop.getX()][noop.getY()] += ("8E");
            }else if (noop.getY() > 1 && noop.getDirection() == Direction.O&& fullBoard[noop.getX()+Xmodifier][noop.getY()+Ymodifier].equals("0")){
                fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("8O" , "");
                noop.setX(noop.getX() + Xmodifier);
                noop.setY(noop.getY() + Ymodifier);
                fullBoard[noop.getX()][noop.getY()] += ("8O");
            }else if (noop.getX() < 10 && noop.getDirection() == Direction.S&& fullBoard[noop.getX()+Xmodifier][noop.getY()+Ymodifier].equals("0")){
                fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("8S" , "");
                noop.setX(noop.getX() + Xmodifier);
                noop.setY(noop.getY() + Ymodifier);
                fullBoard[noop.getX()][noop.getY()] += ("8S");
            }else if(noop.getX() > 1 && noop.getDirection() == Direction.N && fullBoard[noop.getX()+Xmodifier][noop.getY()+Ymodifier].equals("0")){
                fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("8N" , "");
                noop.setX(noop.getX() + Xmodifier);
                noop.setY(noop.getY() + Ymodifier);
                fullBoard[noop.getX()][noop.getY()] += ("8N");
            }
            for (Entity entity : allEntityList) {
                entity.Action();
            }
        }else if (  noop.getDirection() != pressedDirection){
            fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("8" + noop.getDirection(), "8"+pressedDirection);
            noop.setDirection(pressedDirection);
        }
        for (Entity entity : allEntityList) {
            //entity.Action();
        }
    }
            ///////////////////////////////
            if(noop.getX() > 0 && noop.getX()<12 && noop.getY()>0&& noop.getY()<22 &&  noop.getDirection() == pressedDirection) {// 8N
            if(fullBoard[noop.getX()][noop.getY()].equals("0")){
                fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("8"+pressedDirection.toString(), "");
                noop.setX(noop.getX()+Xmodifier);
                noop.setY(noop.getY()+Ymodifier);
                fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("0", "8"+pressedDirection.toString());
            }else if(fullBoard[noop.getX()][noop.getY()].contains("6")){
                fullBoard[noop.getX()][noop.getY()] = fullBoard[noop.getX()][noop.getY()].replace("8"+pressedDirection.toString(), "");
                noop.setX(noop.getX()+Xmodifier);
                noop.setY(noop.getY()+Ymodifier);
                fullBoard[noop.getX()][noop.getY()]  +="8"+pressedDirection.toString();
            }else if(fullBoard[noop.getX()][noop.getY()].contains("3")) {
                //TODO walk on trap
            }else if(fullBoard[noop.getX()][noop.getY()].contains("7")) {
                //TODO touch ball
            }else if(fullBoard[noop.getX()][noop.getY()].contains("9")) {
                //TODO touch bird
            }else {
                throw new IllegalArgumentException("Snoopy cant walk on anything else than grass, trap or treadmill")
            }
            //////////////////////////::

             */

    public int[][] setBoardFromTextFile(String NameFile, int x, int y) {
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
            ret = Files.readString(new File("src/main/resources/levels/" + NameFile).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        char[] chararray = ret.toCharArray();

        int rowCount = 0;
        int columnCount = 0;

        for (int i = 0; i < chararray.length; i++) {
            Character tmp = chararray[i];
            if (tmp.equals('\n')) {
                rowCount++;
                columnCount = 0;
            } else if (tmp.equals('0') || tmp.equals('1') || tmp.equals('2') || tmp.equals('3') || tmp.equals('4') || tmp.equals('5') || tmp.equals('6') || tmp.equals('7') || tmp.equals('8') || tmp.equals('9')) {
                t[rowCount][columnCount] = Integer.parseInt(String.valueOf(tmp));
                columnCount++;
            }
        }

        return t;
    }

    public String[][] setBoardFromTextFile2(String NameFile, int x, int y) {
        //intialize somes variables
        String[][] ret = new String[x][y];
        //fille the matrix with "0" reason im doing this is because after we dont have to replace 08S with 0 when tmp find 0 because of the switch, its easier this way
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                ret[i][j] = "0";
            }
        }

        String file = null;
        try {
            file = Files.readString(new File("src/main/resources/levels/" + NameFile).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        char[] chararray = file.toCharArray();
        System.out.println("chararray.length = " + chararray.toString());

        //variables for the loop
        int rowCount = 0;
        int columnCount = 0;

        rowCount =columnCount= 0;
        for (int i = 0; i < chararray.length && columnCount < 22 ; i++) {
            //if  char at i is a space increase column count
            Character tmp = chararray[i];
            if (tmp == ' ') {
                columnCount++;
            } else if (tmp.equals('\n')) {
                rowCount++;
                columnCount = 0;
            } else {
                //empty
                if (tmp == '8') {
                    if (chararray[i + 1] != 'N' && chararray[i + 1] != 'S' && chararray[i + 1] != 'W' && chararray[i + 1] != 'E') {// get the next char to find the direction
                        throw new IllegalArgumentException("Snoopy.Model.setBoardFromText.283 : chararray[i+1] inst NSWE");
                    } else if (chararray[i + 1] == 'N') {
                        ret[rowCount][columnCount] = "08N";
                        noop = new Snoopy(rowCount, columnCount, this, Direction.N);
                        allEntityList.add(noop);
                    } else if (chararray[i + 1] == 'S') {
                        ret[rowCount][columnCount] = "08S";
                        noop = new Snoopy(rowCount, columnCount, this, Direction.S);
                        allEntityList.add(noop);
                    } else if (chararray[i + 1] == 'W') {
                        ret[rowCount][columnCount] = "08W";
                        noop = new Snoopy(rowCount, columnCount, this, Direction.O);
                        allEntityList.add(noop);
                    } else if (chararray[i + 1] == 'E') {
                        ret[rowCount][columnCount] = "08E";
                        noop = new Snoopy(rowCount, columnCount, this, Direction.E);
                        allEntityList.add(noop);
                    }
                }
            }
        }

        System.out.println("found snoopy"+noop.toString());

        //reset variables for the loop
        rowCount = columnCount= 0;
        for (int i = 0; i < chararray.length && columnCount < 22 ; i++) {
            //if  char at i is a space increase column count
            Character tmp = chararray[i];
            if (tmp.equals(' ')) {
                columnCount++;
            } else if (tmp.equals('\n')) {
                rowCount++;
                columnCount = 0;
            } else {
                switch (tmp) {
                    case '0' -> {/*no need to add a new entity, the absence of one is enough as intel
                        //allEntityList.add(new Entity(rowCount, columnCount, 0));
                        */}
                    case '1' -> {//breakable
                        ret[rowCount][columnCount] = "1";
                        allEntityList.add(new BreakingBlock(rowCount, columnCount, this, noop));

                    }
                    case '2' -> {//pushable
                        if (chararray[i + 1] != 'N' && chararray[i + 1] != 'S' && chararray[i + 1] != 'O' && chararray[i + 1] != 'E') {// get the next char to find the direction
                            throw new IllegalArgumentException("Snoopy.Model.setBoardFromText.283 : chararray[i+1] inst NSWE");
                        } else if (chararray[i + 1] == 'N') {
                            ret[rowCount][columnCount] = "2" + chararray[i + 1] ;
                            allEntityList.add(new PushingBlock(rowCount, columnCount, this, noop, Direction.N));
                        } else if (chararray[i + 1] == 'S') {
                            ret[rowCount][columnCount] = "2" + chararray[i + 1] ;
                            allEntityList.add(new PushingBlock(rowCount, columnCount, this, noop, Direction.S));
                        } else if (chararray[i + 1] == 'O') {
                            ret[rowCount][columnCount] = "2" + chararray[i + 1];
                            allEntityList.add(new PushingBlock(rowCount, columnCount, this, noop, Direction.O));
                        } else if (chararray[i + 1] == 'E') {
                            ret[rowCount][columnCount] = "2" + chararray[i + 1] ;
                            allEntityList.add(new PushingBlock(rowCount, columnCount, this, noop, Direction.E));
                        }

                    }
                    case '3' -> {//trap block no direction
                        ret[rowCount][columnCount] = "3";
                        allEntityList.add(new TrappedBlock(rowCount, columnCount,this, noop));

                    }
                    case '4' -> {//block invincible
                        ret[rowCount][columnCount] = "4";
                        allEntityList.add(new InvincibleBlock(rowCount, columnCount, this, noop));
                    }
                    case '5' -> {                    //block appear/disappear
                        ret[rowCount][columnCount] = "5";
                        allEntityList.add(new ShowFadeBlock(rowCount, columnCount, this, noop));
                    }
                    case '6' -> {//treadmillblock
                        if (chararray[i + 1] != 'N' && chararray[i + 1] != 'S' && chararray[i + 1] != 'W' && chararray[i + 1] != 'E') {// get the next char to find the direction
                            throw new IllegalArgumentException("Snoopy.Model.setBoardFromText.316 : chararray[i+1] inst NSWE");
                        } else if (chararray[i + 1] == 'N') {
                            ret[rowCount][columnCount] = "6" + chararray[i + 1];
                            allEntityList.add(new TreadMillBlock(rowCount, columnCount, this, noop, Direction.N));
                        } else if (chararray[i + 1] == 'S') {
                            ret[rowCount][columnCount] = "6" + chararray[i + 1];
                            allEntityList.add(new TreadMillBlock(rowCount, columnCount, this, noop, Direction.S));
                        } else if (chararray[i + 1] == 'W') {
                            ret[rowCount][columnCount] = "6" + chararray[i + 1];
                            allEntityList.add(new TreadMillBlock(rowCount, columnCount, this, noop, Direction.O));
                        } else if (chararray[i + 1] == 'E') {
                            ret[rowCount][columnCount] = "6" + chararray[i + 1];
                            allEntityList.add(new TreadMillBlock(rowCount, columnCount, this, noop, Direction.E));
                        }
                    }
                    case '7' -> {/*if (chararray[i + 1] != 'A' && chararray[i + 1] != 'B' && chararray[i + 1] != 'C' && chararray[i + 1] != 'D') {// get the next char to find the direction
                            throw new IllegalArgumentException("Snoopy.Model.setBoardFromText.334 : chararray[i+1] inst NSWE");
                        } else if (chararray[i + 1] == 'A') {
                            ret[rowCount][columnCount] = '7' + "SO";
                            allEntityList.add(new TreadMillBlock(rowCount, columnCount, this, noop, Direction.SO));
                        } else if (chararray[i + 1] == 'B') {
                            ret[rowCount][columnCount] = '7' + "SE";
                            allEntityList.add(new TreadMillBlock(rowCount, columnCount, this, noop, Direction.SE));
                        } else if (chararray[i + 1] == 'C') {
                            ret[rowCount][columnCount] = '7' + "NO";
                            allEntityList.add(new TreadMillBlock(rowCount, columnCount, this, noop, Direction.NO));
                        } else if (chararray[i + 1] == 'D') {
                            ret[rowCount][columnCount] = '7' + "NE";
                            allEntityList.add(new TreadMillBlock(rowCount, columnCount, this, noop, Direction.NE));
                        }

                         */}
                    case '8' -> {}
                    //case '8' : pas besoin de case8, on l'a fait avec
                    case '9' -> {//player
                        //TODO add bird direction dumbass
                        if (chararray[i + 1] != 'O' && chararray[i + 1] != 'E') {// get the next char to find the direction
                            throw new IllegalArgumentException("Snoopy.Model.setBoardFromText.316 : chararray[i+1] inst NSWE");
                        } else if (chararray[i + 1] == 'E') {
                            ret[rowCount][columnCount] = "9" + chararray[i + 1] + "";
                            allEntityList.add(new YellowBird(rowCount, columnCount, this, noop));
                        } else if (chararray[i + 1] == 'O') {
                            ret[rowCount][columnCount] = "9" + chararray[i + 1] + "";
                            allEntityList.add(new YellowBird(rowCount, columnCount, this, noop ));
                        }
                    }
                    case 'N'-> {}
                    case 'S'-> {}
                    case 'O'-> {}
                    case 'E'-> {}
                    case '\n'-> {}
                    case ' '-> {}

                    //default -> throw new IllegalArgumentException("Snoopy.Model.setBoardFromText.352 : chararray[i] = ."+chararray[i]+". other print "+chararray[i] );

                    //if not, check if it's a number, if it is :
                    //depending on the number, add the direction wich will always be the charactere at tehe right (i+1)
                    // if this number does not
                }
            }
        }
        return ret;
    }
    public Snoopy getSnoopy() {
        return noop;
    }

    public String[][] getBoard() {
        return fullBoard;
    }

    public void update() {
        for (Entity e : allEntityList) {
            e.Action();
        }
    }
    @Override
    public String toString(){
        String ret = "";
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 22; j++) {
                ret += "\t\t"+fullBoard[i][j];
            }
            ret += "\n";
        }
        return ret;
    }
}