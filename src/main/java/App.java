import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/squad-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/squads", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Squad newSquad = new Squad(name);
      model.put("template", "templates/squad-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("squads", Squad.all());
      model.put("template", "templates/squads.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
      model.put("squad", squad);
      model.put("template", "templates/squad.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("squads/:id/heroes/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
      model.put("squad", squad);
      model.put("template", "templates/squad-heroes-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("heroes/new", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/hero-form.vtl");
     return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heroes", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("heroes", Hero.all());
      model.put("template", "templates/heroes.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/heroes", (request,response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    String name = request.queryParams("name");
    int age = Integer.parseInt(request.queryParams("age"));
    String superpower = request.queryParams("superpower");
    String weakness = request.queryParams("weakness");
    Hero userHero = new Hero(name, age, superpower, weakness);
    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heroes/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
      model.put("heroes", hero);
      model.put("template", "templates/hero.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/heroes", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));
      String name = request.queryParams("name");
      int age = Integer.parseInt(request.queryParams("age"));
      String superpower = request.queryParams("superpower");
      String weakness = request.queryParams("weakness");
      Hero newhero = new Hero(name, age, superpower, weakness);
      squad.addHero(newhero);
      model.put("squad", squad);
      model.put("template", "templates/squad-heroes-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  //   post("/heroes", (request, response) -> {
  //   Map<String, Object> model = new HashMap<String, Object>();
   //
  //   ArrayList<Hero> heroes = request.session().attribute("heroes");
  //   if (heroes == null) {
  //     heroes = new ArrayList<Hero>();
  //     request.session().attribute("heroes", heroes);
  //   }
   //
  //   String description = request.queryParams("squadId");
  //   Hero newHero = new Hero(description);
  //   heroes.add(newHero);
   //
  //   model.put("template", "templates/success.vtl");
  //   return new ModelAndView(model, layout);
  //  }, new VelocityTemplateEngine());

    }
}
