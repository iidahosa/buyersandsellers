package com.bns.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class UserShipping {
	@GenericGenerator(
            name = "UserShippingSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "userShippingSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
	@Id
    @GeneratedValue(generator = "UserShippingSequenceGenerator")
private Long id;
private String userShippingName;
private String userShippingStreet1;
private String userShippingStreet2;
private String userShippingCity;
private String userShippingState;
private String userShippingCountry;
private String userShippingZipcode;
private boolean userShippingDefault;


@ManyToOne
@JoinColumn(name = "user_id")
private UserAcc userAcc;


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getUserShippingName() {
	return userShippingName;
}


public void setUserShippingName(String userShippingName) {
	this.userShippingName = userShippingName;
}


public String getUserShippingStreet1() {
	return userShippingStreet1;
}


public void setUserShippingStreet1(String userShippingStreet1) {
	this.userShippingStreet1 = userShippingStreet1;
}


public String getUserShippingStreet2() {
	return userShippingStreet2;
}


public void setUserShippingStreet2(String userShippingStreet2) {
	this.userShippingStreet2 = userShippingStreet2;
}


public String getUserShippingCity() {
	return userShippingCity;
}


public void setUserShippingCity(String userShippingCity) {
	this.userShippingCity = userShippingCity;
}


public String getUserShippingState() {
	return userShippingState;
}


public void setUserShippingState(String userShippingState) {
	this.userShippingState = userShippingState;
}


public String getUserShippingCountry() {
	return userShippingCountry;
}


public void setUserShippingCountry(String userShippingCountry) {
	this.userShippingCountry = userShippingCountry;
}


public String getUserShippingZipcode() {
	return userShippingZipcode;
}


public void setUserShippingZipcode(String userShippingZipcode) {
	this.userShippingZipcode = userShippingZipcode;
}


public boolean isUserShippingDefault() {
	return userShippingDefault;
}


public void setUserShippingDefault(boolean userShippingDefault) {
	this.userShippingDefault = userShippingDefault;
}


public UserAcc getUserAcc() {
	return userAcc;
}


public void setUserAcc(UserAcc userAcc) {
	this.userAcc = userAcc;
}

}
