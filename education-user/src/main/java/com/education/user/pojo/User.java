package com.education.user.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    private String username;
    private String userpwd;
    private String usernick;
    private String userphone;
    private String useremail;
    private Date registertime;
    private Integer roleid;
    private String birthday;
    private String sex;
    private String image;
    private Integer balance;

}
