package com.king.examplecrUD4.Controller;

import com.king.examplecrUD4.DAO.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud4")
public class PersonController {

    @Autowired
    private PersonDAO personDAO;

    public String index(Model model){

    }
}
