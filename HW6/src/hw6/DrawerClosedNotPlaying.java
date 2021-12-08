package hw6;

public class DrawerClosedNotPlaying implements State {

    private static DrawerClosedNotPlaying draweropen = null;

    public static DrawerClosedNotPlaying getInstance() {
        if (draweropen == null) {
            draweropen = new DrawerClosedNotPlaying();
        }
        return draweropen;
    }

    private DVDPlayer dvdplayer;

    private DrawerClosedNotPlaying() {
        dvdplayer = DVDPlayer.getInstance();
    }

    @Override
    public void OpenCloseButtonPushed() {
        dvdplayer.open();
        dvdplayer.changeState(DrawerOpen.getInstance());
        
    }

    @Override
    public void playButtonPushed() {
        
        dvdplayer.play();
        dvdplayer.changeState(DrawerClosedPlaying.getInstance());
        
    }

    @Override
    public void stopButtonPushed() {
        
        System.out.println("Drawer is closed and not playing");
        
    }
    public static void main(String[] args){}


    }