package org.serratec.ONG.Service;

import org.serratec.ONG.DTO.CaracteriscaRequestDto;
import org.serratec.ONG.DTO.CaracteriscaResponseDto;
import org.serratec.ONG.Domain.Animal;
import org.serratec.ONG.Domain.Caracterisca;
import org.serratec.ONG.Exception.ResourceNotFoundException;
import org.serratec.ONG.Repository.AnimalRepository;
import org.serratec.ONG.Repository.CaracteriscaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaracteriscaService {

    @Autowired
    private CaracteriscaRepository caracteriscaRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public List<CaracteriscaResponseDto> findAll() {
        return caracteriscaRepository.findAll()
                .stream()
                .map(CaracteriscaResponseDto::from)
                .collect(Collectors.toList());
    }

    public CaracteriscaResponseDto findById(Long id) {
        Caracterisca c = caracteriscaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Característica", id));
        return CaracteriscaResponseDto.from(c);
    }

    public CaracteriscaResponseDto salvar(CaracteriscaRequestDto dto) {
        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new ResourceNotFoundException("Animal", dto.getAnimalId()));

        Caracterisca c = new Caracterisca();
        c.setAnimal(animal);
        c.setPorte(dto.getPorte());
        c.setPeso(dto.getPeso());
        c.setAltura(dto.getAltura());
        c.setPelo(dto.getPelo());
        c.setIdade(dto.getIdade());
        return CaracteriscaResponseDto.from(caracteriscaRepository.save(c));
    }

    public CaracteriscaResponseDto atualizar(Long id, CaracteriscaRequestDto dto) {
        Caracterisca c = caracteriscaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Característica", id));
        c.setPorte(dto.getPorte());
        c.setPeso(dto.getPeso());
        c.setAltura(dto.getAltura());
        c.setPelo(dto.getPelo());
        c.setIdade(dto.getIdade());
        return CaracteriscaResponseDto.from(caracteriscaRepository.save(c));
    }

    public void delete(Long id) {
        if (!caracteriscaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Característica", id);
        }
        caracteriscaRepository.deleteById(id);
    }
}
