package com.example.lifetrack1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.lifetrack1.R;
import com.example.lifetrack1.adapter.TaskAdapter;
import com.example.lifetrack1.custom_dialog.Custom_dialog;
import com.example.lifetrack1.databinding.FragmentHomeBinding;
import com.example.lifetrack1.databinding.RepeatDialogBinding;
import com.example.lifetrack1.model.TaskModel;
import com.example.lifetrack1.utils.App;
import com.example.lifetrack1.utils.Constants;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        Custom_dialog custom_dialog = new Custom_dialog(requireContext());
        binding.addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_createTaskFragment);
            }
        });
       // initRecycler();
    }

//    private void initRecycler() {
//        App.getInstance().getDatabase().taskDao().getAll().observe(getViewLifecycleOwner(),taskModels -> {
//            TaskAdapter taskAdapter = new TaskAdapter((ArrayList<TaskModel>)taskModels);
//            binding.taskRecycler.setAdapter(taskAdapter);
//        });
//
//    }


    private void getData() {
        if(getArguments()!=null){
            String title = getArguments().getString(Constants.USER_TASK);
        }
    }
}
