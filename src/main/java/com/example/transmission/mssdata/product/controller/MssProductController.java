package com.example.transmission.mssdata.product.controller;

import com.example.transmission.mssdata.product.service.impl.MssProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MssProductController {

    @Autowired
    @Qualifier(value = "mssProductServiceImpl")
    private MssProductServiceImpl mssProductServiceImpl;

   /* @RequestMapping("/list2")
    @ResponseBody
    public Object getAllStu(){
       // return mssProductServiceImpl.getCountAll(1,);
    }
*/
   /* @RequestMapping("/list2")
    @ResponseBody
    public Integer getAllStuT(){
        return stuTService.getCountAll();
    }
*/
}
