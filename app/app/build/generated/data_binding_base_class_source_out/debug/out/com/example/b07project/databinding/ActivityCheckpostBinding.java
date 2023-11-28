// Generated by view binder compiler. Do not edit!
package com.example.b07project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.b07project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCheckpostBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button cpback;

  @NonNull
  public final Button cscp;

  @NonNull
  public final Button matcp;

  @NonNull
  public final Button othcheck;

  private ActivityCheckpostBinding(@NonNull ConstraintLayout rootView, @NonNull Button cpback,
      @NonNull Button cscp, @NonNull Button matcp, @NonNull Button othcheck) {
    this.rootView = rootView;
    this.cpback = cpback;
    this.cscp = cscp;
    this.matcp = matcp;
    this.othcheck = othcheck;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCheckpostBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCheckpostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_checkpost, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCheckpostBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cpback;
      Button cpback = ViewBindings.findChildViewById(rootView, id);
      if (cpback == null) {
        break missingId;
      }

      id = R.id.cscp;
      Button cscp = ViewBindings.findChildViewById(rootView, id);
      if (cscp == null) {
        break missingId;
      }

      id = R.id.matcp;
      Button matcp = ViewBindings.findChildViewById(rootView, id);
      if (matcp == null) {
        break missingId;
      }

      id = R.id.othcheck;
      Button othcheck = ViewBindings.findChildViewById(rootView, id);
      if (othcheck == null) {
        break missingId;
      }

      return new ActivityCheckpostBinding((ConstraintLayout) rootView, cpback, cscp, matcp,
          othcheck);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
