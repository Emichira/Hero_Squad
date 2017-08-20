import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

  //asserts if instances can be created succefully
    @Test
    public void Squad_instantiatesCorrectly_true() {
      Squad mSquad = new Squad("Wazito");
    assertEquals(true, mSquad instanceof Squad);
    }

}
