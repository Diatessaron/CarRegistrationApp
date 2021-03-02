package ru.fazlyev.carregistrationservice.service;

import ru.fazlyev.carregistrationservice.dto.CarDto;

public interface CarService {
    void registerCar(CarDto carDto);
}
