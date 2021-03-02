package ru.fazlyev.cardbservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fazlyev.cardbservice.domain.Registry;
import ru.fazlyev.cardbservice.dto.CarDto;
import ru.fazlyev.cardbservice.repository.RegistryRepository;

@Service
public class DbService {
    private final RegistryRepository registryRepository;

    public DbService(RegistryRepository registryRepository) {
        this.registryRepository = registryRepository;
    }

    @RabbitListener(queues = "car.queue")
    @Transactional()
    public void registerCar(CarDto carDto){
        final Registry registry = Registry.builder()
                .brand(carDto.getBrand())
                .color(carDto.getColor())
                .build();

        registryRepository.save(registry);
    }
}
