package ru.gvozdilin.waterCounter.controllers;

import freemarker.log.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gvozdilin.waterCounter.dao.HouseDao;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    HouseDao houseDao;


    private static freemarker.log.Logger log = Logger.getLogger(MainController.class.getName());

    @GetMapping("/main")
    public String getAllHouses(Model model){
        model.addAttribute("allHouses", houseDao.findAllHouses());
        model.addAttribute("maxIndication", houseDao.showMaxIndication());

        return("main");
    }


    @PostMapping("/createHouse")
    public String createHouse(HttpServletRequest request) {
        String address = request.getParameter("address");
        log.info(address);
        houseDao.createHouse(address);
        return("redirect:/main");
    }

    @PostMapping("/deleteHouse")
    public String deleteHouse(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("deleteHouse"));
        log.info("deleted house id = " + id);
        houseDao.deleteHouse(id);
        return("redirect:/main");
    }

    @PostMapping("/createMeter")
    public String createMeter(HttpServletRequest request) {
        Long id  = Long.parseLong(request.getParameter("createMeter"));
        Long indication = Long.parseLong(request.getParameter("valueOfMeter"));
        log.info("house id " + id + " indication " + indication);
            if(indication>0){
            houseDao.setIndication(indication, id);
           }
        else {

              }



        return("redirect:/main");
    }


    @PostMapping("/showMaxIndication")
    public String showMaxIndication(){


        return("redirect:/main");
    }

}
