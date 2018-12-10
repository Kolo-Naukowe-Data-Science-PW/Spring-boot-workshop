package com.knds.pw.tindoo.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", nullable = false, updatable = false)
    private long id;

    private String name;

    @Column(columnDefinition = "text")
    private String description;

    private int age;

    private Sex sex;

    @ElementCollection
    @CollectionTable(
            name = "interestedIn",
            joinColumns = @JoinColumn(name="userId")
    )
    private Set<Sex> interestedIn;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "swipedRight",
            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "swipedId", referencedColumnName = "userId")
    )
    private Set<User> swipedRight;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "swipedLeft",
            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "swipedId", referencedColumnName = "userId")
    )
    private Set<User> swipedLeft;

    private double lng;

    private double lat;

    private double defaultRadius;


}
