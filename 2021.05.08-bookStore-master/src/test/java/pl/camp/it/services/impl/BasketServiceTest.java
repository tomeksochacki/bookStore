package pl.camp.it.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
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
import pl.camp.it.services.IBasketService;
import pl.camp.it.services.IBookService;
import pl.camp.it.session.SessionObject;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})

public class BasketServiceTest {

    @Autowired
    IBasketService basketService;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IBookDAO bookDAO;

    @MockBean
    IOrderDAO orderDAO;

    @Resource
    SessionObject sessionObject;

    @Test
    public void assBookToBasketTest(){
        String isbn = "099-292993-292929";

        Mockito.when()

    }



}
