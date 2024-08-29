package practikum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import praktikum.Bun;

public class BunTest {
  @Test
  public void testBunGetName() {
    Bun bun = new Bun ("Sladkaya bulochka", 25.15f);
    assertEquals("Sladkaya bulochka", bun.getName());
  }

  @Test
  public void testBunGetPrice() {
    Bun bun = new Bun ("Kislaya bulochka", 15.40f);
    assertEquals(15.40f, bun.getPrice(),0.001);
  }
}
