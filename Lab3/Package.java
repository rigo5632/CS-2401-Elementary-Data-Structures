class Package{
  private double width;
  private double height;
  private double length;

  Package(){
  }

  Package(double w, double h, double l){
    this.width = w;
    this.height = h;
    this.length = l;
  }

  void setWidth(double w){
    this.width = w;
  }

  void setHeight(double h){
    this.height = h;
  }

  void setLength(double l){
    this.height = l;
  }

  double getWidth(){
    return width;
  }

  double getHeight(){
    return height;
  }

  double getlength(){
    return length;
  }

  double getVolumn(){
    return width*length*height;
  }

  boolean isCubic(){
    if(width == length && length == height)return true;
    return false;
  }
}
