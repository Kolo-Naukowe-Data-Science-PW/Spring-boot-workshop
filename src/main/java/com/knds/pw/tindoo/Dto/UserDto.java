package com.knds.pw.tindoo.Dto;

import com.knds.pw.tindoo.Model.Sex;
import com.knds.pw.tindoo.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private long id;

    private String name;

    private String description;

    private int age;

    private Sex sex;

    private Set<Sex> interestedIn;

    private double lng;

    private double lat;

    private double defaultRadius;

    public static UserDto from(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .description(user.getDescription())
                .age(user.getAge())
                .sex(user.getSex())
                .interestedIn(user.getInterestedIn())
                .lng(user.getLng())
                .lat(user.getLat())
                .defaultRadius(user.getDefaultRadius())
                .build();
    }

}
