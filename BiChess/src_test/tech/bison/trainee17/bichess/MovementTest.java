package tech.bison.trainee17.bichess;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import tech.bison.trainee17.bichess.Movement;
import tech.bison.trainee17.bichess.Square;

import static org.hamcrest.CoreMatchers.is;

public class MovementTest {
  @Test
  public void movement_getXAndYMovement_xMovement() throws Exception {
    Movement movement = new Movement(new Square("A2"), new Square("B4"));

    int xMovement = movement.getXMovement();
    int yMovement = movement.getYMovement();

    assertThat(xMovement, is(1));
    assertThat(yMovement, is(2));
  }

  @Test
  public void movement_getVerticalUpwardsWay_squaresOnWay() throws Exception {
    Movement movement = new Movement(new Square("A2"), new Square("A5"));

    ArrayList<Square> way = movement.getWay();

    assertThat(way.toArray(), is(new Square[] { new Square("A3"), new Square("A4") }));
  }

  @Test
  public void movement_getVerticalDownwardsWay_squaresOnWay() throws Exception {
    Movement movement = new Movement(new Square("B6"), new Square("B3"));

    ArrayList<Square> way = movement.getWay();

    assertThat(way.toArray(), is(new Square[] { new Square("B5"), new Square("B4") }));
  }

  @Test
  public void movement_getHorizontalRightWaY_squaresOnWay() throws Exception {
    Movement movement = new Movement(new Square("A1"), new Square("D1"));

    ArrayList<Square> way = movement.getWay();

    assertThat(way.toArray(), is(new Square[] { new Square("B1"), new Square("C1") }));
  }

  @Test
  public void movement_getHorizontalLeftWay_squaresOnWay() throws Exception {
    Movement movement = new Movement(new Square("D6"), new Square("A6"));

    ArrayList<Square> way = movement.getWay();

    assertThat(way.toArray(), is(new Square[] { new Square("C6"), new Square("B6") }));
  }

  @Test
  public void movement_getDiagonalUpLeftWay_squaresOnWay() throws Exception {
    Movement movement = new Movement(new Square("D8"), new Square("A5"));

    ArrayList<Square> way = movement.getWay();

    assertThat(way.toArray(), is(new Square[] { new Square("C7"), new Square("B6") }));
  }

  @Test
  public void movement_getDiagonalUpRightWay_squaresOnWay() throws Exception {
    Movement movement = new Movement(new Square("A5"), new Square("D8"));

    ArrayList<Square> way = movement.getWay();

    assertThat(way.toArray(), is(new Square[] { new Square("B6"), new Square("C7") }));
  }

  @Test
  public void movement_getDiagonalDownLeftWay_squaresOnWay() throws Exception {
    Movement movement = new Movement(new Square("D6"), new Square("A3"));

    ArrayList<Square> way = movement.getWay();

    assertThat(way.toArray(), is(new Square[] { new Square("C5"), new Square("B4") }));
  }

  @Test
  public void movement_getDiagonalDownRightWay_squaresOnWay() throws Exception {
    Movement movement = new Movement(new Square("A3"), new Square("C1"));

    ArrayList<Square> way = movement.getWay();

    assertThat(way.toArray(), is(new Square[] { new Square("B2") }));
  }
}
