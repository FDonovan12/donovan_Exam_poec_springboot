package fr.donovan.exam.centrale_ish.service;

import fr.donovan.exam.centrale_ish.entity.Brand;
import fr.donovan.exam.centrale_ish.entity.Listing;
import fr.donovan.exam.centrale_ish.repository.ListingRepository;
import fr.donovan.exam.centrale_ish.DTO.ListingDTO;
import fr.donovan.exam.centrale_ish.exception.NotFoundCentraleIshException;
import fr.donovan.exam.centrale_ish.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ListingService implements DAOServiceInterface<Listing> {

    private ListingRepository listingRepository;

    private ModelService modelService;

    private UserService userService;

    public List<Listing> findAll() {
        return this.listingRepository.findAll();
    }

    public Listing getByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return getObjectById(id);
        } catch (NumberFormatException e) {
            return getListingBySlug(field);
        }
    }

    public Listing getListingBySlug(String slug) {
        Optional<Listing> optionalListing = listingRepository.findBySlug(slug);
        optionalListing.orElseThrow(() -> new NotFoundCentraleIshException("Listing", "slug", slug));
        return optionalListing.get();
    }

    public Listing getObjectById(Long id) {
        Optional<Listing> optionalListing = listingRepository.findById(id);
        optionalListing.orElseThrow(() -> new NotFoundCentraleIshException("Listing", "id", id));
        return optionalListing.get();
    }

    public Listing persist(ListingDTO listingDTO) {
        return persist(listingDTO, null);
    }

    public Listing persist(ListingDTO listingDTO, Long id) {
        Listing listing = new Listing();
        if (id != null) {
            listing = getObjectById(id);
        }
        listing.setTitle(listingDTO.getTitle());
        listing.setDescription(listingDTO.getDescription());
        listing.setProducedYear(listing.getProducedYear());
        listing.setMileage(listingDTO.getMileage());
        listing.setPrice(listingDTO.getPrice()*100);
        listing.setImage(listingDTO.getImage());
        Long userId = (long) (Math.random()*1799+1);
        listing.setUser(userService.getObjectById(userId));
        listing.setModel(modelService.getObjectById(listingDTO.getModel_id()));

        return listingRepository.saveAndFlush(listing);
    }

    public ListingDTO getDTOById(Long id) {
        Listing listing = getObjectById(id);
        ListingDTO dto = new ListingDTO();
        // dto.setName(listing.getName());
        return dto;
    }
    public List<Listing> findLastListings() {
        return listingRepository.findTop12ByOrderByCreatedAtDesc();
    }
}
