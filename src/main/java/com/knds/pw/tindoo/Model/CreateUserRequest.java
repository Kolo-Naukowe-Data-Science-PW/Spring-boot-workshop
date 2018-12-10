package com.knds.pw.tindoo.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {

    private long id;

    private String name;

    private String description;

    private int age;

    private Sex sex;

    private Set<Sex> interestedIn;

    private double lng;

    private double lat;

    private double defaultRadius;

}
