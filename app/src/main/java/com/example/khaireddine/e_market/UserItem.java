package com.example.khaireddine.e_market;

/**
 * Created by Ramzi on 07/01/2018.
 */

public class UserItem {
        private int id;
        private String user;
        private  String phone;
        private  String card;
        private  String email;
        private  String password;

        public UserItem() {}

        public int getId() {return this.id;}
        public void setId(int id) {this.id = id;}

        public String getuser() {return this.user;}
        public void setUser(String user) {this.user =user;}

        public String getcard() {return this.card;}
        public void setcard(String card) {this.card =card;}

        public String getamail() {return this.email;}
            public void setemail(String email) {this.email = email;}

        public void setPhone(String phone) {this.phone =phone;}
        public String getPhone() {return this.phone;}

        public void setPassword(String password) {this.password =password;}
        public String getPassword() {return this.password;}
    }