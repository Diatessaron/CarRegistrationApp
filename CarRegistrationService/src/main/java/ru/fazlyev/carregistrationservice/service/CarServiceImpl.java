package ru.fazlyev.carregistrationservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.fazlyev.carregistrationservice.dto.CarDto;

@Service
public class CarServiceImpl implements CarService{
    private final RabbitTemplate rabbitTemplate;

    public CarServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void registerCar(CarDto carDto) {
        rabbitTemplate.convertAndSend("car.exchange", "car", carDto);
    }
}
