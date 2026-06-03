package com.example.sentinela2.repository;

import com.example.sentinela2.model.TelefoneSuspeito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TelefoneSuspeitoRepository extends JpaRepository<TelefoneSuspeito, Long> {

    Optional<TelefoneSuspeito> findByNumero(String numero);

    // os 5 mais denunciados para a lista "recentes"
    @Query("SELECT t FROM TelefoneSuspeito t ORDER BY t.totalDenuncias DESC")
    List<TelefoneSuspeito> findTop5ByOrderByTotalDenunciasDesc();
}