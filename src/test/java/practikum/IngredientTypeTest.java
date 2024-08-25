package practikum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
  private final String input;
  private final IngredientType expected;


  public IngredientTypeTest(String input, IngredientType expected) {
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Object[][] getTestData() {
    return new Object[][] {
      { "SAUCE", IngredientType.SAUCE },
      { "FILLING", IngredientType.FILLING }
    };
  }

  @Test
  public void testIngredientTypeValues() {
    assertEquals(expected, IngredientType.valueOf(input));
  }
}

