package com.bryansills.studywithfriends;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.bryansills.studywithfriends.MainActivity;
import dalvik.annotation.TestTargetClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.tester.android.view.TestMenuItem;
import com.bryansills.studywithfriends.RobolectricGradleTestRunner;

import java.lang.*;
import java.lang.CharSequence;
import java.lang.Exception;
import java.lang.Override;
import java.lang.System;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    private MainActivity mainActivity;
    private DrawerLayout drawer;
    private MenuItem settingsMenuItem;
    private MenuItem helpMenuItem;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().visible().get();
        drawer = (DrawerLayout) mainActivity.findViewById(R.id.drawer);
        settingsMenuItem = new TestMenuItem(R.id.settings);
        helpMenuItem = new TestMenuItem(R.id.help);
    }

    @Test
    public void testActivity() throws Exception {
        assertTrue(mainActivity != null);
    }

    @Test
    public void settingsMenuItemShouldStartSettingsActivity() throws Exception {
        mainActivity.onOptionsItemSelected(settingsMenuItem);
        assertTrue(ShadowToast.getTextOfLatestToast().equals("Settings"));
    }

    @Test
    public void helpMenuItemShouldStartSettingsActivity() throws Exception {
        mainActivity.onOptionsItemSelected(helpMenuItem);
        assertTrue(ShadowToast.getTextOfLatestToast().equals("Help"));
    }
}