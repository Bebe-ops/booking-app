package com.example.booking

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.view.RedirectView

@Controller
class HtmlController {

    @GetMapping("/")
    fun redirect(): RedirectView {
        return RedirectView("/swagger-ui.html")
    }
}