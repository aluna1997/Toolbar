package com.unam.aluna.toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import layout.FirstFragment;
import layout.FourthFragment;
import layout.SecondFragment;
import layout.ThirdFragment;

/**
 * Created by aluna on 27/06/17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private int numDeTabs;



    public ViewPagerAdapter(FragmentManager fm,int numDeTabs) {
        super(fm);
        this.numDeTabs = numDeTabs;
    }

    //Saber que tab esta seleccionado
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            case 3:
                return new FourthFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numDeTabs;
    }
}
