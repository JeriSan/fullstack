import com.backend.FullStackApp;
import com.backend.entity.LanguageEntity;
import com.backend.entity.PersonEntity;
import com.backend.entity.ProfessionEntity;
import com.backend.repository.LanguageRepository;
import com.backend.repository.PersonRepository;
import com.backend.repository.ProfessionRepository;
import com.backend.services.LanguageService;
import com.backend.services.PersonService;
import com.backend.services.ProfessionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE,
        classes = FullStackApp.class)
public class LanguageTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private ProfessionService professionService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private ProfessionRepository professionRepository;
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void addLanguages(){

        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setDescriptionLanguage("Ingles");

        LanguageEntity languageEntity1 = new LanguageEntity();
        languageEntity1.setDescriptionLanguage("Frances");

        LanguageEntity languageEntity2 = new LanguageEntity();
        languageEntity2.setDescriptionLanguage(("Japones"));

        LanguageEntity languageEntity3 = new LanguageEntity();
        languageEntity3.setDescriptionLanguage("Italiano");

        LanguageEntity languageEntity4 = new LanguageEntity();
        languageEntity4.setDescriptionLanguage("Portugues");

        List<LanguageEntity> listLanguage = new ArrayList<>();
        listLanguage.add(languageEntity);
        listLanguage.add(languageEntity1);
        listLanguage.add(languageEntity2);
        listLanguage.add(languageEntity3);
        listLanguage.add(languageEntity4);

       /* ProfessionEntity professionEntity = new ProfessionEntity();
        professionEntity.setDescriptionProfession("Ingeniero");

        ProfessionEntity professionEntity1 = new ProfessionEntity();
        professionEntity1.setDescriptionProfession("Profesor");

        List<ProfessionEntity> listProfession = new ArrayList<>();
        listProfession.add(professionEntity);
        listProfession.add(professionEntity1);
*/
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("Emilia");
        personEntity.setLastname("Rosales");
        LocalDate date1 = LocalDate.of(1975,10,25);
        personEntity.setBirthdate(date1);
        personEntity.setLanguages(listLanguage);

        languageEntity.setPersonEntity(personEntity);
        languageEntity1.setPersonEntity(personEntity);
        languageEntity2.setPersonEntity(personEntity);
        languageEntity3.setPersonEntity(personEntity);
        languageEntity4.setPersonEntity(personEntity);

        //  personEntity.setProfessions(listProfession);

        personService.save(personEntity);
        languageService.save(languageEntity);
        languageService.save(languageEntity1);
        languageService.save(languageEntity2);
        languageService.save(languageEntity3);
        languageService.save(languageEntity4);
        //professionService.save(professionEntity);
       // professionService.save(professionEntity1);

    }

    @Test
    public void findbyId(){
        Long id = 4L;
        LanguageEntity languageEntity = languageService.findById(id).get();
        System.out.println(languageEntity.getId()+" "+languageEntity.getDescriptionLanguage());
    }

}
