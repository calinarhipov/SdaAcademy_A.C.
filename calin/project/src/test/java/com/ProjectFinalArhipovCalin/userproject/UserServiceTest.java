package com.ProjectFinalArhipovCalin.userproject;

import com.ProjectFinalArhipovCalin.flyproject.Service.users.UsersServiceImpl;
import com.ProjectFinalArhipovCalin.flyproject.models.entities.User;
import com.ProjectFinalArhipovCalin.flyproject.models.UserResponse;
import com.ProjectFinalArhipovCalin.flyproject.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    //ca sa manipulam repository-ul nostru tre sal cream ca fild
    @Mock //ca sa putem manipula UsesRepository-ul nostru
    private UsersRepository usersRepository;
    @InjectMocks//stim ca usrsServisul nostru foloseste niste mock-uri
    private UsersServiceImpl usersServiceImpl;
    @BeforeEach       //metoda respectiva se ruleaza inaintea fiecarui test
    public void setup(){
        MockitoAnnotations.openMocks(this); //this-ul se refera la clasa: UserServiceTest
    }
    @Test
    public void testFindAll(){
        List<User> userList = Arrays.asList(
                new User(1234, "bonjur123", "Calin","Arhipov","arhipovcalin@gmail.com"),
                new User(3244,"Amir234","Amir","Baian","baianamir@gmail.com")
        );
        when(usersRepository.findAll()).thenReturn(userList);
     List<UserResponse> resultUser =  usersServiceImpl.findAll();

        assertEquals(2, resultUser.size());
        assertEquals("Calin", resultUser.get(0).getFirstName());
        assertEquals("Amir", resultUser.get(1).getFirstName());
    }
    @Test
    public void testFindById() {
        User user = new User(13241, "dangerous", "Dima","Armean","dimarmean@gmail.com");
        when(usersRepository.findById(13241)).thenReturn(Optional.of(user));
        UserResponse user1 = usersServiceImpl.findById(13241);
        assertEquals("Dima", user1.getFirstName());
    }
//    @Test
//    public void testGetUserByIdWhenUserDontExist() {
//        assertThrows(RuntimeException.class, () -> usersServiceImpl.deleteUser(12341));
//    }

}
