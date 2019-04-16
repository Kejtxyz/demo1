package pl.sda;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// api restowe,
@RestController // kontroler
@RequestMapping("/greetings")  // kontorler .. nasluchuje na tym
public class HelloWorldRestController {

    private GreetingsRepositiory repositiory;

    public HelloWorldRestController(GreetingsRepositiory repositiory) {
        this.repositiory = repositiory;
    }

    @GetMapping("/greetings")
    public Iterable<Greeting> getAllGreetings() {
        return repositiory.findAll();
    }

    @PostMapping  // deserjalizuje
    // ("/greetings")    // dodac do bazy pozdrowienia przez api restowe / obiekt ma byc zdeserializowany z ciala requesta
    public void addGreeting(@RequestBody Greeting greeting) {
        repositiory.save(greeting);     //- mozna usunac po dodaniu @RequestMapping("/greetings") u gory
    }

    @DeleteMapping("/{id}")   // obsluguje sciezki regexem
    public void deleteGreeting(@PathVariable("id") long id) {
        repositiory.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Greeting> getById(@PathVariable long id){
        return repositiory.findById(id);
    }






}
// to jest serwer on chodzi w kolko


