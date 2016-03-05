package controllers;

import play.*;
import play.mvc.*;
import play.data.DynamicForm;
import java.util.*;
import views.html.*;
import cpabe.Cpabe;
import java.io.PrintWriter;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result register() {
        final Map<String, String[]> values = request().body().asFormUrlEncoded();
        final String name = values.get("name")[0];
        String attr_list = values.get("attr_list")[0];
        String pubfile = "./public/keys/pub_key";
        String mskfile = "./public/keys/master_key";
        String prvfile = "./public/keys/prv_key";

        Cpabe test = new Cpabe();

        try {
            test.keygen(pubfile, prvfile, mskfile, attr_list);
        }catch (Exception e) {

        }
        return ok(keys.render());
    }
}
