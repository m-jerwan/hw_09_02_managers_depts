package controllers;

import db.DBHelper;
import db.Seeds;
import models.Manager;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class MainCotroller {

    public static void main(String[] args) {
//        Seeds.seedData();
        ManagersController managersController = new ManagersController();
        EmployeesController employeesController = new EmployeesController();
        EngineersController engineersController = new EngineersController();



        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
