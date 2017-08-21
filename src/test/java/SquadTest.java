import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {
  private Squad mSquad;
  @Before
    public void instantiate() {
      mSquad = new Squad("Wazito");
    }
  // @After
  //  public void tearDown() {
  //    Squad.clear();
  //  }

  //asserts if instances can be created succefully
    @Test
    public void Squad_instantiatesCorrectly_true() {
      Squad mSquad = new Squad("Wazito");
    assertEquals(true, mSquad instanceof Squad);
    }

  //ensure we can assign squad a name and retrive it
    @Test
    public void Name_categoryInstantiatesWithName_String() {
    assertEquals("Wazito", mSquad.getName());
    }

    //Retrives all instances of a class
      @Test
     public void all_returnsAllInstancesOfSquad_true() {
       Squad squadOne = new Squad("Wazito");
       Squad squadTwo = new Squad("Simba");
       assertEquals(true, Squad.all().contains(squadOne));
       assertEquals(true, Squad.all().contains(squadTwo));
     }

}
