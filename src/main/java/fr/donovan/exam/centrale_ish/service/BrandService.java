package fr.donovan.exam.centrale_ish.service;

import fr.donovan.exam.centrale_ish.entity.Brand;
import fr.donovan.exam.centrale_ish.entity.Model;
import fr.donovan.exam.centrale_ish.repository.BrandRepository;
import fr.donovan.exam.centrale_ish.DTO.BrandDTO;
import fr.donovan.exam.centrale_ish.exception.NotFoundCentraleIshException;
import fr.donovan.exam.centrale_ish.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandService implements DAOServiceInterface<Brand> {

    private BrandRepository brandRepository;

    public List<Brand> findAll() {
        return this.brandRepository.findAll();
    }

    public Brand getByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return getObjectById(id);
        } catch (NumberFormatException e) {
            return getBrandBySlug(field);
        }
    }

    public Brand getBrandBySlug(String slug) {
        Optional<Brand> optionalBrand = brandRepository.findBySlug(slug);
        optionalBrand.orElseThrow(() -> new NotFoundCentraleIshException("Brand", "slug", slug));
        return optionalBrand.get();
    }

    public Brand getObjectById(Long id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        optionalBrand.orElseThrow(() -> new NotFoundCentraleIshException("Brand", "id", id));
        return optionalBrand.get();
    }

    public Brand persist(BrandDTO brandDTO) {
        return persist(brandDTO, null);
    }

    public Brand persist(BrandDTO brandDTO, Long id) {
        Brand brand = new Brand();
        if (id != null) {
            brand = getObjectById(id);
        }
        brand.setName(brandDTO.getName());

        return brandRepository.saveAndFlush(brand);
    }

    public BrandDTO getDTOById(Long id) {
        Brand brand = getObjectById(id);
        BrandDTO dto = new BrandDTO();
        dto.setName(brand.getName());
        return dto;
    }
}
