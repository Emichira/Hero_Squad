import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
  private String mName;
  private static List<Hero> instances = new ArrayList<Hero>();
  private int mAge;
  private String mSuperpower;
  private String mWeakness;
  private int mId;

  //constructor
  public Hero(String name, int age, String superpower, String weakness) {
    mName = name;
    mAge = age;
    mSuperpower = superpower;
    mWeakness = weakness;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public int getAge() {
    return mAge;
  }

  public String getSuperpower() {
    return mSuperpower;
  }

  public String getWeakness() {
    return mWeakness;
  }

  public static List<Hero> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
     return mId;
   }

   public static Hero find(int id) {
     return instances.get(id - 1);
   }
}
