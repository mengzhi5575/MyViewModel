package com.android.test.myviewmode.navigation;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;

import kotlin.jvm.internal.Intrinsics;


@Navigator.Name("keep_state_fragment")
public class KeepStateNavigator extends FragmentNavigator {

    private final Context mContext;
    private final FragmentManager mManager;
    private final int mContainerId;

    @Nullable
    @Override
    public NavDestination navigate(@NonNull FragmentNavigator.Destination destination, @Nullable Bundle args, @Nullable NavOptions navOptions, @Nullable Navigator.Extras navigatorExtras) {
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        String tag = String.valueOf(destination.getId());

        FragmentTransaction transaction = this.mManager.beginTransaction();
        Fragment currentFragment = this.mManager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }

        Fragment fragment = this.mManager.findFragmentByTag(tag);
        if (fragment == null) {
            String var10 = destination.getClassName();
            Intrinsics.checkExpressionValueIsNotNull(var10, "destination.className");
            String className = var10;
            fragment = this.instantiateFragment(this.mContext, this.mManager, className, args);
            transaction.add(this.mContainerId, fragment, tag);
        } else {
            transaction.show(fragment);
        }

        transaction.setPrimaryNavigationFragment(fragment);
        transaction.setReorderingAllowed(true);
        transaction.commit();
        return destination;
    }

    public KeepStateNavigator(@NonNull Context context, @NonNull FragmentManager manager, int containerId) {
        super(context, manager, containerId);
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(manager, "mManager");
        this.mContext = context;
        this.mManager = manager;
        this.mContainerId = containerId;
    }
}
