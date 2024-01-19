package fr.donovan.exam.centrale_ish.rest_controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.donovan.exam.centrale_ish.entity.Brand;
import fr.donovan.exam.centrale_ish.DTO.BrandDTO;
import fr.donovan.exam.centrale_ish.service.BrandService;
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
public class BrandRestController {

    private BrandService brandService;

    @GetMapping(path = UrlRoute.URL_BRAND)
//    @JsonView(JsonViews.BrandListJsonViews.class)
    public List<Brand> list() {
        return this.brandService.findAll();
    }

    @GetMapping(path = UrlRoute.URL_BRAND + "/{field}")
//    @JsonView(JsonViews.BrandShowJsonViews.class)
    public Brand show(@PathVariable String field) {
        return this.brandService.getByField(field);
    }

    @PostMapping(path = UrlRoute.URL_BRAND_NEW)
    public Brand create(@Valid @RequestBody BrandDTO brandDTO) {
        return brandService.persist(brandDTO);
    }

    @PutMapping(path = UrlRoute.URL_BRAND_EDIT + "/{id}")
    public Brand update(@Valid @RequestBody BrandDTO brandDTO, @PathVariable Long id) {
        return brandService.persist(brandDTO, id);
    }

}