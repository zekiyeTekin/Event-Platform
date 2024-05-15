package com.myProject.eventPlatform.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.myProject.eventPlatform.enumuration.category.TypeEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {

    private Integer id;
    @JsonIgnore
    private TypeEnum type;
    private Boolean isActive;

    public String getTypeName() {
        return type.getName();
    }

    public CategoryDto(Builder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.isActive = builder.isActive;
    }

    public static class Builder {
        private Integer id;
        private TypeEnum type;
        private Boolean isActive;


    public Builder() {
    }

    public Builder(Integer id, TypeEnum type, Boolean isActive) {
        this.id = id;
        this.type = type;
        this.isActive = isActive;
    }

    public Builder id(Integer id) {
        this.id = id;
        return this;
    }

    public Builder type(TypeEnum type) {
        this.type = type;
        return this;
    }

    public Builder isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public CategoryDto build() {
        return new CategoryDto(this);
    }


}
}