package it.sediin.testValidator.Entities;

import it.sediin.testValidator.Validator.ConditionalPackage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ConditionalPackage
public class User {

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Fiscal code is mandatory")
    private String fiscalCode;
    @NotNull(message = "Age is mandatory")
    @Min(value = 18, message = "Age must be greater than 18")
    private int age;


    private boolean hasBought;
    private String address;


    public boolean getHasBought() {
        return hasBought;
    }

    public void setHasBought(boolean hasBought) {
        this.hasBought = hasBought;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
