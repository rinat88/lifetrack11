package com.example.lifetrack1.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.lifetrack1.OnLongItemListener;
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

public class HomeFragment extends Fragment  {
    FragmentHomeBinding binding;
    TaskAdapter taskAdapter;

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
//        getData();
//        Custom_dialog custom_dialog = new Custom_dialog(requireContext());
        binding.addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateTaskFragment createTaskFragment = new CreateTaskFragment();
                createTaskFragment.show(requireActivity().getSupportFragmentManager(), "World");
            }
        });
        initRecycler();

    }


    private void initRecycler() {
        App.getInstance().getDatabase().taskDao().getAll().observe(getViewLifecycleOwner(), taskModels -> {
            taskAdapter = new TaskAdapter((ArrayList<TaskModel>) taskModels, new OnLongItemListener() {
                @Override
                public void itemLongClick(TaskModel taskModel) {
                    new AlertDialog.Builder(requireContext()).setTitle("Удалить?").setMessage("Вы Уверенны?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    App.getInstance().getDatabase().taskDao().delete(taskModel);
                                    Log.e("tag", "onClick: " + taskModel);
                                }
                            }).setNegativeButton(android.R.string.no, null).show();

                }

                @Override
                public void itemClick(TaskModel model) {


                }
            });
            binding.taskRecycler.setAdapter(taskAdapter);
        });

    }



//    private void getData() {
//        if(getArguments()!=null){
//            String title = getArguments().getString(Constants.USER_TASK);
//        }
//    }
}
