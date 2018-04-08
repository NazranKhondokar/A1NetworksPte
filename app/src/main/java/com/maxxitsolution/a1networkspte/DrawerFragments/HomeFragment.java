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

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.maxxitsolution.a1networkspte.TabbedFragment.CloudServerFragment;
import com.maxxitsolution.a1networkspte.TabbedFragment.VOS3000Fragment;

import com.maxxitsolution.a1networkspte.TabbedFragment.VOIPTerminationFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private SliderLayout mDemoSlider;
    private int[] galleryImages = new int[3];
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static int int_items = 3;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(com.maxxitsolution.a1networkspte.R.layout.fragment_home, container, false);
        tabLayout = (TabLayout) view.findViewById(com.maxxitsolution.a1networkspte.R.id.tabs);
        viewPager = (ViewPager) view.findViewById(com.maxxitsolution.a1networkspte.R.id.viewpager);
        mDemoSlider = view.findViewById(com.maxxitsolution.a1networkspte.R.id.slider);

        galleryImages[0] = com.maxxitsolution.a1networkspte.R.drawable.one;
        galleryImages[1] = com.maxxitsolution.a1networkspte.R.drawable.two;
        galleryImages[2] = com.maxxitsolution.a1networkspte.R.drawable.three;

        for (int i = 0; i < galleryImages.length; i++) {
            DefaultSliderView defaultSliderView = new DefaultSliderView(getActivity());
            // initialize a SliderLayout
            defaultSliderView
                    .image(galleryImages[i])
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            mDemoSlider.addSlider(defaultSliderView);
        }

        //  mDemoSlider.setPresetTransformer(SliderLayout.Transformer.ZoomOut);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        //  mDemoSlider.setDuration(4000);

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
                    return new VOIPTerminationFragment();
                case 1:
                    return new CloudServerFragment();
                case 2:
                    return new VOS3000Fragment();
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
                    return "Termination";
                case 1:
                    return "Cloud Server";
                case 2:
                    return "VOS 3000";
            }
            return null;
        }
    }
}
