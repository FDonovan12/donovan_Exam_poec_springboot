package fr.donovan.exam.centrale_ish.repository;

import java.util.Optional;

public interface EntityNameRepository<T> {

    Optional<T> findByName(String name);

}
