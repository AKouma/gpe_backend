package com.etna.gpe.controller;

import com.etna.gpe.dto.ParticularDto;
import com.etna.gpe.service.ParticularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/particular")
public class ParticularController {

    @Autowired
    ParticularService particularService;

    @GetMapping("/all_particular")
    List<ParticularDto> getAllParticular() {
        return particularService.getAllParticular();
    }

    @PostMapping("/create_particular")
    void createParticular(@RequestBody ParticularDto particularDto) {
        particularService.createOrUpdateuParticular(particularDto.getParticularEmail(
                ), particularDto.getParticularPassword(), particularDto.getParticularName(),
                particularDto.getParticularFirstName(),
                particularDto.getParticularPhonenumber());
    }

    @GetMapping("/get_particular")
    ParticularDto getParticularByEmail(@RequestParam(value = "email") String email) {
        return
                particularService.getParticularByEmail(email);
    }

    @PostMapping("/delete_particulier")
    void deleteparticular(@RequestParam(value = "email") String email) {
        particularService.deleteParticular(email);
    }


}
