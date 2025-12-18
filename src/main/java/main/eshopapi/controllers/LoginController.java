//package main.eshopapi.controllers;
//
//import main.eshopapi.dtos.LoginRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class LoginController {
//
//    private final AuthenticationManager authenticationManager;
//
//    public LoginController(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @PostMapping("/login")
//    public void login(@RequestBody LoginRequest loginRequest) {
//        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.email, loginRequest.password);
//        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
////        return authenticationResponse;
//    }
//
//    public record LoginRequest(String email, String password){
//
//    }
//}