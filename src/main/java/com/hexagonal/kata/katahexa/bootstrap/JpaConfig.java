package com.hexagonal.kata.katahexa.bootstrap;

import com.hexagonal.kata.katahexa.infrastucture.KataRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = KataRepository.class)
public class JpaConfig {
}
