package ru.maxima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.models.Person;


public interface PeopleRepository extends JpaRepository<Person, Long> {

}
