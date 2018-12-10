package com.knds.pw.tindoo.Service;

import com.knds.pw.tindoo.Model.CreateUserRequest;
import com.knds.pw.tindoo.Model.User;
import com.knds.pw.tindoo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(Long id){
        return userRepository.getOne(id);
    }

    public User createUser(CreateUserRequest createUserRequest){

        User user = User.builder()
                .age(createUserRequest.getAge())
                .name(createUserRequest.getName())
                .description(createUserRequest.getDescription())
                .sex(createUserRequest.getSex())
                .interestedIn(createUserRequest.getInterestedIn())
                .swipedLeft(Collections.emptySet())
                .swipedRight(Collections.emptySet())
                .lng(createUserRequest.getLng())
                .lat(createUserRequest.getLat())
                .defaultRadius(createUserRequest.getDefaultRadius())
                .build();

        return userRepository.saveAndFlush(user);

    }

    public void swipeRight(Long swipedId, Long userId){

        User swiped = userRepository.getOne(swipedId);
        User user = userRepository.getOne(userId);

        user.getSwipedRight().add(swiped);

        userRepository.save(user);
    }

    public void swipeLeft(Long swipedId, Long userId){

        User swiped = userRepository.getOne(swipedId);
        User user = userRepository.getOne(userId);

        user.getSwipedLeft().add(swiped);

        userRepository.save(user);
    }
}
