package fr.donovan.exam.centrale_ish.controller;

import fr.donovan.exam.centrale_ish.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class HomeController {

    private ListingService listingService;

    @GetMapping(path = "/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("listings", listingService.findLastListings());
        return mav;
    }

}
