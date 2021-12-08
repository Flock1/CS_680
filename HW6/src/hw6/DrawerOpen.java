package hw6;

public class DrawerOpen implements State {

    private static DrawerOpen draweropen = null;

    public static DrawerOpen getInstance() {
        if (draweropen == null) {
            draweropen = new DrawerOpen();
        }
        return draweropen;
    }

    private DVDPlayer dvdplayer;

    private DrawerOpen() {
        dvdplayer = DVDPlayer.getInstance();
    }

    @Override
    public void OpenCloseButtonPushed(){

        dvdplayer.close();
        dvdplayer.changeState(DrawerClosedNotPlaying.getInstance());
    }

    @Override
    public void playButtonPushed(){

        dvdplayer.close();
        dvdplayer.play();
        dvdplayer.changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed(){

        System.out.println("Drawer is already open");

    }
    public static void main(String[] args){}
}
