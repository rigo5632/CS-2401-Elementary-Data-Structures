class Box{
  private double length;
  private double width;
  private double height;
  Box next;

  Box(){}
  Box(double l, double w, double h){
    length = l;
    width = w;
    height = h;
  }

  public double getLength(){
    return length;
  }

  public double getWidth(){
    return width;
  }

  public double getHeight(){
    return height;
  }

  public double getVolume(){
    return length * width * height;
  }

  public boolean isCubic(){
    if(length == width && width == height) return true;
    return false;
  }
  public Box setHead(double l, double w, double h){
    Box head = new Box(length, width, height);
    return head;

  }

}
