import org.junit.*;
import static org.junit.Assert.*;

public class JUnitTest {

  Date fixture;

  @Before
  public void setup() {
    fixture = new Date(2020, 1, 1);
  }

  @Test
  public void testAddDays() {
    // given
    Date expected = new Date(2020, 1, 2);

    // when
    fixture.addDays(1);

    // then
    assertEquals(expected, fixture);
  }

  @Test
  public void testAddMoreThanOneMonthOfDays() {
    // given
    Date expected - new Date(2020, 2, 2);

    // when
    fixture.addDays(32);

    // then
    assertEquals(expected, fixture);
  }

  @Test(timeout = 10000)
  public void testOneMillion() {
    Date expected = ...

    // when
    fixture.addDays(1000000)

    // then
    assertEquals(expected, fixture);
  }

  @Test
  public void testConstructor() {
    // given
    fixture = new Date(2031, 2, 29);

    // expected
    assertEquals(1, fixture.getDay())
    assertFalse(fixture.isLeapYear())
  }
}
