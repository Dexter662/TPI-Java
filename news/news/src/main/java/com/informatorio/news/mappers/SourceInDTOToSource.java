package com.informatorio.news.mappers;

import com.informatorio.news.models.Source;
import com.informatorio.news.services.dto.SourceInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SourceInDTOToSource  implements IMapper<SourceInDTO, Source>{
    @Override
    public Source map(SourceInDTO in) {
        Source source = new Source();
        source.setId(in.getId());
        source.setName(in.getName());
        source.setCode(in.getName().replaceAll(" ", "-"));
        source.setCreateAt(LocalDate.now());
        return source;
    }
}
