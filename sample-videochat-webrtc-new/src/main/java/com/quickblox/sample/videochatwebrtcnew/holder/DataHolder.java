package com.quickblox.sample.videochatwebrtcnew.holder;

import android.util.Log;

import com.quickblox.sample.videochatwebrtcnew.User;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {

    private static final String TAG = DataHolder.class.getSimpleName();
    public static ArrayList<User> usersList;
    public static final String PASSWORD = "x6Bt0VDy5";


    public void setUsersList(List<User> UsersList) {
        this.usersList = usersList;
    }

    public int getUserListSize() {
        return usersList.size();
    }

    public String getUserName(int index) {
        return usersList.get(index).getFullName();
    }

    public User getUser(int index) {
        return usersList.get(index);
    }

    public User getLastQBUser() {
        return usersList.get(usersList.size() - 1);
    }

    public void addUserToList(User user) {
        usersList.add(user);
    }

    public static ArrayList<User> createUsersList() {
        usersList = new ArrayList<>();

        usersList.add(new User("User 1", "webrtc_user1", PASSWORD, 2436251));
        usersList.add(new User("User 2", "webrtc_user2", PASSWORD, 2436254));
        usersList.add(new User("User 3", "webrtc_user3", PASSWORD, 2436257));
        usersList.add(new User("User 4", "webrtc_user4", PASSWORD, 2436258));
        usersList.add(new User("User 5", "webrtc_user5", PASSWORD, 2436259));
        usersList.add(new User("User 6", "webrtc_user6", PASSWORD, 2436262));
        usersList.add(new User("User 7", "webrtc_user7", PASSWORD, 2436263));
        usersList.add(new User("User 8", "webrtc_user8", PASSWORD, 2436265));
        usersList.add(new User("User 9", "webrtc_user9", PASSWORD, 2436266));
        usersList.add(new User("User 10", "webrtc_user10", PASSWORD, 2436269));

        return usersList;
    }


    public static String getUserNameByID(Integer userID) {
        Log.d(TAG, "userID " + userID);
        for (User user : usersList) {
            Log.d(TAG, "getFullName " + user.getFullName());
            if (user.getId().equals(userID)) {
                return user.getFullName();
            }
        }
        return "User_name_unused";
    }

    public static User getUserByID(Integer userID) {
        Log.d(TAG, "userID " + userID);
        for (User user : usersList) {
            Log.d(TAG, "getFullName " + user.getFullName());
            if (user.getId().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    public static int getUserIndexByID(Integer userID) {
        Log.d(TAG, "userID " + userID);
        for (User user : usersList) {
            Log.d(TAG, "getFullName " + user.getFullName());
            if (user.getId().equals(userID)) {
                return usersList.indexOf(user);
            }
        }
        return -1;
    }

    public static int getUserIndexByFullName(String fullName) {
        Log.d(TAG, "userID " + fullName);
        for (User user : usersList) {
            Log.d(TAG, "getFullName " + user.getFullName());
            if (user.getFullName().equals(fullName)) {
                return usersList.indexOf(user);
            }
        }
        return -1;
    }
}