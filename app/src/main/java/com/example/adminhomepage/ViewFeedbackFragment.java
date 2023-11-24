package com.example.adminhomepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.adminhomepage.databinding.FragmentSecondBinding;
import com.example.adminhomepage.databinding.FragmentViewEventBinding;
import com.example.adminhomepage.databinding.FragmentViewFeedbackBinding;

public class ViewFeedbackFragment extends Fragment {

    private FragmentViewFeedbackBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentViewFeedbackBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonForth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ViewFeedbackFragment.this)
                        .navigate(R.id.action_viewFeedbackFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}