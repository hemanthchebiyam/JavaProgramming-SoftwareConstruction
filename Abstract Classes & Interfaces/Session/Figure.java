public interface Figure {
    
    public Position getPos();
    public void move(Position pos);
    public String getFillColor();
    public String getLineColor();
    public double getArea();
    public double getPerimeter();
    public void scale(double factor);
}
