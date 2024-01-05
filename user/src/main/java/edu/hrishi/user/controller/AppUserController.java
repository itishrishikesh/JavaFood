package edu.hrishi.user.controller;

import edu.hrishi.user.dto.AppUserDto;
import edu.hrishi.user.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AppUserController {
    private final AppUserService appUserService;

    @PostMapping
    public ResponseEntity<AppUserDto> saveUser(@RequestBody AppUserDto appUserDto) {
        return ResponseEntity.ok(appUserService.saveUser(appUserDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserDto> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(appUserService.getUser(id));
    }
}
