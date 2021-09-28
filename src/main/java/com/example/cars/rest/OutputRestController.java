package com.example.cars.rest;

import com.example.cars.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

//
//(поля: id – integer, msg – сообщение, 4к символов) (методы
//        offer – положить элемент,
//        poll – изъять и вернуть элемент, находящийся в начале очереди,
//        peek – возвращает первый элемент находящийся в начале очереди без изъятия,
//        peekMax – возвращает максимальный элемент в очереди,
//        all – список элементов в очереди, порядок как в очереди).

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class OutputRestController {
    private final PersonService personService;

//    @GetMapping("{request}")
//    public ResponseEntity<MessageDto> getFromMessages(@PathVariable(name = "request") String request) {
//        switch (request) {
//            case "poll":
//                return new ResponseEntity<>(MessageDto.fromMessage(personService.poll()), HttpStatus.OK);
//            case "peek":
//                return new ResponseEntity<>(MessageDto.fromMessage(personService.peek()), HttpStatus.OK);
//            case "peekMax":
//                return new ResponseEntity<>(MessageDto.fromMessage(personService.peekMax()), HttpStatus.OK);
//            case "all":
//                Map<Object,Object> response = new HashMap<>();
//                personService.all().forEach(message -> response.put(message.getId(),message.getMessage()));
//                return new ResponseEntity(response, HttpStatus.OK);
//
//        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @GetMapping("/clear")
    public ResponseEntity clearAll() {
        try {
            personService.delete();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/personwithcars")
    public ResponseEntity getPerson(@RequestParam("personid")  Long id) {
        try {
            return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
