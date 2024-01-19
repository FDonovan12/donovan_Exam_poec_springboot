package fr.donovan.exam.centrale_ish.rest_controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.donovan.exam.centrale_ish.entity.User;
import fr.donovan.exam.centrale_ish.DTO.UserDTO;
import fr.donovan.exam.centrale_ish.service.UserService;
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
public class UserRestController {

    private UserService userService;

    @GetMapping(path = UrlRoute.URL_USER + "/{field}")
    @JsonView(JsonViews.UserShowJsonViews.class)
    public User show(@PathVariable String field) {
        return this.userService.getByField(field);
    }

    @PostMapping(path = UrlRoute.URL_USER_NEW)
    public User create(@Valid @RequestBody UserDTO userDTO) {
        return userService.persist(userDTO);
    }

    @PutMapping(path = UrlRoute.URL_USER_EDIT + "/{id}")
    public User update(@Valid @RequestBody UserDTO userDTO, @PathVariable Long id) {
        return userService.persist(userDTO, id);
    }

}