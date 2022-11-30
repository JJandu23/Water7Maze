package View;

public class Menus {
    private static String myGameState = "Maze";






    public static void setGameState(String state){
        if(state.equals("Intro") || state.equals("Maze") || state.equals("Battle") || state.equals("Dialogue") || state.equals("Ending")){
            myGameState = state;
        } else{
            System.out.println("Error!!!");
        }

    }

    public static String getGameState(){
        return myGameState;
    }

}
