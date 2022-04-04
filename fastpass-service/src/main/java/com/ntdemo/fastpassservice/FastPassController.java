package com.ntdemo.fastpassservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FastPassController {
List<FastPassCustomer> customers;

    public FastPassController() {
    customers = new ArrayList<FastPassCustomer>();
        customers.add(new FastPassCustomer("800", "Omar Zidan","614-612-334",19.50F));
        customers.add(new FastPassCustomer("8010","aOmar sZidan","614-612-334",119.50F));
        customers.add(new FastPassCustomer("8002","fOmar fZidan","614-612-334",149.50F));
        customers.add(new FastPassCustomer("8003","sOmar aZidan","614-612-334",1539.50F));

    }

    @RequestMapping(path="/fastpass", params={"fastpassid"})
    public FastPassCustomer getcustomer(@RequestParam String fastpassid  ){
        System.out.println("Fast Pass retrieved for:" + fastpassid);
        return customers.stream().filter(customer -> fastpassid.equals(customer.getFastPassId())).findAny().get();
    }
}
