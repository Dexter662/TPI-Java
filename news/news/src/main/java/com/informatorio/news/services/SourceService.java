package com.informatorio.news.services;

import com.informatorio.news.exceptions.ToDoExceptions;
import com.informatorio.news.mappers.SourceInDTOToSource;
import com.informatorio.news.models.Source;
import com.informatorio.news.repositories.SourceRepository;
import com.informatorio.news.services.dto.SourceInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SourceService {

    private final SourceRepository sourceRepository;
    private final SourceInDTOToSource sourceInDTOToSource;

    public SourceService(SourceRepository sourceRepository, SourceInDTOToSource sourceInDTOToSource) {
        this.sourceRepository = sourceRepository;
        this.sourceInDTOToSource = sourceInDTOToSource;
    }

    public Source createSource(SourceInDTO sourceInDTO) {
        Source source =  sourceInDTOToSource.map(sourceInDTO);
        return this.sourceRepository.save(source);
    }

    public List<Source> findAll() {
        return (List<Source>) this.sourceRepository.findAll();
    }

    public void deleteSourceById(Long id) {
        Optional<Source> optionalSource = this.sourceRepository.findById(id);
        if (optionalSource.isEmpty()) {
            throw new ToDoExceptions("Source not found", HttpStatus.NOT_FOUND);
        }
        this.sourceRepository.deleteById(id);
    }

    public Source updateSource(Long id, SourceInDTO sourceInDTO) {
        Optional<Source> optionalSource = this.sourceRepository.findById(id);
        if (optionalSource.isEmpty()) {
            throw new ToDoExceptions("Source not found", HttpStatus.NOT_FOUND);
        }
        sourceInDTO.setId(optionalSource.get().getId());
        Source source =  sourceInDTOToSource.map(sourceInDTO);
        return this.sourceRepository.saveAndFlush(source);
    }

    public List<Source> findAllSourceByWord(String word){
        if (word.length() >= 3) {
            return sourceRepository.findAllSourceByWord(word);
        } else {
            throw new ToDoExceptions("You must enter at least 3 characters", HttpStatus.LENGTH_REQUIRED);
        }
    }
}
