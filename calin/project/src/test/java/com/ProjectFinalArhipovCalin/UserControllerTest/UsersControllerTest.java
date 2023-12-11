package com.ProjectFinalArhipovCalin.UserControllerTest;

import com.ProjectFinalArhipovCalin.flyproject.ProjectApplication;
import com.ProjectFinalArhipovCalin.flyproject.Service.users.UsersServiceImpl;
import com.ProjectFinalArhipovCalin.flyproject.models.entities.User;
import com.ProjectFinalArhipovCalin.flyproject.helpers.MapEntities;
import com.ProjectFinalArhipovCalin.flyproject.models.UserRequest;
import com.ProjectFinalArhipovCalin.flyproject.models.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ProjectApplication.class)
//@AutoConfigureMockMvc
//@WebMvcTest(UsersController.class)

//@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = ProjectApplication.class)
@AutoConfigureMockMvc

//face referinta la clasa care vrem sa testam clasa UserControler fiind o clasa care face request-uri web
public class UsersControllerTest {
    @MockBean //realizam un request
    private UsersServiceImpl usersServiceImpl;
    @Autowired  //realizam un request
    private MockMvc mockMvc;

    @Test
    public void createUser() throws Exception {
        //given
        User user = new User(235234, "Alex", "alex@gmail.ro",
                "Borojan", "testBor@gmail.com");
        UserResponse userResponse = MapEntities.mapUserToUserResponse(user);
        when(usersServiceImpl.createUser(Mockito.any(UserRequest.class)))
                .thenReturn(userResponse);
        // when
        mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isCreated());
    }
//                .andExpect(jsonPath("$.firstName").value("Alex"))
//                .andExpect(jsonPath("$.email").value("alex@gmail.ro"));

        // then

//    @Test
//    public void getAllUser() throws Exception {
//        List<User> users = Arrays.asList(
//                new User(123, "Dumitru", "Alina","Dumitru","dumitru@gmail.com"),
//                new User(345, "Alina123", "Alina","Cebotari","alina@gmail.com")
//        );
//        //mockuim servic-ul
//        when(usersServiceImpl.findAll()).thenReturn(users);
//        mockMvc.perform(get("/users")) //get-ul nu are nevoie de body, doar citim din db
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].firstName").value("Dumitru"))
//                .andExpect(jsonPath("$[0].email").value("dumitru@gmail.com"))
//                .andExpect(jsonPath("$[1].firstName").value("Alina"))
//                .andExpect(jsonPath("$[1].email").value("alina@gmail.com"));
//    }
}
