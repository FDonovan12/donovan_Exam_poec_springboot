package fr.donovan.exam.centrale_ish.rest_controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.donovan.exam.centrale_ish.entity.Listing;
import fr.donovan.exam.centrale_ish.DTO.ListingDTO;
import fr.donovan.exam.centrale_ish.service.ListingService;
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
public class ListingRestController {

    private ListingService listingService;

    @GetMapping(path = UrlRoute.URL_LISTING)
    @JsonView(JsonViews.ListingListJsonViews.class)
    public List<Listing> list() {
        return this.listingService.findAll();
    }

    @GetMapping(path = UrlRoute.URL_LISTING + "/{field}")
    @JsonView(JsonViews.ListingShowJsonViews.class)
    public Listing show(@PathVariable String field) {
        return this.listingService.getByField(field);
    }

    @PostMapping(path = UrlRoute.URL_LISTING_NEW)
    public Listing create(@Valid @RequestBody ListingDTO listingDTO) {
        return listingService.persist(listingDTO);
    }

    @PutMapping(path = UrlRoute.URL_LISTING_EDIT + "/{id}")
    public Listing update(@Valid @RequestBody ListingDTO listingDTO, @PathVariable Long id) {
        return listingService.persist(listingDTO, id);
    }

}