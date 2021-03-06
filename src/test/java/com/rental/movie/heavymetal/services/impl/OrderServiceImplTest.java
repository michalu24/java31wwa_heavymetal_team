package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Order;
import com.rental.movie.heavymetal.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class OrderServiceImplTest {


    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private UserServiceImpl userService;

    private static Long expectedId;
    private static Order order;


    @BeforeEach
    public void init() {
        expectedId = 1L;
        order = new Order();
    }

    @Test
    public void orderShouldBeAddedToRepository(){
        //when
        orderService.save(order);
        List<Order> orders = orderService.getAll() ;
        //then
        assertEquals(1,orders.size());
    }

    @Test
    public void orderShouldBeFindable(){
        //when
        orderService.save(order);
        Order addedOrder = orderService.getById(expectedId);
        //then
        assertEquals(addedOrder.getId(), order.getId());
    }

    @Test
    public void orderShouldBeUpdated(){
        //when
        orderService.save(order);
        User user = new User();
        user.setFirstName("Luke");
        userService.save(user);
        order.setUser(user);
        orderService.update(order);

        //then

        User findUser = orderService.getById(expectedId).getUser();
        System.out.println(findUser.getFirstName());

        assertNotNull(findUser);
    }

    @Test
    public void orderShouldBeDeleted(){
        //when
        orderService.save(order);
        orderService.delete(expectedId);
        //then
        Order order = orderService.getById(expectedId);
        assertNull(order);
    }


}