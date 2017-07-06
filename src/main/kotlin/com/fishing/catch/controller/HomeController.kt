package com.fishing.catch.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author stanislav.lapitsky created 7/4/2017.
 */
@Controller
class HomeController {

    @RequestMapping(value = "/")
    fun index():String {
        return "index.html";
    }
}