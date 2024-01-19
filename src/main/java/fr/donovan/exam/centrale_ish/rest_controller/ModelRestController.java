package fr.donovan.exam.centrale_ish.rest_controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.donovan.exam.centrale_ish.entity.Model;
import fr.donovan.exam.centrale_ish.DTO.ModelDTO;
import fr.donovan.exam.centrale_ish.service.ModelService;
import fr.donovan.exam.centrale_ish.json_views.JsonViews;
import fr.donovan.exam.centrale_ish.mapping.UrlRoute;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ModelRestController {

    private ModelService modelService;

    @GetMapping(path = UrlRoute.URL_MODEL)
//    @JsonView(JsonViews.ModelListJsonViews.class)
    public List<Model> list() {
        return this.modelService.findAll();
    }

    @GetMapping(path = UrlRoute.URL_MODEL + "/{field}")
//    @JsonView(JsonViews.ModelShowJsonViews.class)
    public Model show(@PathVariable String field) {
        return this.modelService.getByField(field);
    }

    @PostMapping(path = UrlRoute.URL_MODEL_NEW)
    public Model create(@Valid @RequestBody ModelDTO modelDTO) {
        return modelService.persist(modelDTO);
    }

    @PutMapping(path = UrlRoute.URL_MODEL_EDIT + "/{id}")
    public Model update(@Valid @RequestBody ModelDTO modelDTO, @PathVariable Long id) {
        return modelService.persist(modelDTO, id);
    }

}