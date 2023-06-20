import com.backend.FullStackApp;
import com.backend.entity.PersonEntity;
import com.backend.entity.ProfessionEntity;
import com.backend.repository.LanguageRepository;
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
public class ProfessionTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private ProfessionService professionService;
    @Autowired
    private ProfessionRepository professionRepository;
    @Test
    public void addProfessions(){
        ProfessionEntity professionEntity = new ProfessionEntity();
        professionEntity.setDescriptionProfession("Contador");

        ProfessionEntity professionEntity1 = new ProfessionEntity();
        professionEntity1.setDescriptionProfession("Abogado");


        List<ProfessionEntity> listProfession = new ArrayList<>();
        listProfession.add(professionEntity);
        listProfession.add(professionEntity1);

        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("Rosalia");
        personEntity.setLastname("Gutierrez");
        LocalDate date1 = LocalDate.of(1986,8,2);
        personEntity.setBirthdate(date1);
        personEntity.setProfessions(listProfession);

        professionEntity.setPersonEntity(personEntity);
        professionEntity1.setPersonEntity(personEntity);

        personService.save(personEntity);
        professionService.save(professionEntity);
        professionService.save(professionEntity1);

    }

}
