package ru.fazlyev.carregistrationservice.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fazlyev.carregistrationservice.dto.CarDto;
import ru.fazlyev.carregistrationservice.service.CarService;

@Controller
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars")
    public String saveRegistration(@RequestParam String brand, String color){
        CarDto carDto = CarDto.builder()
                .brand(brand)
                .color(color)
                .build();

        carService.registerCar(carDto);
        return "success";
    }
}
