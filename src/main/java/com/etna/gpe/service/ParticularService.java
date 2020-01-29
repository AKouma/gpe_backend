package com.etna.gpe.service;

import com.etna.gpe.dto.ParticularDto;
import com.etna.gpe.model.Particular;
import com.etna.gpe.repository.ParticularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ParticularService {

    @Autowired
    ParticularRepository particularRepository;

    public List<ParticularDto> getAllParticular() {
        Iterator<Particular> it = particularRepository.findAll().iterator();
        List<ParticularDto> particulars = new ArrayList<>();
        while (it.hasNext()) {
            ParticularDto dto = new ParticularDto(it.next());
            particulars.add(dto);
        }
        return particulars;
    }

    public ParticularDto getparticularById(ParticularDto dto) {
        Optional<Particular> optional = particularRepository.findById(dto.getParticularId());
        return optional.map(ParticularDto::new).orElseGet(ParticularDto::new);
    }


    public ParticularDto getParticularByEmail(@NonNull String email) {
        Particular particular = particularRepository.findParticularByParticularEmail(email);
        return particular != null ? new ParticularDto(particular) : new ParticularDto();
    }

    public ParticularDto getParticularByEmailAndPassword(@NonNull String email, @NonNull String password) {
        Particular particular = particularRepository.findParticularByparticularEmailAndParticularPassword(email, password);
        return particular != null ? new ParticularDto(particular) : new ParticularDto();
    }


    public void createOrUpdateuParticular(@NonNull String email, @NonNull String
            password, String name, String firstName, String phoneNumber) {
        ParticularDto
                dto = getParticularByEmail(email);
        boolean isNew = false;
        if (dto == null) {
            dto = new ParticularDto();
            isNew = true;
        }
        setDto(email, password, name,
                firstName, phoneNumber, dto);
        particularRepository.save(new Particular(dto,
                isNew));
    }

    public void deleteParticular(@NonNull String email) {
        ParticularDto dtoToDelete = getParticularByEmail(email);
        if (dtoToDelete != null){
			dtoToDelete.setParticularIsDeleted(true);
			particularRepository.save(new Particular(dtoToDelete,false));
		}
    }


    private void setDto(@NonNull String email, @NonNull String password, String name,
                        String firstName, String phoneNumber, ParticularDto dto) {
        dto.setParticularEmail(email);
        dto.setParticularPassword(password);
        dto.setParticularName(name != null ? name : dto.getParticularName());
        dto.setParticularFirstName(firstName != null ? firstName : dto.getParticularFirstName());
        dto.setParticularPhonenumber(phoneNumber != null ? phoneNumber : dto.getParticularPhonenumber());
    }

}
