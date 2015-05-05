package com.quickblox.sample.videochatwebrtcnew.activities;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import com.quickblox.chat.QBChatService;
import com.quickblox.sample.videochatwebrtcnew.R;
import com.quickblox.sample.videochatwebrtcnew.holder.DataHolder;


/**
 * Created by tereha on 26.01.15.
 */
public class BaseLogginedUserActivity extends Activity {

    private static final String TAG = BaseLogginedUserActivity.class.getSimpleName();
    static android.app.ActionBar mActionBar;
    private Chronometer timerABWithTimer;
//    private LayoutInflater mInflater = LayoutInflater.from(this);
    private View mCustomView;
    private static Integer userID;
    private static Integer userIndex;


    public void initActionBar() {

        userID = QBChatService.getInstance().getUser().getId();
        userIndex = DataHolder.getUserIndexByID(userID);

        mActionBar = getActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater mInflater = LayoutInflater.from(this);

        mCustomView = mInflater.inflate(R.layout.actionbar_view, null);

        TextView numberOfListAB = (TextView) mCustomView.findViewById(R.id.numberOfListAB);

        TextView loginAsAB = (TextView) mCustomView.findViewById(R.id.loginAsAB);
        loginAsAB.setText(R.string.logged_in_as);

        TextView userName = (TextView) mCustomView.findViewById(R.id.userNameAB);

        if (userIndex >= 0){
            numberOfListAB.setBackgroundResource(resourceSelector(userIndex + 1));
            numberOfListAB.setText(String.valueOf(userIndex + 1));
            userName.setText(DataHolder.getUserNameByID(userID));
        }

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

    }

    public void initActionBarWithTimer() {
        mActionBar = getActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater mInflater = LayoutInflater.from(this);

        mCustomView = mInflater.inflate(R.layout.actionbar_with_timer, null);

        timerABWithTimer = (Chronometer) mCustomView.findViewById(R.id.timerABWithTimer);

        TextView loginAs = (TextView) mCustomView.findViewById(R.id.loginAsABWithTimer);
        loginAs.setText(R.string.logged_in_as);

        TextView userName = (TextView) mCustomView.findViewById(R.id.userNameABWithTimer);

        if (userIndex >= 0) {
            userName.setText(DataHolder.getUserNameByID(userID));
        }

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }

//    private static Object searchIndexLogginedUser(ArrayList<User> usersList) {
//        int indexLogginedUser = -1;
//
//        for (User usr : usersList) {
//            if (usr.getLogin().equals(CallActivity.login)) {
//                indexLogginedUser = usersList.indexOf(usr);
//                break;
//            }
//        }
//        return indexLogginedUser;
//    }

    public void startTimer() {
        timerABWithTimer.setBase(SystemClock.elapsedRealtime());
        timerABWithTimer.start();
    }

    public static int resourceSelector(int number) {
        int resStr = -1;
        switch (number) {
            case 0:
                resStr = R.drawable.shape_oval_spring_bud;
                break;
            case 1:
                resStr = R.drawable.shape_oval_orange;
                break;
            case 2:
                resStr = R.drawable.shape_oval_water_bondi_beach;
                break;
            case 3:
                resStr = R.drawable.shape_oval_blue_green;
                break;
            case 4:
                resStr = R.drawable.shape_oval_lime;
                break;
            case 5:
                resStr = R.drawable.shape_oval_mauveine;
                break;
            case 6:
                resStr = R.drawable.shape_oval_gentianaceae_blue;
                break;
            case 7:
                resStr = R.drawable.shape_oval_blue;
                break;
            case 8:
                resStr = R.drawable.shape_oval_blue_krayola;
                break;
            case 9:
                resStr = R.drawable.shape_oval_coral;
                break;
            default:
                resStr = resourceSelector(number % 10);
        }
        return resStr;
    }

    public static int selectBackgrounForOpponent(int number) {
        int resStr = -1;
        switch (number) {
            case 0:
                resStr = R.drawable.rectangle_rounded_spring_bud;
                break;
            case 1:
                resStr = R.drawable.rectangle_rounded_orange;
                break;
            case 2:
                resStr = R.drawable.rectangle_rounded_water_bondi_beach;
                break;
            case 3:
                resStr = R.drawable.rectangle_rounded_blue_green;
                break;
            case 4:
                resStr = R.drawable.rectangle_rounded_lime;
                break;
            case 5:
                resStr = R.drawable.rectangle_rounded_mauveine;
                break;
            case 6:
                resStr = R.drawable.rectangle_rounded_gentianaceae_blue;
                break;
            case 7:
                resStr = R.drawable.rectangle_rounded_blue;
                break;
            case 8:
                resStr = R.drawable.rectangle_rounded_blue_krayola;
                break;
            case 9:
                resStr = R.drawable.rectangle_rounded_coral;
                break;
            default:
                resStr = selectBackgrounForOpponent(number % 10);
        }
        return resStr;
    }

    private int selectColor (int index){
        int resStr = -1;
        switch (index) {
            case 0:
                resStr = R.color.spring_bud;
                break;
            case 1:
                resStr = R.color.orange;
                break;
            case 2:
                resStr = R.color.water_bondi_beach;
                break;
            case 3:
                resStr = R.color.blue_green;
                break;
            case 4:
                resStr = R.color.lime;
                break;
            case 5:
                resStr = R.color.mauveine;
                break;
            case 6:
                resStr = R.color.gentianaceae_blue;
                break;
            case 7:
                resStr = R.color.blue;
                break;
            case 8:
                resStr = R.color.blue_krayola;
                break;
            case 9:
                resStr = R.color.coral;
                break;
            default:
                resStr = selectColor(index % 10);
        }
        return resStr;
    }

    public Drawable setShapeBackgroundResource(TypeBackground typeBackground, int index){
        Resources res = getResources();
        Drawable background = null;

        if (typeBackground.equals(TypeBackground.OVAL)) {
            background = res.getDrawable(R.drawable.shape_oval_transparent);
        } else if (typeBackground.equals(TypeBackground.RECTANGLE)){
            background = res.getDrawable(R.drawable.rectangle_rounded_transparent);
        }


        return background;
    }

    public enum TypeBackground {
        OVAL, RECTANGLE;
    }



}




