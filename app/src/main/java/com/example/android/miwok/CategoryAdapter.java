package com.example.android.miwok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CategoryAdapter extends FragmentStatePagerAdapter {

    public CategoryAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new NumbersFragment();
                break;
            case 1:
                fragment = new FamilyFragment();
                break;
            case 2:
                fragment = new ColorsFragment();
                break;
            default:
                fragment = new PhrasesFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence charSequence = "";
        switch (position){
            case 0:
                charSequence = "Numbers";
                break;
            case 1:
                charSequence = "Family";
                break;
            case 2:
                charSequence = "Colors";
                break;
            default:
                charSequence = "Phrases";
                break;
        }
        return charSequence;
    }
}
