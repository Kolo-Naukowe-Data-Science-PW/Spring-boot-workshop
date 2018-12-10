package com.knds.pw.tindoo.Controller;

import com.knds.pw.tindoo.Dto.CreateUserRequestDto;
import com.knds.pw.tindoo.Dto.UserDto;
import com.knds.pw.tindoo.Model.CreateUserRequest;
import com.knds.pw.tindoo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id){
        return UserDto.from(userService.getUser(id));
    }

    @PostMapping
    public UserDto createUser(@RequestBody CreateUserRequestDto requestDto){
        CreateUserRequest request = CreateUserRequest.builder()
                .age(requestDto.getAge())
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .sex(requestDto.getSex())
                .interestedIn(requestDto.getInterestedIn())
                .defaultRadius(requestDto.getDefaultRadius())
                .lng(requestDto.getLng())
                .lat(requestDto.getLat())
                .build();

        return UserDto.from(userService.createUser(request));


    }

    @PostMapping("/right")
    public void swipeRight(@RequestParam Long swipedId, @RequestParam Long userId){
        userService.swipeRight(swipedId, userId);
    }

    @PostMapping("/left")
    public void swipeLeft(@RequestParam Long swipedId, @RequestParam Long userId){
        userService.swipeLeft(swipedId, userId);
    }
}
