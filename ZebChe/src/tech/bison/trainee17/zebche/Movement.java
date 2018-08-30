package tech.bison.trainee17.zebche;

import java.util.ArrayList;

public class Movement {
  private Square start;
  private Square end;
  private int xMovement;
  private int yMovement;

  public Movement(Square start, Square end) {
    this.start = start;
    this.end = end;
    this.xMovement = end.getXCoordinate() - start.getXCoordinate();
    this.yMovement = end.getYCoordinate() - start.getYCoordinate();
  }

  public Square getStart() {
    return start;
  }

  public Square getEnd() {
    return end;
  }

  public int getXMovement() {
    return xMovement;
  }

  public int getYMovement() {
    return yMovement;
  }

  public ArrayList<Square> getWay() {
    ArrayList<Square> squaresOnWay = new ArrayList<Square>();
    int xABS = Math.abs(xMovement);
    int yABS = Math.abs(yMovement);

    if (xMovement != 0 && yMovement != 0 && xABS != yABS) {
      return squaresOnWay;
    }
    // horizontal
    if (xMovement != 0 && yMovement == 0) {
      return getHorizontalWay(squaresOnWay);
      // vertical
    } else if (yMovement != 0 && xMovement == 0) {
      return getVerticalWay(squaresOnWay);
      // diagonal
    } else if (xABS == yABS && yMovement != 0 && xMovement != 0) {
      System.out.println(".");
      return getDiagonalWay(squaresOnWay);
    }
    return squaresOnWay;
  }

  private ArrayList<Square> getHorizontalWay(ArrayList<Square> squaresOnWay) {
    for (int i = 1; i < Math.abs(xMovement); i++) {
      // right
      if (xMovement > 0 && yMovement == 0) {
        squaresOnWay.add(new Square(start.getXCoordinate() + i, start.getYCoordinate()));
        // left
      } else if (xMovement < 0 && yMovement == 0) {
        squaresOnWay.add(new Square(start.getXCoordinate() - i, start.getYCoordinate()));
      }
    }
    return squaresOnWay;
  }

  private ArrayList<Square> getVerticalWay(ArrayList<Square> squaresOnWay) {
    for (int i = 1; i < Math.abs(yMovement); i++) {
      // up
      if (yMovement > 0 && xMovement == 0) {
        squaresOnWay.add(new Square(start.getXCoordinate(), start.getYCoordinate() + i));
        // down
      } else if (yMovement < 0 && xMovement == 0) {
        squaresOnWay.add(new Square(start.getXCoordinate(), start.getYCoordinate() - i));
      }
    }
    return squaresOnWay;
  }

  private ArrayList<Square> getDiagonalWay(ArrayList<Square> squaresOnWay) {
    for (int i = 1; i < Math.abs(xMovement); i++) {
      // right up
      if (xMovement > 0 && yMovement > 0) {
        squaresOnWay.add(new Square(start.getXCoordinate() + i, start.getYCoordinate() + i));
        // left up
      } else if (xMovement < 0 && yMovement < 0) {
        squaresOnWay.add(new Square(start.getXCoordinate() - i, start.getYCoordinate() - i));
        // down right
      } else if (xMovement > 0 && yMovement < 0) {
        squaresOnWay.add(new Square(start.getXCoordinate() + i, start.getYCoordinate() - i));
        // down left
      } else if (xMovement < 0 && yMovement > 0) {
        squaresOnWay.add(new Square(start.getXCoordinate() - i, start.getYCoordinate() + i));
      }
    }
    return squaresOnWay;
  }
}