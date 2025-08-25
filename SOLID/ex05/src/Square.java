
public class Square implements Shape {
    private int side;
    @Override
    public void setWidth(int w) { this.side = w; }
    @Override
    public void setHeight(int h) { this.side = h; }
    @Override
    public int area() { return side * side; }
}