package ru.netology.spring_security.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.spring_security.repository.PresonsRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@AllArgsConstructor
@RestController
public class Controller {
    private PresonsRepository personRepo;


    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
//    private ResponseEntity<List> getByCiti(@RequestParam("city") String city) {
//        return new ResponseEntity<>(personRepo.findByCityOfLiving(city), HttpStatus.OK);
        private ResponseEntity<String> getByCiti(@RequestParam("city") String city) {
        return ResponseEntity.ok("Secured: READ");
    }

    @GetMapping("/persons/by-age")
    @RolesAllowed("ROLE_WRITE")
//    private ResponseEntity<List> getByAge(@RequestParam("age") Integer age) {
//        return new ResponseEntity<>(personRepo.findAllByAgeBeforeOrderByAge(age), HttpStatus.OK);
        private ResponseEntity<String> getByAge(@RequestParam("age") Integer age) {
        return  ResponseEntity.ok("Secured: WRITE");
    }
    @PostAuthorize("#username == authentication.principal.usermane")
    @GetMapping("/persons/username")
    private ResponseEntity<String> getByFio(@RequestParam("username") String username) {
        return  ResponseEntity.ok("Secured: OK fo " + username);
    }
}