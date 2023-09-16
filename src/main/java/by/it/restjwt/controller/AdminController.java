package by.it.restjwt.controller;

import by.it.restjwt.dto.BaseResponse;
import by.it.restjwt.dto.UserDto;
import by.it.restjwt.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.it.restjwt.utils.Constants.USER;
import static by.it.restjwt.utils.ResponseUtils.CHANGE_ROLE_MESSAGE;
import static by.it.restjwt.utils.ResponseUtils.getSuccessResponse;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PatchMapping("/set/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponse> setAdmin(@PathVariable("id") Long id){
        adminService.setAdmin(id);
        return ResponseEntity.ok(getSuccessResponse(CHANGE_ROLE_MESSAGE, USER));
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(adminService.getAllUsers());
    }
}
