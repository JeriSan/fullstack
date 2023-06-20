import com.backend.entity.*;
import com.backend.FullStackApp;
import com.backend.repository.PersonRepository;
import com.backend.services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.ls.LSException;

import javax.print.Doc;
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
    private UserService userService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private ProfessionService professionService;
    @Autowired
    private DocService docService;
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
        Long personId = 2L;
        LocalDate date2 = LocalDate.of(1994, 10, 14);
        personService.changeBirthdate(personId, date2);
        PersonEntity savedPerson = personService.findById(personId).get();
        System.out.println(savedPerson.getId()+ " "+ savedPerson.getName()+" "+savedPerson.getLastname()+" "+savedPerson.getBirthdate());
    }

    @Test
    public void findByIdSaveTest2(){
        Long personId = 2L;
        LocalDate date2 = LocalDate.of(1995, 10, 14);
        personService.changeBirthdate2(personId, date2);
        PersonEntity savedPerson = personService.findById(personId).get();
        System.out.println(savedPerson.getId()+ " "+ savedPerson.getName()+" "+savedPerson.getLastname()+" "+savedPerson.getBirthdate());
    }

    @Test
    public void addAllInformation(){
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setDocType("pasaporte");

        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setDescriptionLanguage("Italiano");

        LanguageEntity languageEntity1 = new LanguageEntity();
        languageEntity1.setDescriptionLanguage("Portugues");

        List<LanguageEntity> listLanguage = new ArrayList<>();
        listLanguage.add(languageEntity);
        listLanguage.add(languageEntity1);

        ProfessionEntity professionEntity = new ProfessionEntity();
        professionEntity.setDescriptionProfession("Doctor");

        List<ProfessionEntity> listProfession =  new ArrayList<>();
        listProfession.add(professionEntity);


        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("aaokiyi");
        userEntity.setPassword("aokiyi123");

        List<UserEntity> listUser = new ArrayList<>();
        listUser.add(userEntity);

        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("Akane");
        personEntity.setLastname("Aokiyi");
        LocalDate date1 = LocalDate.of(1984, 3, 8);
        personEntity.setBirthdate(date1);
        personEntity.setDocType(documentEntity);
        personEntity.setUsernames(listUser);
        personEntity.setProfessions(listProfession);
        personEntity.setLanguages(listLanguage);

        userEntity.setPersonEntity(personEntity);
        professionEntity.setPersonEntity(personEntity);
        languageEntity.setPersonEntity(personEntity);


        docService.save(documentEntity);
        personService.save(personEntity);
        languageService.save(languageEntity);
        languageService.save(languageEntity1);
        professionService.save(professionEntity);
        userService.save(userEntity);
    }

    @Test
    public void selectPersonWithDoc(){
        List<PersonEntity> listaPersona = personService.personaConDocumento();
        for(PersonEntity person : listaPersona){
            DocumentEntity doc = person.getDocType();
            System.out.println(person.getId()+" "+person.getName()+" "+person.getLastname()+" "+person.getBirthdate());
            if(doc==null){
                System.out.println(" "+doc);
            }else{
                System.out.println(" "+doc.getId()+" "+doc.getDocType());
            }
        }

    }
    @Test
    public void selectPersonWithLanguage(){

    }
    @Test
    public void selectPersonWithProfession(){

    }
    @Test
    public void selectPersonWithUser(){

    }
    @Test
    public void selectPersonWithProfLan(){
        List<PersonEntity> listaPersona = personService.personaConProfLan();
        for (PersonEntity person : listaPersona){
            List<LanguageEntity> lanList = person.getLanguages();
            List<ProfessionEntity> profList = person.getProfessions();
            System.out.println(person.getId()+" "+person.getName()+" "+person.getLastname()+" "+person.getBirthdate());
            for (LanguageEntity lan : lanList){
                System.out.println("\t"+lan.getId()+" "+lan.getDescriptionLanguage());
            }
            for(ProfessionEntity prof : profList){
                System.out.println("\t"+prof.getId()+" "+prof.getDescriptionProfession());
            }
        }

    }
    @Test
    public void selectPersonWithAllInformation(){
        List<PersonEntity> listPerson = personService.personaConTodaInformacion();
        for(PersonEntity person : listPerson) {
            DocumentEntity doc = person.getDocType();
            List<LanguageEntity> langList= person.getLanguages();
            List<ProfessionEntity> profList = person.getProfessions();
            List<UserEntity> userList = person.getUsernames();
            System.out.println(person.getId()+" "+person.getName()+" "+person.getLastname()+" "+person.getBirthdate());
            if(doc==null){
                System.out.println(" "+doc);
            }else{
                System.out.println(" "+doc.getId()+" "+doc.getDocType());
            }
            for (LanguageEntity lan : langList){
                System.out.println("\t"+lan.getId()+" "+lan.getDescriptionLanguage());
            }
            for(ProfessionEntity prof : profList){
                System.out.println("\t"+prof.getId()+" "+prof.getDescriptionProfession());
            }
            for (UserEntity user : userList){
                System.out.println("\t"+user.getId()+" "+user.getUsername()+" "+user.getPassword());
            }
        }
    }
}

