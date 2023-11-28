// Generated by view binder compiler. Do not edit!
package com.example.b07project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.b07project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPostannouncementBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button annback;

  @NonNull
  public final EditText anncontent;

  @NonNull
  public final Button annsub;

  @NonNull
  public final EditText anntitle;

  @NonNull
  public final TextView textView13;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView textView16;

  private ActivityPostannouncementBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button annback, @NonNull EditText anncontent, @NonNull Button annsub,
      @NonNull EditText anntitle, @NonNull TextView textView13, @NonNull TextView textView15,
      @NonNull TextView textView16) {
    this.rootView = rootView;
    this.annback = annback;
    this.anncontent = anncontent;
    this.annsub = annsub;
    this.anntitle = anntitle;
    this.textView13 = textView13;
    this.textView15 = textView15;
    this.textView16 = textView16;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPostannouncementBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPostannouncementBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_postannouncement, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPostannouncementBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.annback;
      Button annback = ViewBindings.findChildViewById(rootView, id);
      if (annback == null) {
        break missingId;
      }

      id = R.id.anncontent;
      EditText anncontent = ViewBindings.findChildViewById(rootView, id);
      if (anncontent == null) {
        break missingId;
      }

      id = R.id.annsub;
      Button annsub = ViewBindings.findChildViewById(rootView, id);
      if (annsub == null) {
        break missingId;
      }

      id = R.id.anntitle;
      EditText anntitle = ViewBindings.findChildViewById(rootView, id);
      if (anntitle == null) {
        break missingId;
      }

      id = R.id.textView13;
      TextView textView13 = ViewBindings.findChildViewById(rootView, id);
      if (textView13 == null) {
        break missingId;
      }

      id = R.id.textView15;
      TextView textView15 = ViewBindings.findChildViewById(rootView, id);
      if (textView15 == null) {
        break missingId;
      }

      id = R.id.textView16;
      TextView textView16 = ViewBindings.findChildViewById(rootView, id);
      if (textView16 == null) {
        break missingId;
      }

      return new ActivityPostannouncementBinding((ConstraintLayout) rootView, annback, anncontent,
          annsub, anntitle, textView13, textView15, textView16);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
