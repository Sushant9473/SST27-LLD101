public class ConsolePlayerUI implements PlayerUI {
    @Override
    public void showPlaying(byte[] fileBytes) {
        System.out.println("\u25B6 Playing " + fileBytes.length + " bytes");
    }
}