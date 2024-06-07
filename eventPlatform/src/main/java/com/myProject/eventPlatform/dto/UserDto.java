package com.myProject.eventPlatform.dto;


import com.myProject.eventPlatform.enumuration.role.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    //@JsonIgnore
    private Integer id;

    private String name;
    private Integer phoneNumber;
    private String mail;
    private Integer age;
    private String visibility;
    private String location;
    private String password;
    private Boolean isActive;
    private RoleEnum role;



    public UserDto(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.mail = builder.mail;
        this.age = builder.age;
        this.visibility = builder.visibility;
        this.location = builder.location;
        this.password = builder.password;
        this.isActive = builder.isActive;
    }

    public static class Builder{
        private Integer id;
        private String name;
        private Integer phoneNumber;
        private String mail;
        private Integer age;
        private String visibility;
        private String location;
        private String password;
        private Boolean isActive;


        public Builder(){ }

        public Builder(Integer id,String name, Integer phoneNumber, String mail, Integer age, String visibility, String location, String password, Boolean isActive){

            this.id = id;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.mail = mail;
            this.age = age;
            this.visibility = visibility;
            this.location = location;
            this.password = password;
            this.isActive = isActive;

        }

        public Builder id(Integer id){
            this.id=id;
            return this;
        }
        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder phoneNumber(Integer phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder mail(String mail){
            this.mail = mail;
            return this;
        }
        public Builder age(Integer age){
            this.age = age;
            return this;
        }
        public Builder visibility(String visibility){
            this.visibility = visibility;
            return this;
        }
        public Builder location(String location){
            this.location = location;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public Builder isActive(Boolean isActive){
            this.isActive = isActive;
            return this;
        }

        public UserDto build(){
            return new UserDto(this);
        }



    }

}
