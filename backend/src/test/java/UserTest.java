import com.backend.FullStackApp;
import com.backend.entity.PersonEntity;
import com.backend.entity.UserEntity;
import com.backend.repository.PersonRepository;
import com.backend.repository.UserRepository;
import com.backend.services.PersonService;
import com.backend.services.UserService;
import com.sun.xml.bind.v2.runtime.reflect.ListTransducedAccessorImpl;
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
public class UserTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUsers() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("mlopez");
        userEntity.setPassword("mlopez123");//setUsername corregir

        List<UserEntity> listUser = new ArrayList();
        listUser.add(userEntity);

        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("Martin");
        personEntity.setLastname("Lopez");
        LocalDate date1 = LocalDate.of(1998, 4, 2);
        personEntity.setBirthdate(date1);
        personEntity.setUsernames(listUser);

        userEntity.setPersonEntity(personEntity);

        personService.save(personEntity);
        userService.save(userEntity);
    }

    @Test
    public void findByIdTest(){
        long id = 1L;
        UserEntity savedUser = userService.findById(id).get();
        System.out.println(savedUser.getId()+" "+savedUser.getUsername()+" "+savedUser.getPassword());
    }

    @Test
    public void changePasswordUser() {
        long id = 2L;
        String password = "aokiyia";

        userService.changePasswordUser(id,password);
        UserEntity savedPassword = userService.findById(id).get();
        System.out.println(savedPassword.getId()+" "+savedPassword.getUsername()+" "+savedPassword.getPassword());
    }

    @Test
    public void selectUserWithPerson(){
        List<UserEntity> userList = userService.selectUserWithPerson();
        for(UserEntity user : userList){
            PersonEntity savedPerson = user.getPersonEntity();
            //PersonEntity savedPerson = personService.findById(person.getId()).get();
            System.out.println(user.getId()+" "+user.getUsername()+" "+user.getPassword()+"\t"+savedPerson.getId()+" "+savedPerson.getName()+" "+savedPerson.getLastname());
        }
    }
}