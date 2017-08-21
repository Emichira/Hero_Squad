import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Squad {
  private String mName;
  private static List<Squad> instances = new ArrayList<Squad>();


  public Squad(String name) {
    mName = name;
    instances.add(this);

  }

  //implements getName()
  public String getName() {
    return mName;
  }

  //implements all()
  public static List<Squad> all() {
     return instances;
   }

}
