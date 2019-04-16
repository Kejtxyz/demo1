package pl.sda;

import org.springframework.data.repository.CrudRepository;

public interface GreetingsRepositiory extends CrudRepository<Greeting, Long> {

}
