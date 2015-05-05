package com.quickblox.sample.videochatwebrtcnew;

import com.quickblox.users.model.QBUser;

public class User extends QBUser {

    public User(String fullName, String login, String password, int id) {
        super.fullName = fullName;
        super.login = login;
        super.password = password;
        super.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//
//        User user = (User) o;
//
//        if (userNumber != user.userNumber) return false;
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + userNumber;
//        return result;
//    }


}
