/*
package com.example.transmission.msdata.product.controller;

import com.example.transmission.msdata.product.service.impl.MsProductServiceImpl;
import com.example.transmission.mssdata.autodata.service.impl.AutoDataServiceImpl;
import com.example.transmission.mssdata.product.service.impl.MssProductServiceImpl;
import com.example.transmission.mssdata.product.service.impl.MssProductStoreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class CallProductNewController {
    @Autowired
    @Qualifier(value = "mssProductServiceImpl")
    private MssProductServiceImpl mssProductServiceImpl;
    @Autowired
    private MsProductServiceImpl msProductServiceImpl;

    @RequestMapping("/callProductNew")
    @ResponseBody
    public void saveAllProductStore() {
        //获取accountid总数
        List<Integer> accountIdList = mssProductServiceImpl.getAccountIdList();
        log.info(accountIdList.size() + "=========accountid总数");
        for (Integer accountId : accountIdList) {
            log.info(accountId + "call++++执行accountid");
            //msProductService.callProductNew(accountId);
        }
    }

}
*/
