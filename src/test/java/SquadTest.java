import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {
  private Squad mSquad;
  @Before
    public void instantiate() {
      mSquad = new Squad("Wazito");
    }

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

     //clearing the instances ArrayList
      @Test
       public void clear_emptiesAllSquadsFromList_0() {
         Squad.clear();
         assertEquals(Squad.all().size(), 0);
       }

       //assigns our squads unique id attributes
       @Test
       public void getId_categoriesInstantiateWithAnId_1() {
         assertEquals(1, mSquad.getId());
       }

}
