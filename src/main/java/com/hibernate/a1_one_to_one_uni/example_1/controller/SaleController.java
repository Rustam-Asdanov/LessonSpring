package com.hibernate.a1_one_to_one_uni.example_1.controller;

import com.hibernate.a1_one_to_one_uni.example_1.DAO.SaleDAO;
import com.hibernate.a1_one_to_one_uni.example_1.models.Human;
import com.hibernate.a1_one_to_one_uni.example_1.models.Orders;
import com.hibernate.a1_one_to_one_uni.example_1.repository.HumanRepository;
import com.hibernate.a1_one_to_one_uni.example_1.repository.OrdersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oneToOne")
public class SaleController {

    @Autowired
    private HumanRepository humanRepository;

    @Autowired
    private OrdersRepositories ordersRepositories;

    @Autowired
    private SaleDAO saleDAO;

    @GetMapping()
    public String getMainPage(Model model){
        model.addAttribute("human", new Human());
        model.addAttribute("orders", new Orders());
        return "hibernate/one-to-one-uni/main";
    }

    @GetMapping("/showResult")
    public String getResult(
            @ModelAttribute Human human,
            @ModelAttribute Orders orders,
            Model model){
        saleDAO.insertData(human,orders);

//        human.setHuman_orders(orders);
//        humanRepository.save(human);
//        ordersRepositories.save(orders);


//        model.addAttribute("humanList",saleDAO.getHumanList());
//        model.addAttribute("orderList",saleDAO.getOrdersList());

        return "hibernate/one-to-one-uni/result";
    }
}
