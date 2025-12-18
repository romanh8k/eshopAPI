//package main.eshopapi.controllers;
//
//import main.eshopapi.dtos.SignUpDTO;
//import main.eshopapi.dtos.UserDTO;
//import main.eshopapi.entities.Customer;
//import main.eshopapi.entities.Vendor;
//import main.eshopapi.enums.UserRoles;
//import main.eshopapi.services.SignUpService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.logging.Logger;
//
//@RestController
//public class SignUpController {
//
//    private SignUpService signUpService;
//    private Logger logger = Logger.getLogger(SignUpController.class.getName());
//
//    public SignUpController(SignUpService signUpService) {
//        this.signUpService = signUpService;
//    }
//
//    @PostMapping("/signup")
//    public void signUp(@RequestBody SignUpDTO user) {
////        logger.info(user.getName() + " " + user.getEmail() + " " + user.getPassword() + " " + user.getRole());
//        if (user.getRole() == UserRoles.VENDOR) {
//            Vendor v = new Vendor();
//            v.setName(user.getName());
//            v.setEmail(user.getEmail());
//            v.setPassword(user.getPassword());
//            signUpService.signUp(v);
//        }
//        else {
//            Customer c = new Customer();
//            c.setName(user.getName());
//            c.setEmail(user.getEmail());
//            c.setPassword(user.getPassword());
//            signUpService.signUp(c);
//        }
//    }
//}
