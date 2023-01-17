package ru.netology.spring_security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Fio implements Serializable {

    @NaturalId
    @Column(nullable = false, length = 100)
    private String name;

    @NaturalId
    @Column(nullable = false, length = 100)
    private String surname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fio that = (Fio) o;
        return name == that.name &&
                surname == that.surname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}