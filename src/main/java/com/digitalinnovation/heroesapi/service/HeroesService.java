package com.digitalinnovation.heroesapi.service;

import com.digitalinnovation.heroesapi.document.Heroes;
import com.digitalinnovation.heroesapi.repository.HeroesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HeroesService {

    private final HeroesRepository heroesRepository;

    public Flux<Heroes> findAll() {
        return Flux.fromIterable(this.heroesRepository.findAll());
    }

    public Mono<Heroes> findById(String id) {
        return Mono.justOrEmpty(this.heroesRepository.findById(id));
    }

    public Mono<Heroes> save(Heroes heroes) {
        return Mono.justOrEmpty(this.heroesRepository.save(heroes));
    }

    public Mono<Boolean> delete(String id) {
        heroesRepository.deleteById(id);
        return Mono.just(true);
    }
}
