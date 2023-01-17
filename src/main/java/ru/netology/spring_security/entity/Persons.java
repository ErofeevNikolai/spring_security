package ru.netology.spring_security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Persons {

    @EmbeddedId
    private Fio fio;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, length = 225)
    private String phone_number;

    @Column(name = "city_of_living", nullable = false, length = 225)
    private String cityOfLiving;

}
