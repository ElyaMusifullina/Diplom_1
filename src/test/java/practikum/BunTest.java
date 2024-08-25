package practikum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import praktikum.Bun;

public class BunTest {
  @Test
  public void testBunCreation() {
    Bun bun = new Bun ("Sladkaya bulochka", 15.40f);
    assertEquals("Sladkaya bulochka", bun.getName());
    assertEquals(15.40f, bun.getPrice(),0.001);
  }
}
