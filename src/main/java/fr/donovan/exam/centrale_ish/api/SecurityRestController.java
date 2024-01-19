package fr.donovan.exam.centrale_ish.api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.donovan.exam.centrale_ish.DTO.UserLoginDTO;
import fr.donovan.exam.centrale_ish.DTO.UserDTO;
import fr.donovan.exam.centrale_ish.custom_response.JwtTokenResponse;
import fr.donovan.exam.centrale_ish.entity.User;
import fr.donovan.exam.centrale_ish.json_views.JsonViews;
import fr.donovan.exam.centrale_ish.mapping.UrlRoute;
import fr.donovan.exam.centrale_ish.service.UserService;
import fr.donovan.exam.centrale_ish.service.security.JwtAuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
@AllArgsConstructor
public class SecurityRestController {

    private UserService userService;

    private JwtAuthenticationService jwtAuthenticationService;

    @PostMapping(path = UrlRoute.URL_REGISTER)
    @JsonView(JsonViews.UserShowJsonViews.class)
    User create(@Valid @RequestBody UserDTO userDTO) {
        return userService.persist(userDTO);
    }

    @PostMapping(path = UrlRoute.URL_LOGIN)
    ResponseEntity<JwtTokenResponse> persist(@RequestBody UserLoginDTO userLoginDTO) {
        return jwtAuthenticationService.authenticate(userLoginDTO);
    }

}