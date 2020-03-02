/*
    Created by O.Shalaevsky on 25.02.2020
*/

package com.shaprj.spring.demoweb.model.admin;

import com.shaprj.spring.demoweb.model.admin.converter.user.IsMaleConverter;
import org.apache.commons.lang.builder.EqualsBuilder;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="s_users_sequence")
    @SequenceGenerator(name="s_users_sequence", sequenceName="s_users_sequence", allocationSize=1)
    private long id;
    private String name;
    private String login;

    @Column(name = "is_male")
    @Convert(converter = IsMaleConverter.class)
    private Boolean isMale;
    private int age;
    private String passwordHash;

    public User(){}

    public User(long id, String name, String login, Boolean isMale, int age, String passwordHash){

        this.id = id;
        this.name = name;
        this.login = login;
        this.isMale = isMale;
        this.age = age;
        this.passwordHash = passwordHash;
    }

    public User(int id, String name, String login, int age){
        this.id = id;
        this.name = name;
        this.login = login;
        this.age = age;
    }

    public User(int id, String name, String login, int age, Boolean isMale){
        this.id = id;
        this.name = name;
        this.login = login;
        this.age = age;
        this.isMale = isMale;
    }

    public User(String name, String login, int age, Boolean isMale){
        this.name = name;
        this.login = login;
        this.age = age;
        this.isMale = isMale;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(id) +
                Objects.hashCode(name) +
                Objects.hashCode(login) +
                Objects.hashCode(isMale) +
                age +
                Objects.hashCode(passwordHash);
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o == null){
            return false;
        }

        if(o.getClass() != getClass()){
            return false;
        }

        User u = (User)o;

        return new EqualsBuilder()
                .append(id, u.id)
                .append(name, u.name)
                .append(login, u.login)
                .append(isMale, u.isMale)
                .append(age, u.age)
                .append(passwordHash, u.passwordHash)
                .isEquals();
    }

    @Override
    public String toString(){
        return String.format("User [id = %d, name = %s, login = %s, sex = %s, age = %d]",
                id, name, login, isMale ? "MALE" : "FEMALE", age);
    }
}
