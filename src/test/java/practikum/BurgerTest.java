package practikum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
  @Mock
  Bun bun;

  @Mock
  Ingredient sauce;

  @Mock
  Ingredient filling;

  private Burger burger;

  @Before
  public void setUp() {
    burger = new Burger();
    Mockito.when(bun.getName()).thenReturn("Sladkaya bulochka");
    Mockito.when(bun.getPrice()).thenReturn(1.5f);

    Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
    Mockito.when(sauce.getName()).thenReturn("Ketchup");
    Mockito.when(sauce.getPrice()).thenReturn(0.5f);

    Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
    Mockito.when(filling.getName()).thenReturn("Cheese");
    Mockito.when(filling.getPrice()).thenReturn(1.5f);
  }

  @Test
  public void testAddIngredient() {
    burger.addIngredient(sauce);
    assertEquals(1, burger.ingredients.size());
  }

  @Test
  public void testRemoveIngredient() {
    burger.addIngredient(sauce);
    burger.addIngredient(filling);
    burger.removeIngredient(0);
    assertEquals(1, burger.ingredients.size());
  }

  @Test
  public void testGetPrice() {
    burger.setBuns(bun);
    burger.addIngredient(sauce);
    burger.addIngredient(filling);
    float expectedPrice = bun.getPrice()*2 + sauce.getPrice() + filling.getPrice();
    Mockito.verify(bun, Mockito.times(1)).getPrice();
    Mockito.verify(sauce, Mockito.times(1)).getPrice();
    Mockito.verify(filling, Mockito.times(1)).getPrice();
    assertEquals(expectedPrice, burger.getPrice(), 0.001);
  }

  @Test
  public void testGetReceipt() {
    burger.setBuns(bun);
    burger.addIngredient(sauce);
    burger.addIngredient(filling);

    float expectedPrice = bun.getPrice()*2 + sauce.getPrice() + filling.getPrice();
    String receipt = burger.getReceipt();

    assertTrue(receipt.contains("Sladkaya bulochka"));
    assertTrue(receipt.contains("Ketchup"));
    assertTrue(receipt.contains("Cheese"));
    assertTrue(receipt.contains("Price: " + String.format("%.2f", expectedPrice)));
  }


}
