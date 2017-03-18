package balti.myaddressapp.AdapterModule;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import balti.myaddressapp.Tab1;
import balti.myaddressapp.Tab2;
import balti.myaddressapp.Tab3;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> mTabHeader;
    public SampleFragmentPagerAdapter(FragmentManager fm, ArrayList<String> tabheader) {
        super(fm);
        this.mTabHeader = tabheader;
    }

    @Override
    public int getCount() {
        return mTabHeader.size();
    }

    @Override
    public Fragment getItem(int position) {
        // TODO Auto-generated method stub

        switch (position) {
            case 0:

                return new Tab1();
            case 1:
                return new Tab2();

            case 2:

                return new Tab3();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return mTabHeader.get(position);
    }
}
