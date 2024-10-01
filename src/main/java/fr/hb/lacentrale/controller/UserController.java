package fr.hb.lacentrale.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.lacentrale.advisor.CustomResponse;
import fr.hb.lacentrale.dto.UserCreateDto;
import fr.hb.lacentrale.entity.User;
import fr.hb.lacentrale.json_views.JsonViewUser;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import fr.hb.lacentrale.service.UserService;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserService userService;

    @GetMapping("/{id}")
    public User show(@PathVariable String id){
        return userService.findById(id);
    }

    @GetMapping
    public List<User> list(){
        return userService.list();
    }

    @PostMapping("/activate/{code}")
    @JsonView(JsonViewUser.UserMinimalView.class)
    public User activate(@PathVariable String code){
        return userService.activate(code);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable String id){
        return userService.delete(id);
    }

}