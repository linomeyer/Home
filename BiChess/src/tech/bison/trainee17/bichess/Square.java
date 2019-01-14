package tech.bison.trainee17.bichess;

public class Square {
  private int x;
  private int y;

  public Square(String square) {
    calculateXCoordinate(square.charAt(0));
    calculateYCoordinate(String.valueOf(square.charAt(1)));
  }

  public Square(int x, int y) {
    this.x = x;
    this.y = y;
  }

  private void calculateYCoordinate(String y) {
    this.y = Integer.parseInt(y);
  }

  private void calculateXCoordinate(char x) {
    this.x = ((int) (x - 64));
  }

  public int[] getCoordinates() {
    return new int[] { x, y };
  }

  public int getXCoordinate() {
    return x;
  }

  public int getYCoordinate() {
    return y;
  }

  @Override
  public String toString() {
    return String.valueOf((char) (x + 64)) + y;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Square other = (Square) obj;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

}
