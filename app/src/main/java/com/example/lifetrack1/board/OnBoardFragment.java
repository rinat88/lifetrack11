package com.example.lifetrack1.board;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifetrack1.R;
import com.example.lifetrack1.databinding.FragmentOnBoardBinding;
import com.example.lifetrack1.utils.Constants;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;


public class OnBoardFragment extends Fragment {
    FragmentOnBoardBinding binding;
    DotsIndicator dotsIndicator;
    ViewPager viewPager;
    BoardAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewPager();
        dotsIndicator = (DotsIndicator) binding.dotsIndicator;
        viewPager = (ViewPager) binding.viewpager;
        adapter = new BoardAdapter(getParentFragmentManager());
        viewPager.setAdapter(adapter);
        dotsIndicator.setViewPager(viewPager);
        viewPager.setAdapter(adapter);
        dotsIndicator.setViewPager(viewPager);
        openHomeFragment();
        isOpenHome();
    }

    private void isOpenHome() {
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(Constants.BOARD_PREF,
                Context.MODE_PRIVATE);
        boolean isShow = sharedPreferences.getBoolean(Constants.IS_SHOW_BOARD,false);
        if(isShow){
            Navigation.findNavController(requireView()).navigate(R.id.homeFragment);
        }
    }

    private void openHomeFragment() {
        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireView()).navigate(R.id.homeFragment);
                SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(Constants.
                        BOARD_PREF, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean(Constants.IS_SHOW_BOARD,true).apply();

            }
        });
    }

    private void setupViewPager() {
        binding.viewpager.setAdapter(new BoardAdapter(requireActivity().getSupportFragmentManager()));
    }
}