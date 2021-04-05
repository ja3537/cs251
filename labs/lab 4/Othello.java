import cs251.lab2.*;

class Othello implements OthelloModel{
    public int getSize(){
        return 8;
    }

    public void startNewGame(){
    }
    public String getBoardString(){
        return "None";
    }
    public Piece getCurrentTurn(){

        Piece p = Piece.DARK;
        return p;
    }
    public void setComputerPlayer(String opponent){
    }
    public Result handleClickAt(int row, int col){

        Result r = Result.GAME_NOT_OVER;
        return r;

    }
    public static void main(String[] args){
        Othello game = new Othello();
        if(args.length > 0){
            game.setComputerPlayer(args[0]);
            }
        OthelloGUI.showGUI(game);
    }
}
