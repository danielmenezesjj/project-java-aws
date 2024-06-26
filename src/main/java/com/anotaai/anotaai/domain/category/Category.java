package com.anotaai.anotaai.domain.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {


    @Id
    private String id;

    private String title;
    private String description;

    private String ownerId;


    public Category (CategoryDTO data){
        this.title = data.title();
        this.description = data.description();
        this.ownerId = data.ownerId();
    }

    public void update(CategoryDTO dto){
        if(dto.title() != null){
            this.title = dto.title();
        }
        if(dto.description() != null){
            this.description = dto.description();
        }
    }


}
