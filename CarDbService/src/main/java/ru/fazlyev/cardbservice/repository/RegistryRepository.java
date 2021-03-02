package ru.fazlyev.cardbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fazlyev.cardbservice.domain.Registry;

public interface RegistryRepository extends JpaRepository<Registry, Long> {

}
