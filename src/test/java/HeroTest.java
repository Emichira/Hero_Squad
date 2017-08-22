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

      //Retrives all instances of hero
      @Test
      public void all_returnsAllInstancesOfHero_true() {
        Hero firstHero = new Hero("Wanyore");
        Hero secondHero = new Hero("Wazito");
        assertEquals(true, Hero.all().contains(firstHero));
        assertEquals(true, Hero.all().contains(secondHero));
      }

      //empties the instances ArrayList
      @Test
      public void clear_emptiesAllHerosFromArrayList_0() {
        Hero firstHero = new Hero("Wanyore");
        Hero.clear();
        assertEquals(Hero.all().size(), 0);
      }

      //ensure we can assign our hero's unique id attributes
      @Test
      public void getId_herosInstantiateWithAnID_6() {
        Hero testHero = new Hero("Home");
        assertEquals(6, testHero.getId());
      }

      //locate specific Hero based on unique id
      @Test
      public void find_returnHeroWithSameId_secondHero() {
        Hero firstHero = new Hero("Wanyore");
        Hero secondHero = new Hero("Wazito");
        assertEquals(Hero.find(secondHero.getId()),secondHero);
      }

}
