package com.example.studenthomepahe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.studenthomepahe.databinding.FragmentCheckPostBinding;
import com.example.studenthomepahe.databinding.FragmentSecondBinding;
import com.example.studenthomepahe.databinding.FragmentSubmitCommentBinding;
import com.example.studenthomepahe.databinding.FragmentSubmitComplaintBinding;

public class CheckPostFragment extends Fragment {

    private FragmentCheckPostBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentCheckPostBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CheckPostFragment.this)
                        .navigate(R.id.action_checkPostFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}