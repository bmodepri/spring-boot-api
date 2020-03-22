package de.restaurantsearch.restaurant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String address;
    private String description;
    private String typeOfFood;
    private String createDate;
    private String createUser;
    private String lastModifiedDate;
    private String lastModifiedUser;

    protected Restaurant() {}

    public Restaurant(String name, String address, String description, String typeOfFood,
                      String createDate, String createUser, String lastModifiedDate, String lastModifiedUser) {

        this.name = name;
        this.address = address;
        this.description = description;
        this.typeOfFood = typeOfFood;
        this.createDate = createDate;
        this.createUser = createUser;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;

    }

    @Override
    public String toString() {
        return String.format(
                "Restaurant[id=%d, address='%s', description='%s', typeOfFood='%s', " +
                        "createDate='%s', lastModifiedDate]='%s', lastModifiedUser='%s'",
                id, name, address, description, typeOfFood, createDate,
                createUser, lastModifiedDate, lastModifiedUser);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

}
