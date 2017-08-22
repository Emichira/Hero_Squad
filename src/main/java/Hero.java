import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
  private String mName;
  private static List<Hero> instances = new ArrayList<Hero>();
  private int mId;

  public Hero(String name) {
    mName = name;
    instances.add(this);
  }

  public String getName() {
    return mName;
  }

  public static List<Hero> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

}
