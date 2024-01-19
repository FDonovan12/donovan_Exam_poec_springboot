package fr.donovan.exam.centrale_ish.controller.admin;

import fr.donovan.exam.centrale_ish.entity.Listing;
import fr.donovan.exam.centrale_ish.DTO.ListingDTO;
import fr.donovan.exam.centrale_ish.service.ListingService;
import fr.donovan.exam.centrale_ish.mapping.UrlRoute;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class AdminListingController {

    private final ListingService listingService;

    @GetMapping(path = UrlRoute.URL_ADMIN_LISTING)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("admin/listing/index");
        mav.addObject("listings", listingService.findAll());
        return mav;
    }

    @GetMapping(value = UrlRoute.URL_ADMIN_LISTING + "/{field}")
    public ModelAndView show(ModelAndView mav, @PathVariable String field) {
        Listing listing = listingService.getByField(field);

        mav.setViewName("admin/listing/show");
        mav.addObject("listing", listing);
        return mav;
    }

    @GetMapping(path = UrlRoute.URL_ADMIN_LISTING_NEW)
    public ModelAndView create(ModelAndView mav, HttpServletRequest httpServletRequest) {
        return getFormByDTO(
                mav,
                new ListingDTO(),
                httpServletRequest.getRequestURI(),
                false
        );
    }

    @GetMapping(path = UrlRoute.URL_ADMIN_LISTING_EDIT + "/{id}")
    public ModelAndView edit(@PathVariable Long id, ModelAndView mav, HttpServletRequest httpServletRequest) {
        return getFormByDTO(
                mav,
                listingService.getDTOById(id),
                httpServletRequest.getRequestURI(),
                true
        );
    }

    @PostMapping(path = UrlRoute.URL_ADMIN_LISTING_NEW)
    public ModelAndView formHandler(
            @Valid @ModelAttribute("listing") ListingDTO listingDTO,
            BindingResult result,
            ModelAndView mav
    ) {
        return formHandle(result, mav, listingDTO, null);
    }

    @PutMapping(path = UrlRoute.URL_ADMIN_LISTING_EDIT + "/{id}")
    public ModelAndView formHandler(
            @Valid @ModelAttribute("listing") ListingDTO listingDTO,
            BindingResult result,
            ModelAndView mav,
            @PathVariable Long id
    ) {
        return formHandle(result, mav, listingDTO, id);
    }

    private ModelAndView getFormByDTO(ModelAndView mav, ListingDTO dto, String uri, boolean isEdit) {
        mav.setViewName("admin/listing/form");
        mav.addObject("listing", dto);
        mav.addObject("action", uri);
        mav.addObject("isEdit", isEdit);
        return mav;
    }

    private ModelAndView formHandle(BindingResult result, ModelAndView mav, ListingDTO dto, Long id) {
        if (result.hasErrors()) {
            mav.setViewName("admin/listing/form");
            return mav;
        }
        listingService.persist(dto, id);
        mav.setViewName("redirect:" + UrlRoute.URL_ADMIN_LISTING);
        return mav;
    }

}
