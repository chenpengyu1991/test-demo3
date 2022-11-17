package com.founder.rhip.ehr.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicHealthReportsController {

    @RequestMapping("/pulicHealth/reports")
    public String searchIndex() {
        return "rhip.ehr.report.search";
    }

    @RequestMapping("/pulicHealth/reports/sqzx")
    public String searchIndexSqzx() {
        return "rhip.ehr.report.search";
    }

}
