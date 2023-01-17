package ru.netology.spring_security.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.netology.spring_security.entity.Fio;
import ru.netology.spring_security.entity.Persons;

import java.util.List;
import java.util.Optional;

@Repository
public interface PresonsRepository extends PagingAndSortingRepository<Persons, Fio> {

    List<Persons> findByCityOfLiving(String city);

    List<Persons> findAllByAgeBeforeOrderByAge(Integer age);

    Optional<Persons> findByFio(Fio fio);
}

