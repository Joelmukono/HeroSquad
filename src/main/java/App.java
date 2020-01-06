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

    }

}
