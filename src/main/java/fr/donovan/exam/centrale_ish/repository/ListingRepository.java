package fr.donovan.exam.centrale_ish.repository;

import fr.donovan.exam.centrale_ish.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

    Optional<Listing> findBySlug(String slug);

    List<Listing> findTop12ByOrderByCreatedAtDesc();
}