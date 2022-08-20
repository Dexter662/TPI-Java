package com.informatorio.news.controllers;

import com.informatorio.news.models.Source;
import com.informatorio.news.services.SourceService;
import com.informatorio.news.services.dto.SourceInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sources")
public class SourceController {

    private final SourceService sourceService;

    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @PostMapping
    public Source createSource(@Valid @RequestBody SourceInDTO sourceInDTO) {
        return  this.sourceService.createSource(sourceInDTO);
    }

    @GetMapping
    public List<Source> findAll(){
        return this.sourceService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSource(@PathVariable("id") Long id) {
        this.sourceService.deleteSourceById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> updateSource(@PathVariable("id") Long id, @Valid @RequestBody SourceInDTO sourceInDTO) {
        this.sourceService.updateSource(id, sourceInDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/{word}")
    public List<Source> search(@PathVariable("word") String word){
        return this.sourceService.findAllSourceByWord(word);
    }
}
