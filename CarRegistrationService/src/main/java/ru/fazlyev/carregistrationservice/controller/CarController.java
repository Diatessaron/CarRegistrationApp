package ru.fazlyev.carregistrationservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.fazlyev.carregistrationservice.dto.CarDto;
import ru.fazlyev.carregistrationservice.service.CarService;

@Controller
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars")
    public String saveRegistration(@RequestBody CarDto carDto){
        carService.registerCar(carDto);
        return "success";
    }
}
