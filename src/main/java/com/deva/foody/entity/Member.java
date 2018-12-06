package com.deva.foody.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(generator = "member_generator")
    @SequenceGenerator(
            name = "member_generator",
            sequenceName = "member_sequence",
            initialValue = 1000
    )
    @ApiModelProperty(notes = "The database generated Member id")
    private Long Id;

//    @NotBlank
    @Column(name = "first_name", columnDefinition = "text")
    @ApiModelProperty(notes = "First name of the Member")
    private String firstName;

//    @NotBlank
    @Column(name = "last_name", columnDefinition = "text")
    @ApiModelProperty(notes = "Last name of the Member")
    private String lastName;

//    @NotNull
    @Column(name = "gender")
    @ApiModelProperty(notes = "Gender of the member")
    private String gender;

//    @NotNull
    @Column(name = "mobile_no")
    @ApiModelProperty(notes = "Mobile no of the member")
    private String mobileNo;

//    @NotNull
    @Column(name = "email_id")
    @ApiModelProperty(notes = "Email id of the member")
    @Email(message = "Please provide a valid e-mail")
//    @NotEmpty(message = "Please provide an e-mail")
    private String emailId;

//    @NotBlank
    @Column(name = "user_name")
    @ApiModelProperty(notes = "User name of the member")
    private String username;

//    @NotBlank
    @Column(name = "password")
    @ApiModelProperty(notes = "Password of the member")
    private String password;

//    @NotNull
    @Column(name = "dob")
    @ApiModelProperty(notes = "Date of birth of the member")
    private String dob;

}
