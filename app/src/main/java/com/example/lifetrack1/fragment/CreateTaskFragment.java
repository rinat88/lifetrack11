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
import android.widget.Toast;

import com.example.lifetrack1.R;
import com.example.lifetrack1.databinding.FragmentCreateTaskBinding;
import com.example.lifetrack1.utils.Constants;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class CreateTaskFragment extends BottomSheetDialogFragment {
    FragmentCreateTaskBinding binding;
    String userTask;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //  Navigation.findNavController(requireView()).navigate(R.id.createTaskFragment);
        //Bundle bundle = new Bundle();
        //bundle.putString(Constants.USER_TASK,userTask);
        CreateTaskFragment createTaskFragment = new CreateTaskFragment();
        createTaskFragment.show(requireActivity().getSupportFragmentManager(), "World");
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTask = binding.taskEd.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.USER_TASK,userTask);
                navController.navigate(R.id.homeFragment,bundle);
                Toast.makeText(requireContext(), " " + bundle.getString(Constants.USER_TASK), Toast.LENGTH_SHORT).show();
            }
        });

    }
}