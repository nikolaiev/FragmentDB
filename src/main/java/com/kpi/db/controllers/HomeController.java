package com.kpi.db.controllers;

import com.kpi.db.dao.GenTablesDao;
import com.kpi.db.dao.TablesDao;
import com.kpi.db.models.GetTableDTO;
import com.kpi.db.models.TableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    GenTablesDao genTablesDao;

    @Autowired
    TablesDao tablesDao;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model){
        List<GetTableDTO> allGenTables = genTablesDao.getAllGenTables();
        model.addAttribute("tables", allGenTables);
        return "index";
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createPage(Model model){
        List<TableDTO> allTables = tablesDao.getAllTables();
        model.addAttribute("tables",allTables);
        return  "create_table";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createView(Model model,
                             @RequestParam(value = "view_name") String viewName,
                             @RequestParam("query") String query,
                             @RequestParam("author") String author,
                             @RequestParam("info") String info){

        tablesDao.createTable(viewName, query, author, info);
        return  "redirect:/view/"+viewName;
    }

    @RequestMapping(value = "/view/{view_name}",method = RequestMethod.GET)
    public String getView(Model model, @PathVariable("view_name") String viewName){
        List<Map<String, Object>> tableContent = tablesDao.getTableContent(viewName);
        System.out.println(tableContent);

        model.addAttribute("tableName",viewName);
        model.addAttribute("tableRows",tableContent);
        return  "view_table";
    }
}
