package tech.bison.trainee17.bichess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee17.bichess.Square;

public class SquareTest {
  @Test
  public void square_getCoordinates_coordinates() throws Exception {
    Square square = new Square("A2");

    int[] coordinates = square.getCoordinates();

    assertThat(coordinates, is(new int[] { 1, 2 }));
  }

  @Test
  public void square_getXCoordinate_x() throws Exception {
    assertThat(new Square("C5").getXCoordinate(), is(3));
  }

  @Test
  public void square_getYCoordinate_y() throws Exception {
    assertThat(new Square("B7").getYCoordinate(), is(7));
  }

}
