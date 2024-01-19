package fr.donovan.exam.centrale_ish.repository;

import fr.donovan.exam.centrale_ish.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    Optional<Model> findBySlug(String slug);

}