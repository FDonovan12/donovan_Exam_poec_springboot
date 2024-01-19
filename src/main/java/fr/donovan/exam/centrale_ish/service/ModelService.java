package fr.donovan.exam.centrale_ish.service;

import fr.donovan.exam.centrale_ish.entity.Listing;
import fr.donovan.exam.centrale_ish.entity.Model;
import fr.donovan.exam.centrale_ish.repository.ModelRepository;
import fr.donovan.exam.centrale_ish.DTO.ModelDTO;
import fr.donovan.exam.centrale_ish.exception.NotFoundCentraleIshException;
import fr.donovan.exam.centrale_ish.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ModelService implements DAOServiceInterface<Model> {

    private ModelRepository modelRepository;

    private BrandService brandService;

    public List<Model> findAll() {
        return this.modelRepository.findAll();
    }

    public Model getByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return getObjectById(id);
        } catch (NumberFormatException e) {
            return getModelBySlug(field);
        }
    }

    public Model getModelBySlug(String slug) {
        Optional<Model> optionalModel = modelRepository.findBySlug(slug);
        optionalModel.orElseThrow(() -> new NotFoundCentraleIshException("Model", "slug", slug));
        return optionalModel.get();
    }

    public Model getObjectById(Long id) {
        Optional<Model> optionalModel = modelRepository.findById(id);
        optionalModel.orElseThrow(() -> new NotFoundCentraleIshException("Model", "id", id));
        return optionalModel.get();
    }

    public Model persist(ModelDTO modelDTO) {
        return persist(modelDTO, null);
    }

    public Model persist(ModelDTO modelDTO, Long id) {
        Model model = new Model();
        if (id != null) {
            model = getObjectById(id);
        }
        model.setName(modelDTO.getName());
        model.setBrand(brandService.getObjectById(modelDTO.getBrand_id()));

        return modelRepository.saveAndFlush(model);
    }

    public ModelDTO getDTOById(Long id) {
        Model model = getObjectById(id);
        ModelDTO dto = new ModelDTO();
        // dto.setName(model.getName());
        return dto;
    }
}
