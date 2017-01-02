package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;
import java.util.Scanner;

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
    public String home (Model model, String category) {
        List<Purchase> purchaseList;
        if (category != null) {
            purchaseList = purchases.findByCategory(category);
        }
        else {
            purchaseList = (List<Purchase>) purchases.findAll();
        }
        model.addAttribute("purchases", purchaseList);
        return "home";
    }//end home()

    @PostConstruct
    public void init()throws Exception {
        if(customers.count() == 0){
            File f = new File("customers.csv");
            Scanner scan = new Scanner(f);
            while(scan.hasNext()){
                String x = scan.nextLine();
                String[] y = x.split(",");
                Customer c = new Customer(y[0], y[1]);
                customers.save(c);
            }
        }
        if(purchases.count() == 0){
            File g = new File("purchases.csv");
            Scanner scan = new Scanner(g);
            while(scan.hasNext()){
                String x = scan.nextLine();
                String[]y = x.split(",");
                Purchase z = new Purchase(y[1], y[2], y[3], y[4], customers.findOne(Integer.parseInt(y[0])));
                purchases.save(z);
            }
        }

    }//end init()


























}//end class PurchasesController
