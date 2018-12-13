package sabillon.springframework5.recipe.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The type Index controller.
 *
 * @author Miguel Sabillon on 12/13/2018
 */
@Controller
public class IndexController {

    /**
     * Gets index page.
     *
     * @return the index page
     */
    @GetMapping({"", "/home", "/", "/index"})
    public String getIndexPage() {
        return "index";
    }

}
