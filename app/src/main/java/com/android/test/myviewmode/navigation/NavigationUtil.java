package com.android.test.myviewmode.navigation;


import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class NavigationUtil {

    private static String TAG = "NavigationUtil";

    public static void takeAction(final Fragment f, final int fragmentId, final int actionId) {
        Observable.create(new ObservableOnSubscribe<NavController>() {
            @Override
            public void subscribe(ObservableEmitter<NavController> e) throws Exception {
                Fragment fragment = f;
                NavController navController = null;
                do {
                    FragmentManager fragmentManager = fragment.getFragmentManager();
                    if (fragmentManager != null) {
                        Fragment tf = fragmentManager.findFragmentById(fragmentId);
                        Log.d(TAG,"tf = "+tf);
                        if (tf instanceof NavHostFragment) {
                            navController = ((NavHostFragment) tf).getNavController();
                        }
                    }
                    fragment = fragment.getParentFragment();
                } while (navController == null && fragment != null);
                if (navController != null) {
                    e.onNext(navController);
                }
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<NavController>() {
            @Override
            public void accept(NavController navController) throws Exception {
                navController.navigate(actionId);
            }
        });
    }

}
