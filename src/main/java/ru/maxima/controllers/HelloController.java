package ru.maxima.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.maxima.models.Person;
import ru.maxima.repositories.PeopleRepository;

import java.util.List;
import java.util.Random;

@Controller
public class HelloController {

    private final PeopleRepository peopleRepository;

    @Autowired
    public HelloController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello-view";
    }

    @ResponseBody
    @GetMapping("/people")
    public List<Person> getAllPeople() {
        return peopleRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/create")
    public List<Person> createPerson() {
        Person person = new Person();
        Random random = new Random();
        person.setName("User: " + random.nextInt(0, 100));
        peopleRepository.save(person);

        return peopleRepository.findAll();
    }

}
