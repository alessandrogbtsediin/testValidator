package it.sediin.testValidator.Entities;

import it.sediin.testValidator.Validator.ConditionalPackage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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


    @Pattern(regexp = strongPasswordRegex, message = "Your password is not strong enough")
    private String password;
    @Pattern(regexp = codiceFiscaleRegex, message = "Codice fiscale is wrong")
    private String codiceFiscale;
    @Pattern(regexp = emailRegex, message = "Not a correct email format")
    private String email;
    @Pattern(regexp = phoneRegex, message = "Not a correct phone format")
    private String phone;


    private boolean hasBought;
    private String creditCard;
    private String address;


    private MultipartFile[] documents;


    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHasBought() {
        return hasBought;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

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

    public MultipartFile[] getDocuments() {
        return documents;
    }

    public void setDocuments(MultipartFile[] documents) {
        this.documents = documents;
    }

    public static final String strongPasswordRegex = "^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=\\D*\\d).{8,}$";
    public static final String codiceFiscaleRegex = "(?i)^(?:[A-Z][AEIOU][AEIOUX]|[AEIOU]X{2}|[B-DF-HJ-NP-TV-Z]{2}[A-Z]){2}(?:[\\dLMNP-V]{2}(?:[A-EHLMPR-T](?:[04LQ][1-9MNP-V]|[15MR][\\dLMNP-V]|[26NS][0-8LMNP-U])|[DHPS][37PT][0L]|[ACELMRT][37PT][01LM]|[AC-EHLMPR-T][26NS][9V])|(?:[02468LNQSU][048LQU]|[13579MPRTV][26NS])B[26NS][9V])(?:[A-MZ][1-9MNP-V][\\dLMNP-V]{2}|[A-M][0L](?:[1-9MNP-V][\\dLMNP-V]|[0L][1-9MNP-V]))[A-Z]$";
    public static final String emailRegex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    public static final String phoneRegex = "^\\d{10}$";


}
