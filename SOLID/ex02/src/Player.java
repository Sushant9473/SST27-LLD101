public class Player {
    private final Decoder decoder;
    private final PlayerUI ui;
    private final FrameCache cache;

    public Player(Decoder decoder, PlayerUI ui, FrameCache cache) {
        this.decoder = decoder;
        this.ui = ui;
        this.cache = cache;
    }

    public void play(byte[] fileBytes) {
        Frame f = decoder.decode(fileBytes);
        cache.cache(f);
        ui.showPlaying(fileBytes);
        System.out.println("Cached last frame? " + cache.hasLastFrame());
    }
}