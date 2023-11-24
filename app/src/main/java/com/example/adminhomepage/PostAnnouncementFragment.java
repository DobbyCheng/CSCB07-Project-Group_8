package com.example.adminhomepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.adminhomepage.databinding.FragmentPostAnnouncementBinding;
import com.example.adminhomepage.databinding.FragmentScheduleEventBinding;
import com.example.adminhomepage.databinding.FragmentSecondBinding;

public class PostAnnouncementFragment extends Fragment {

    private FragmentPostAnnouncementBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentPostAnnouncementBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSeventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PostAnnouncementFragment.this)
                        .navigate(R.id.action_postAnnouncementFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}