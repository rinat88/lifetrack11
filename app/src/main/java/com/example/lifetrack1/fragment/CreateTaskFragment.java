package com.example.lifetrack1.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifetrack1.R;
import com.example.lifetrack1.databinding.FragmentCreateTaskBinding;
import com.example.lifetrack1.utils.Constants;


public class CreateTaskFragment extends Fragment {
    FragmentCreateTaskBinding binding;
    String userTask;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment);
        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Navigation.findNavController(requireView()).navigate(R.id.createTaskFragment);
      Bundle bundle = new Bundle();
      bundle.putString(Constants.USER_TASK,userTask);
      Navigation.findNavController(requireView()).navigate(R.id.homeFragment,bundle);

}}