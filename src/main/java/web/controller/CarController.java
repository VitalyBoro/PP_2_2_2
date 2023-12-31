package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarServiceImpl carServiceImpl;

    @GetMapping
    public String getCarListDifferentSize (@RequestParam(value = "count", required = false)
                                                  Integer number, ModelMap model) {
        if (number == null || number > carServiceImpl.getCarListFullSize().size() - 1) {
            model.addAttribute("cars",
                    carServiceImpl.getCarListFullSize());

        } else {
            model.addAttribute("cars",
                    carServiceImpl.getCarListDifferentSize(number));
        }
        return "car";
    }
}
