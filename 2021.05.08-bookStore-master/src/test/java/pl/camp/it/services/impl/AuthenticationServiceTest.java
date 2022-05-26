package pl.camp.it.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.camp.it.configuration.TestConfiguration;
import pl.camp.it.dao.IBookDAO;
import pl.camp.it.dao.IOrderDAO;
import pl.camp.it.dao.IUserDAO;
import pl.camp.it.model.User;
import pl.camp.it.services.IAuthenticationService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class AuthenticationServiceTest {

    @Autowired
    IAuthenticationService authenticationService;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IBookDAO bookDAO;

    @MockBean
    IOrderDAO orderDAO;


    @Test
    public void correctAuthenticationTest() {
        String login = "mateusz";
        String password = "mateusz";
        Mockito.when(this.userDAO.getUserByLogin("mateusz")).thenReturn(generateTestUser());
        boolean result = authenticationService.authenticate(login, password);

        Assert.assertTrue(result);
    }

    @Test
    public void incorrectPasswordAuthenticationTest() {
        String login = "mateusz";
        String password = "mateusz2";

        boolean result = this.authenticationService.authenticate(login, password);

        Assert.assertFalse(result);
    }

    @Test
    public void incorrectLoginAuthenticationTest() {
        String login = "mateusz2";
        String password = "mateusz";

        boolean result = this.authenticationService.authenticate(login, password);

        Assert.assertFalse(result);
    }

    /*private User generateTestUser(){
        Us
    }*/ //TODO dokończyć

    @Test
    public void registerTest(){
        User user = new User();
        user.setLogin("mateusz");
        user.setName("mateusz");
        user.setSurname("bereda");
        user.setPassword("mateusz");
        String expectedPassword =

        this.authenticationService.registerUser(user);

        Mockito.verify(this.userDAO, Mockito.times(1)).addUser(user);

        Assert.assertEquals(User.Role.USER, user.getRole());
        Assert.assertEquals();
    }
}
