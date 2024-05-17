package com.myProject.eventPlatform.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommunityDto {

    private Integer id;
    private String title;
    private String details;
    private String address;
    private CategoryDto category;
    private Boolean isActive;

    public CommunityDto(Builder builder){
        this.id = builder.id;
        this.title = builder.title;
        this.details = builder.details;
        this.address = builder.address;
        this.category = builder.category;
        this.isActive = builder.isActive;
    }

    public static class Builder{
        private Integer id;
        private String title;
        private String details;
        private String address;
        private CategoryDto category;
        private Boolean isActive;

        public Builder(){}

        public Builder(Integer id, String title, String details, String address, CategoryDto category, Boolean isActive){
            this.id = id;
            this.title = title;
            this.details = details;
            this.address = address;
            this.category = category;
            this.isActive = isActive;

        }

        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder details(String details){
            this.details = details;
            return this;
        }
        public Builder address(String address){
            this.address = address;
            return this;
        }
        public Builder category(CategoryDto category){
            this.category = category;
            return this;
        }
        public Builder isActive(Boolean isActive){
            this.isActive = isActive;
            return this;
        }
        public CommunityDto build(){
            return new CommunityDto(this);
        }




    }


}
