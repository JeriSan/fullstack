import com.backend.FullStackApp;
import com.backend.entity.DocumentEntity;
import com.backend.entity.PersonEntity;
import com.backend.repository.PersonRepository;
import com.backend.services.DocService;
import com.backend.services.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE,
        classes = FullStackApp.class)
public class DocTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private DocService docService;

    @Test
    public void addDoctypes(){
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setDocType("CE");

        DocumentEntity documentEntity1 = new DocumentEntity();
        documentEntity1.setDocType("Pasaporte");

        docService.save(documentEntity);
        docService.save(documentEntity1);
    }
    @Test
    public void addDocTypeWithPerson(){
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setDocType("Dni");

        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("Dario");
        personEntity.setLastname("Caceres");
        personEntity.setDocType(documentEntity);

        docService.save(documentEntity);
        personService.save(personEntity);
    }

    @Test
    public void findbyId(){
        Long id = 2L;
        DocumentEntity documentEntity = docService.findById(id).get();
        System.out.println(documentEntity.getId()+ " "+documentEntity.getDocType());
    }

}

