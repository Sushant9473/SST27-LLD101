public class Demo02 {
    public static void main(String[] args) {
        Player player = new Player(
            new SimpleDecoder(),
            new ConsolePlayerUI(),
            new SimpleFrameCache()
        );
        player.play(new byte[]{1,2,3,4});
    }
}
