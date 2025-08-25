public class SimpleFrameCache implements FrameCache {
    private Frame last;
    @Override
    public void cache(Frame frame) {
        last = frame;
    }
    @Override
    public boolean hasLastFrame() {
        return last != null;
    }
}