package controllers;

import db.DBHelper;
import models.Engineer;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class EngineersController {

    public EngineersController() {
        setupEndpoints();
    }

    public void setupEndpoints(){
//index
        get("/engineers",(req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Engineer> engineers = DBHelper.getAll(Engineer.class);
            model.put("engineers", engineers);
            model.put("template", "templates/engineers/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }


}
