package com.maxxitsolution.a1networkspte.DrawerFragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxxitsolution.a1networkspte.DedicatedTabbedFragments.USAFragment;
import com.maxxitsolution.a1networkspte.DedicatedTabbedFragments.AfricaFragment;
import com.maxxitsolution.a1networkspte.DedicatedTabbedFragments.AsiaFragment;
import com.maxxitsolution.a1networkspte.DedicatedTabbedFragments.EuropeFragment;
import com.maxxitsolution.a1networkspte.DedicatedTabbedFragments.NorthFragment;
import com.maxxitsolution.a1networkspte.DedicatedTabbedFragments.SouthFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DedicatedServerFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static int int_items = 6;

    public DedicatedServerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(com.maxxitsolution.a1networkspte.R.layout.fragment_dedicated_server, container, false);
        tabLayout = (TabLayout) view.findViewById(com.maxxitsolution.a1networkspte.R.id.tabs);
        viewPager = (ViewPager) view.findViewById(com.maxxitsolution.a1networkspte.R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return view;
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new AsiaFragment();
                case 1:
                    return new AfricaFragment();
                case 2:
                    return new EuropeFragment();
                case 3:
                    return new NorthFragment();
                case 4:
                    return new SouthFragment();
                case 5:
                    return new USAFragment();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Asia";
                case 1:
                    return "Africa";
                case 2:
                    return "Europe";
                case 3:
                    return "North America";
                case 4:
                    return "South America";
                case 5:
                    return "USA";
            }
            return null;
        }
    }
}
