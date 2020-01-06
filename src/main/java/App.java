import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");

        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Squad> allSquads = Squad.getAllSquads();
            ArrayList<Hero> allHeros = Hero.getAllHeroes();
            model.put("allSquads",allSquads);
            model.put("allHeroes",allHeros);
            return new ModelAndView(model,"index.hbs");
            }, new HandlebarsTemplateEngine());

        post("/postNewSquad",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int maxSize = Integer.parseInt(request.queryParams("maxsize"));
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            model.put("maxsize",maxSize);
            model.put("name",name);
            model.put("cause",cause);
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/showSquadHeroes/:id",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            Squad oneSquad = Squad.findSquad(Integer.parseInt(request.params(":id")));
            List<Hero> squadHeroes = oneSquad.getAllHeroes();
            model.put("oneSquad",oneSquad);
            model.put("authorBooks",squadHeroes);
            return new ModelAndView(model,"heroes.hbs");
        },new HandlebarsTemplateEngine());

        post("/postNewHero",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            String Id = request.queryParams("squadteam");
            Squad newSquadTeam = Squad.findSquad(Integer.parseInt(Id));
            Hero newHero = new Hero(name,power,weakness,age);
            newSquadTeam.addHeroToSquad(newHero);
            return new ModelAndView(model,"success.hbs");

        },new HandlebarsTemplateEngine());



    }

}
