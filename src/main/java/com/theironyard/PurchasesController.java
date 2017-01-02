package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dlocke on 12/23/16.
 */
@Controller
public class PurchasesController {
    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository purchases;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home (HttpSession session, Model model, String date, String creditCard, String ccv, String category) {
        List<Purchase> purchaseList;
        if (category != null) {
            purchaseList = purchases.findByCategory(category);
        }
        else {
            purchaseList = (List<Purchase>) purchases.findAll();
        }
        model.addAttribute("purchases", purchaseList);
        return "home";
    }

    @PostConstruct
    public void init(){

    }


























}//end class PurchasesController
