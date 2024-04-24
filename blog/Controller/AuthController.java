package com.example.blog.Controller;


import com.example.blog.Api.ApiResponse;
import com.example.blog.Model.User;
import com.example.blog.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;



    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user){
        authService.register(user);
        return ResponseEntity.status(200).body(user);
    }



    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity deleteUser(@AuthenticationPrincipal User user , @PathVariable Integer id){
        authService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully deleted"));
    }


    @PutMapping("/update/{username}")
    public ResponseEntity update(@AuthenticationPrincipal User username , @RequestBody @Valid User user) {

        authService.updateUser(username.getUsername(), user);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully updated"));

    }


    @GetMapping("/get_all")
    public ResponseEntity getAllUsers(@AuthenticationPrincipal User user){
        return ResponseEntity.status(200).body(authService.getAllUser());
    }

}
