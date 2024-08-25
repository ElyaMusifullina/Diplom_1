package practikum;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

import org.junit.Test;
import praktikum.Ingredient;


public class IngredientTest {

  @Test
  public void testIngredientCreation() {
    Ingredient ingredient = new Ingredient(SAUCE, "Tar-tar", 15.76f);
    assertEquals(SAUCE, ingredient.getType());
    assertEquals("Tar-tar", ingredient.getName());
    assertEquals(15.76f, ingredient.getPrice(), 0.001);
  }
}
