package com.android.test.myviewmode.navigation;

import android.content.Context;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;

public class JNavigationUtil {
    private static String TAG = "JNavigationUtil";

    public static NavController inject(Fragment fragment, int hostResId, int graphResId) {
        NavController navController = null;
        try {
            NavHostFragment navHostFragment = (NavHostFragment) fragment.getChildFragmentManager().findFragmentById(hostResId);
            // setup custom navigator
            Navigator navigator = new FragmentNavigator(fragment.getContext(), navHostFragment.getChildFragmentManager(), hostResId);
            navController = navHostFragment.getNavController();
            navController.getNavigatorProvider().addNavigator(navigator);
            // set navigation graph
            navController.setGraph(graphResId);
        } catch (Exception ex) {
            Log.e(TAG, "inject: " + ex.getMessage());
        }
        return navController;
    }

    public static NavController injectKeep(Fragment fragment, int hostResId, int graphResId) {
        NavController navController = null;
        try {
            NavHostFragment navHostFragment = (NavHostFragment) fragment.getChildFragmentManager().findFragmentById(hostResId);
            // setup custom navigator
            Navigator navigator = new KeepStateNavigator(fragment.getContext(), navHostFragment.getChildFragmentManager(), hostResId);
            navController = navHostFragment.getNavController();
            navController.getNavigatorProvider().addNavigator(navigator);
            // set navigation graph
            navController.setGraph(graphResId);
        } catch (Exception ex) {
            Log.e(TAG, "inject: " + ex.getMessage());
        }
        return navController;
    }

    public static NavController injectFragNavigator(Context context, FragmentManager fragmentManager, int hostResId, int graphResId) {
        NavController navController = null;
        try {
            NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(hostResId);
            // setup custom navigator
            Navigator navigator = new FragmentNavigator(context, navHostFragment.getChildFragmentManager(), hostResId);
            navController = navHostFragment.getNavController();
            navController.getNavigatorProvider().addNavigator(navigator);
            // set navigation graph
            navController.setGraph(graphResId);
        } catch (Exception ex) {
            Log.e(TAG, "injectFragNavigator: " + ex.getMessage());
        }
        return navController;
    }

    public static NavController injectKeepNavigator(Context context, FragmentManager fragmentManager, int hostResId, int graphResId) {
        NavController navController = null;
        try {
            NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(hostResId);
            // setup custom navigator
            Navigator navigator = new KeepStateNavigator(context, navHostFragment.getChildFragmentManager(), hostResId);
            navController = navHostFragment.getNavController();
            navController.getNavigatorProvider().addNavigator(navigator);
            // set navigation graph
            navController.setGraph(graphResId);
        } catch (Exception ex) {
            Log.e(TAG, "injectKeepNavigator: " + ex.getMessage());
        }
        return navController;
    }
}
