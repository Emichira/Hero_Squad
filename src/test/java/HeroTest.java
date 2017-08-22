import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

  //test if we can successfully create instances of this class
    @Test
    public void Hero_instantiatesCorrectly_true() {
      Hero testHero = new Hero("Wanyore");
      assertEquals(true, testHero instanceof Hero);
    }

    //ensure we can assign hero a name and retrive it
      @Test
      public void Hero_instantiatesWithName_String() {
        Hero testHero = new Hero("Wanyore");
        assertEquals("Wanyore", testHero.getName());
      }
}
