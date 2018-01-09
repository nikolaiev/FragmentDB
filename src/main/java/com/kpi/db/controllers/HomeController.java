package com.kpi.db.controllers;

import static com.kpi.db.domain.City.KHARKIV;
import static com.kpi.db.domain.City.KYIV;
import static com.kpi.db.domain.City.LVIV;

import com.kpi.db.dao.GenTablesDao;
import com.kpi.db.dao.TablesDao;
import com.kpi.db.domain.GenTableDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

import com.kpi.db.models.ViewModel;
import com.kpi.db.service.UniversityService;

@Controller
public class HomeController {

    @Autowired
    private GenTablesDao genTablesDao;
    @Autowired
    private TablesDao tablesDao;

    @Autowired
    private UniversityService universityService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model){
        List<GenTableDTO> allGenTables = genTablesDao.getAllGenTables();
        model.addAttribute("tables", allGenTables);
        return "index";
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createPage(@ModelAttribute("view") ViewModel view, Model model){
        model.addAttribute("kyivUniversities", universityService.getUniversitiesWithGroups(KYIV));
        model.addAttribute("lvivUniversities", universityService.getUniversitiesWithGroups(LVIV));
        model.addAttribute("kharkivUniversities", universityService.getUniversitiesWithGroups(KHARKIV));
        return "create_table";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createView(@ModelAttribute("view") ViewModel view){
        tablesDao.createTable(view);
        return  "redirect:/view/"+ view.getName();
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
