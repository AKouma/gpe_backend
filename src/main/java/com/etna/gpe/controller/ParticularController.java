package com.etna.gpe.controller;

import com.etna.gpe.dto.ParticularDto;
import com.etna.gpe.model.Particular;
import com.etna.gpe.service.ParticularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/particular")
public class ParticularController {

    @Autowired
    ParticularService particularService;

    @GetMapping("/all_particular")
    @ResponseStatus(HttpStatus.OK)
    List<ParticularDto> getAllParticular() {
        return particularService.getAllParticular();
    }

    @PostMapping("/create_particular")
    @ResponseStatus(HttpStatus.CREATED)
    Particular createParticular(@RequestBody ParticularDto particularDto) {
       return particularService.createOrUpdateuParticular(particularDto);
    }

    @GetMapping("/get_particular")
    @ResponseStatus(HttpStatus.OK)
    ParticularDto getParticularByEmail(@RequestParam(value = "email") String email) {
        return
                particularService.getParticularByEmail(email);
    }
    
  //todo post a requestbodyn and not delete really but put boolean to true
    @PostMapping("/delete_particulier")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    void deleteparticular(@RequestParam(value = "email") String email) {
        particularService.deleteParticular(email);
    }


}
