package com.example.codobuxajay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public class PojoData implements Serializable {


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("message")
    @Expose
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("employee_name")
        @Expose
        private String employeeName;
        @SerializedName("employee_salary")
        @Expose
        private BigInteger employeeSalary;
        @SerializedName("employee_age")
        @Expose
        private Integer employeeAge;
        @SerializedName("profile_image")
        @Expose
        private String profileImage;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public BigInteger getEmployeeSalary() {
            return employeeSalary;
        }

        public void setEmployeeSalary(BigInteger employeeSalary) {
            this.employeeSalary = employeeSalary;
        }

        public Integer getEmployeeAge() {
            return employeeAge;
        }

        public void setEmployeeAge(Integer employeeAge) {
            this.employeeAge = employeeAge;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

    }

}
