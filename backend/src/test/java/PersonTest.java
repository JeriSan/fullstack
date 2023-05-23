import com.backend.entity.PersonEntity;
import com.backend.FullStackApp;
import com.backend.repository.PersonRepository;
import com.backend.services.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE,
        classes = FullStackApp.class)
public class PersonTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void agregarPersonas() {
        PersonEntity personEntity1 = new PersonEntity();
        personEntity1.setName("Julia");
        personEntity1.setLastname("Rivera");
        LocalDate date1 = LocalDate.of(1995, 5, 14);
        personEntity1.setBirthdate(date1);

        PersonEntity personEntity2 = new PersonEntity();
        personEntity2.setName("Pilar");
        personEntity2.setLastname("Mendoza");
        LocalDate date2 = LocalDate.of(1984, 9, 30);
        personEntity1.setBirthdate(date2);//cambiar aqui

        personService.save(personEntity1);
        personService.save(personEntity2);

        System.out.println(" "+personEntity1.getId()+" "+personEntity1.getName()+" "+personEntity1.getLastname()+" "+personEntity1.getBirthdate());
        System.out.println(" "+personEntity2.getId()+" "+personEntity2.getName()+" "+personEntity2.getLastname()+" "+personEntity2.getBirthdate());


    }
//    Optional<T> findById(ID id);
    @Test
    public void findByIdTest(){
        long id = 2L;
        PersonEntity savedPerson = personService.findById(id).get();
        System.out.println(savedPerson.getId()+ " "+ savedPerson.getName()+" "+savedPerson.getLastname()+" "+savedPerson.getBirthdate());

        /*
        Optional<PersonEntity> optional = personService.findById(id);
        PersonEntity person = optional.orElseThrow(IllegalArgumentException::new);

        System.out.println(person.getId()+ " "+ person.getName()+" "+person.getLastname()+" "+person.getBirthdate());
         */
    }
// Iterable<T> findAll();
    @Test
    public void findAllTest(){
        List<PersonEntity> personList = personService.findAll();
        for(PersonEntity person : personList ){
            System.out.println(person.getId()+" "+person.getName()+" "+person.getLastname()+" "+person.getBirthdate());
        }
    }

//findbyid y modificar luego save
    @Test
    public void findByIdSaveTest(){
        Long personId = 3L;
        LocalDate date2 = LocalDate.of(1994, 10, 14);
        personService.changeBirthdate(personId, date2);
        PersonEntity savedPerson = personService.findById(personId).get();
        System.out.println(savedPerson.getId()+ " "+ savedPerson.getName()+" "+savedPerson.getLastname()+" "+savedPerson.getBirthdate());
    }

    @Test
    public void findByIdSaveTest2(){
        Long personId = 3L;
        LocalDate date2 = LocalDate.of(1995, 10, 14);
        personService.changeBirthdate2(personId, date2);
        PersonEntity savedPerson = personService.findById(personId).get();
        System.out.println(savedPerson.getId()+ " "+ savedPerson.getName()+" "+savedPerson.getLastname()+" "+savedPerson.getBirthdate());
    }
}

