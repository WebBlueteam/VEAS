package com.ailab.veas.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ailab.veas.fragment.MePostFragment;
import com.ailab.veas.fragment.SettingFragment;
import com.ailab.veas.fragment.NewsFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			return new NewsFragment();
		case 1:
			return new NewsFragment();
		case 2:
			return new SettingFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}
