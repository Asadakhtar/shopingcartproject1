 package com.asad.Shoppingcart.modal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Authorization implements Serializable {

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private String authid;
private String uid;
private String  role;
public String getAuthid() {
	return authid;
}
public void setAuthid(String authid) {
	this.authid = authid;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
}
