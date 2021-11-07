package hw6;


public class DVDPlayer {

    private DVDPlayer(){}
    private static DVDPlayer instance = null;
    private static State s1;


    public static DVDPlayer getInstance(){
        if(instance == null){
            instance = new DVDPlayer();
        }
        return instance;
    }
     public void changeState(State state){
         DVDPlayer.s1 = state;
     }

     public void OpenCloseButtonPushed(){
         s1.OpenCloseButtonPushed();
     }

    public void playButtonPushed(){
            s1.playButtonPushed();
        }

    public void stopButtonPushed(){
            s1.stopButtonPushed();
        }
    public void open(){
        System.out.println("DVD Player is open");
    }
    public void close(){
        System.out.println("DVD Player is closed");
    }
    public void play(){
        System.out.println("DVD Player is playing");
    }
    public void stop(){
        System.out.println("DVD Player is stopped");
    }

}