package com.example.lifetrack1.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.lifetrack1.R;
import com.example.lifetrack1.adapter.TaskAdapter;
import com.example.lifetrack1.databinding.FragmentCreateTaskBinding;
import com.example.lifetrack1.model.TaskModel;
import com.example.lifetrack1.utils.App;
import com.example.lifetrack1.utils.Constants;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Calendar;


public class CreateTaskFragment extends BottomSheetDialogFragment  implements DatePickerDialog.OnDateSetListener  {
//    FragmentCreateTaskBinding binding;
//    String userTask;
//    String deadline;
//    String repeatCount;
//    NavController navController;
//    private int startYear;
//    private int startMonth;
//    private int startDay;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater());
//        return binding.getRoot();
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        initClickers();
//        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
//        binding.addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                passModelToHomeFragment();
////                userTask = binding.taskEd.getText().toString();
////                Bundle bundle = new Bundle();
////                bundle.putString(Constants.USER_TASK,userTask);
//                navController.navigate(R.id.homeFragment);
//               // Toast.makeText(requireContext(), " " + bundle.getString(Constants.USER_TASK), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//
//    }
//
//    private void initClickers() {
//        binding.addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        binding.dateTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showDialog();
//            }
//        });
//        binding.repeatTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//    }
//
//    @SuppressLint("NonConstantResourceId")
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    private void showRepeatDialog() {
//        LayoutInflater inflater = LayoutInflater.from(requireContext());
//        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.repeat_dialog,null);
//        Dialog alertDialog = new Dialog(requireContext());
//        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        alertDialog.setContentView(view);
//        alertDialog.show();
//        RadioButton neverBtn = alertDialog.findViewById(R.id.never);
//        boolean checked = ((RadioButton) view).isChecked();
//        neverBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                binding.repeatTv.setText(neverBtn.getText().toString());
//                repeatCount = neverBtn.getText().toString();
//                alertDialog.dismiss();
//
//            }
//        });
//
//        switch (view.getId()){
//            case R.id.never:
//                if(checked){
//                    binding.repeatTv.setText("Никогда");
//                }
//                alertDialog.dismiss();
//                break;
//            case R.id.every_day:
//                if (checked){
//                    binding.repeatTv.setText("Каждый день");
//                }
//                break;
//            case R.id.every_week:
//                if (checked){
//                    binding.repeatTv.setText("Каждую неделю");
//                }
//                break;
//
//            case R.id.every_month:
//                if(checked){
//                    binding.repeatTv.setText("Каждый месяц");
//                }
//                break;
//
//            case R.id.every_year:
//                binding.radioButton.everyYear.setOnClickListener(view1 -> binding.repeatTv.setText("Каждый год"));
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + view.getId());
//        }
//
//    }
//
//    private void showDialog() {
//        Calendar calendar = Calendar.getInstance();
//        startYear = calendar.get(Calendar.YEAR);
//        startMonth = calendar.get(Calendar.MONTH);
//        startDay = calendar.get(Calendar.DAY_OF_MONTH);
//
//
//
//        DatePickerDialog datePickerDialog = new DatePickerDialog(
//                requireContext(),this::onDateSet, startYear, startMonth, startDay);
//        datePickerDialog.show();
//    }
//
//    private void passModelToHomeFragment() {
//        userTask = binding.taskEd.getText().toString();
//        TaskModel taskModel = new TaskModel(userTask,deadline,repeatCount);
//        App.getInstance().getDatabase().taskDao().insert(taskModel);
//        dismiss();
//    }
//
//    @Override
//    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//        deadline = year+"."+month+"."+day;
//        binding.dateTv.setText(deadline);
//
//    }

    FragmentCreateTaskBinding binding;
    String userTask;
    String deadline;
    String repeatCount;
    private int startYear;
    private int starthMonth;
    private int startDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @org.jetbrains.annotations.NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
        fillDialog();
    }

    private void fillDialog() {
        if (getTag().equals(Constants.UPDATE)) {
            TaskModel taskModel = (TaskModel) getArguments().getSerializable(Constants.UPDATE_MODEL);

            deadline = taskModel.getDeadline();
            userTask = taskModel.getTask();
            repeatCount = taskModel.getRepeatCount();

            binding.taskEd.setText(userTask);
            binding.dateTv.setText(deadline);
            binding.repeatTv.setText(repeatCount);
        }
    }

    private void initClickers() {
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getTag().equals(Constants.UPDATE)) {
                    updateTask();
                } else {
                    insertTask();
                }
            }
        });
        binding.dateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        binding.repeatTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRepeatDialog();
            }
        });
    }

    private void updateTask() {
        TaskModel taskModel = (TaskModel) getArguments().getSerializable(Constants.UPDATE_MODEL);
        deadline = binding.dateTv.getText().toString();
        userTask = binding.taskEd.getText().toString();
        repeatCount = binding.repeatTv.getText().toString();
        TaskModel updateModel = new TaskModel(userTask, deadline, repeatCount);
        updateModel.setId(taskModel.getId());
        //App.getInstance().getDatabase().taskDao().update(updateModel);
        dismiss();
    }

    private void showRepeatDialog() {
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.repeat_dialog, null);
        Dialog alertDialog = new Dialog(requireContext());
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(view);
        alertDialog.show();
        RadioButton neverBtn = alertDialog.findViewById(R.id.never);
        RadioButton everyDayBtn = alertDialog.findViewById(R.id.every_day);
        neverBtn.setOnClickListener(view1 -> {
            binding.repeatTv.setText(neverBtn.getText().toString());
            repeatCount = neverBtn.getText().toString();
            alertDialog.dismiss();
        });
        everyDayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.repeatTv.setText(everyDayBtn.getText().toString());
                repeatCount = everyDayBtn.getText().toString();
                alertDialog.dismiss();
            }
        });

    }

    private void showDialog() {
        Calendar calendar = Calendar.getInstance();
        startYear = calendar.get(Calendar.YEAR);
        starthMonth = calendar.get(Calendar.MONTH);
        startDay = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(), this::onDateSet, startYear, starthMonth, startDay);
        datePickerDialog.show();
    }
    private boolean checkDay() {
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("dayPreferences", Context.MODE_PRIVATE);
        Calendar calendar = Calendar.getInstance();
        String currentDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String dayFromPreference = sharedPreferences.getString(Constants.CURRENT_DAY, "");
        if (currentDay.equals(dayFromPreference)) {
            sharedPreferences.edit().clear().apply();
            sharedPreferences.edit().putString(Constants.CURRENT_DAY, currentDay).apply();
            return true;
        }
        return false;
    }

    private void insertTask() {
        if (checkDay()){
            ArrayList<TaskModel> list = new ArrayList<>();
            TaskAdapter taskAdapter = new TaskAdapter(list,null);
            taskAdapter.setFillDayTrue(true);
        }
        userTask = binding.taskEd.getText().toString();
        TaskModel taskModel = new TaskModel(userTask, deadline, repeatCount);
        App.getInstance().getDatabase().taskDao().insert(taskModel);
        dismiss();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        deadline = year + "." + month + "." + day;
        binding.dateTv.setText(deadline);
    }
}