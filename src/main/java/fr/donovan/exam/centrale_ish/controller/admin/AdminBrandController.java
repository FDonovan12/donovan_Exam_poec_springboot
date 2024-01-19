package fr.donovan.exam.centrale_ish.controller.admin;

import fr.donovan.exam.centrale_ish.entity.Brand;
import fr.donovan.exam.centrale_ish.DTO.BrandDTO;
import fr.donovan.exam.centrale_ish.service.BrandService;
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
public class AdminBrandController {

    private final BrandService brandService;

    @GetMapping(path = UrlRoute.URL_ADMIN_BRAND)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("admin/brand/index");
        mav.addObject("brands", brandService.findAll());
        return mav;
    }

    @GetMapping(value = UrlRoute.URL_ADMIN_BRAND + "/{field}")
    public ModelAndView show(ModelAndView mav, @PathVariable String field) {
        Brand brand = brandService.getByField(field);

        mav.setViewName("admin/brand/show");
        mav.addObject("brand", brand);
        return mav;
    }

    @GetMapping(path = UrlRoute.URL_ADMIN_BRAND_NEW)
    public ModelAndView create(ModelAndView mav, HttpServletRequest httpServletRequest) {
        return getFormByDTO(
                mav,
                new BrandDTO(),
                httpServletRequest.getRequestURI(),
                false
        );
    }

    @GetMapping(path = UrlRoute.URL_ADMIN_BRAND_EDIT + "/{id}")
    public ModelAndView edit(@PathVariable Long id, ModelAndView mav, HttpServletRequest httpServletRequest) {
        return getFormByDTO(
                mav,
                brandService.getDTOById(id),
                httpServletRequest.getRequestURI(),
                true
        );
    }

    @PostMapping(path = UrlRoute.URL_ADMIN_BRAND_NEW)
    public ModelAndView formHandler(
            @Valid @ModelAttribute("brand") BrandDTO brandDTO,
            BindingResult result,
            ModelAndView mav
    ) {
        return formHandle(result, mav, brandDTO, null);
    }

    @PutMapping(path = UrlRoute.URL_ADMIN_BRAND_EDIT + "/{id}")
    public ModelAndView formHandler(
            @Valid @ModelAttribute("brand") BrandDTO brandDTO,
            BindingResult result,
            ModelAndView mav,
            @PathVariable Long id
    ) {
        return formHandle(result, mav, brandDTO, id);
    }

    private ModelAndView getFormByDTO(ModelAndView mav, BrandDTO dto, String uri, boolean isEdit) {
        mav.setViewName("admin/brand/form");
        mav.addObject("brand", dto);
        mav.addObject("action", uri);
        mav.addObject("isEdit", isEdit);
        return mav;
    }

    private ModelAndView formHandle(BindingResult result, ModelAndView mav, BrandDTO dto, Long id) {
        if (result.hasErrors()) {
            mav.setViewName("admin/brand/form");
            return mav;
        }
        brandService.persist(dto, id);
        mav.setViewName("redirect:" + UrlRoute.URL_ADMIN_BRAND);
        return mav;
    }

}
