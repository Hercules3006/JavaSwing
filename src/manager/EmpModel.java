/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class EmpModel {
    private int id;
    private String name;
    private Date birthday;
    private String phone;
    private String major;
    private Boolean now;

    public EmpModel() {
    }

    public EmpModel(String name, Date birthday, String phone,String major) {
        this.name = name;
        this.birthday=birthday;
        this.phone = phone;
        this.major=major;
    }
    
     public EmpModel(int id, String name, Date birthday, String phone,String major) {
        this.id = id;
        this.name = name;
        this.birthday=birthday;
        this.phone = phone;
        this.major=major;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

public String getMajor(){
    return major;
}
    
}
