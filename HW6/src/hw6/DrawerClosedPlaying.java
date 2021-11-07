package hw6;


public class DrawerClosedPlaying implements State {

    private static DrawerClosedPlaying draweropen = null;

    public static DrawerClosedPlaying getInstance() {
        if (draweropen == null) {
            draweropen = new DrawerClosedPlaying();
        }
        return draweropen;
    }

    private DVDPlayer dvdplayer;

    private DrawerClosedPlaying() {
        dvdplayer = DVDPlayer.getInstance();
    }

    @Override
    public void OpenCloseButtonPushed(){

        dvdplayer.stop();
        dvdplayer.open();
        dvdplayer.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed(){

        System.out.println("Playing");
    }

    @Override
    public void stopButtonPushed(){

        dvdplayer.stop();
        dvdplayer.changeState(DrawerClosedNotPlaying.getInstance());
    }
}