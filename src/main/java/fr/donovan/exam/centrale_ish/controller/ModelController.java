package fr.donovan.exam.centrale_ish.controller;

import fr.donovan.exam.centrale_ish.entity.Model;
import fr.donovan.exam.centrale_ish.DTO.ModelDTO;
import fr.donovan.exam.centrale_ish.service.ModelService;
import fr.donovan.exam.centrale_ish.mapping.UrlRoute;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @GetMapping(path = UrlRoute.URL_MODEL)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("model/index");
        mav.addObject("models", modelService.findAll());
        return mav;
    }

    @GetMapping(value = UrlRoute.URL_MODEL + "/{field}")
    public ModelAndView show(ModelAndView mav, @PathVariable String field) {
        Model model = modelService.getByField(field);

        mav.setViewName("model/show");
        mav.addObject("model", model);
        return mav;
    }

    @GetMapping(path = UrlRoute.URL_MODEL_NEW)
    public ModelAndView create(
            ModelAndView mav,
            HttpServletRequest httpServletRequest
    ) {
        return getFormByDTO(
                mav,
                new ModelDTO(),
                httpServletRequest.getRequestURI(),
                false
        );
    }

    @GetMapping(path = UrlRoute.URL_MODEL_EDIT + "/{id}")
    public ModelAndView edit(
            @PathVariable Long id,
            ModelAndView mav,
            HttpServletRequest httpServletRequest
    ) {
        return getFormByDTO(
                mav,
                modelService.getDTOById(id),
                httpServletRequest.getRequestURI(),
                true
        );
    }

    @PostMapping(path = UrlRoute.URL_MODEL_NEW)
    public ModelAndView formHandler(
            @Valid @ModelAttribute("model") ModelDTO modelDTO,
            BindingResult result,
            ModelAndView mav
    ) {
        return formHandle(result, mav, modelDTO, null);
    }

    @PutMapping(path = UrlRoute.URL_MODEL_EDIT + "/{id}")
    public ModelAndView formHandler(
            @Valid @ModelAttribute("model") ModelDTO modelDTO,
            BindingResult result,
            ModelAndView mav,
            @PathVariable Long id
    ) {
        return formHandle(result, mav, modelDTO, id);
    }

    private ModelAndView getFormByDTO(ModelAndView mav, ModelDTO dto, String uri, boolean isEdit) {
        mav.setViewName("model/form");
        mav.addObject("model", dto);
        mav.addObject("action", uri);
        mav.addObject("isEdit", isEdit);
        return mav;
    }

    private ModelAndView formHandle(BindingResult result, ModelAndView mav, ModelDTO dto, Long id) {
        if (result.hasErrors()) {
            mav.setViewName("model/form");
            return mav;
        }
        modelService.persist(dto, id);
        mav.setViewName("redirect:" + UrlRoute.URL_MODEL);
        return mav;
    }

}
