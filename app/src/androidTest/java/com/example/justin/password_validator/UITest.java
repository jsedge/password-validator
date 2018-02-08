package com.example.justin.password_validator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by justin on 07/02/18.
 */

@RunWith(AndroidJUnit4.class)
public class UITest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    private MainActivity mainActivity;
    @Before
    public  void init(){
        mainActivity = mActivityRule.getActivity();
    }

    @Test
    public void tooShort(){

        onView(withId(R.id.passBox)).perform(typeText("Short1"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Invalid Password")));
    }

    @Test
    public void tooLong(){
        onView(withId(R.id.passBox)).perform(typeText("ThisHasWayTooManyCharactersForItToBeAUsablePassword4000"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Invalid Password")));
    }

    @Test
    public void noNumbers(){
        onView(withId(R.id.passBox)).perform(typeText("ThisShouldHaveNumbers"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Invalid Password")));
    }

    @Test
    public void notPassword(){
        onView(withId(R.id.passBox)).perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Invalid Password")));
    }

    @Test
    public void noUpper(){
        onView(withId(R.id.passBox)).perform(typeText("alllowerpassword35"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Invalid Password")));
    }

    @Test
    public void noLower(){
        onView(withId(R.id.passBox)).perform(typeText("ALLUPPERPASSWORD99"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Invalid Password")));
    }

    @Test
    public void goodPassword(){
        onView(withId(R.id.passBox)).perform(typeText("ThisIsGood1"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Valid Password")));
    }
}
