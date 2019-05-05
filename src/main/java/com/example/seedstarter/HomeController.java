package com.example.seedstarter;

import com.example.seedstarter.entities.*;
import com.example.seedstarter.services.SeedRowService;
import com.example.seedstarter.services.SeedStarterService;
import com.example.seedstarter.services.VarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private SeedStarterService seedStarterService;

    @Autowired
    private VarietyService varietyService;

    @Autowired
    private SeedRowService seedRowService;

    @ModelAttribute("allTypes")
    public List<Type> populateTypes() {
        return Arrays.asList(Type.ALL);
    }

    @ModelAttribute("allFeatures")
    public List<Feature> populateFeatures() {
        return Arrays.asList(Feature.ALL);
    }

    @ModelAttribute("allVarieties")
    public List<Variety> populateVarieties() {
        return varietyService.findAll();
    }

    @ModelAttribute("allSeedStarters")
    public List<SeedStarter> populateSeedStarters() {
        return seedStarterService.findAll();
    }

    @RequestMapping({"/", "/seedstartermng"})
    public String showSeedstarters(SeedStarter seedStarter, Model model) {
        seedStarter.setDatePlanted(LocalDate.now());
        return "seedstartermng";
    }

    @RequestMapping(value = "/seedstartermng", params = {"save"})
    public String saveSeedstarter(SeedStarter seedStarter,
                                  BindingResult bindingResult,
                                  ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "seedstartermng";
        }

        seedStarterService.add(seedStarter);
        seedRowService.addAll(seedStarter.getSeedRows(), seedStarter);

        model.clear();
        return "redirect:/seedstartermng";
    }

    @RequestMapping(value = "/seedstartermng", params = {"addRow"})
    public String addRow(SeedStarter seedStarter,
                         BindingResult bindingResult) {
        seedStarter.getSeedRows().add(new SeedRow());
        return "seedstartermng";
    }

    @RequestMapping(value = "/seedstartermng", params = {"removeRow"})
    public String removeRow(
            SeedStarter seedStarter,
            BindingResult bindingResult,
            HttpServletRequest request) {
        int rowId = Integer.valueOf(request.getParameter("removeRow"));
        seedStarter.getSeedRows().remove(rowId);
        return "seedstartermng";
    }
}
