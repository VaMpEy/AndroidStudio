package tfreese.de.candleburn;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class uiTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void performInput(){
        String mLengthString = "20";
        String mDiameterString = "3.5";

        //Select stearin as material
        onView(withId(R.id.spinnerMaterial)).perform(click());
        onData(anything()).atPosition(0).perform(click());

        //Input candle-data
        onView(withId(R.id.editTextLength)).perform(typeText(mLengthString));
        onView(withId(R.id.editTextDiameter)).perform(typeText(mDiameterString), closeSoftKeyboard());

        //calcBtn.click()
        onView(withId(R.id.buttonCalc)).perform(click());
    }

    @Test
    public void calcDuration() {
        String mDurationResult = "27:31";

        //Assert durationResult = 27:31
        onView(withId(R.id.editTextBurningTime)).check(matches(withText(mDurationResult)));
    }

    @Test
    public void resetForm(){
        //resetBtn.click() => every input-field cleared
        onView(withId(R.id.buttonReset)).perform(click());
        onView(withId(R.id.editTextBurningTime)).check(matches(withText("")));
        onView(withId(R.id.editTextDiameter)).check(matches(withText("")));
        onView(withId(R.id.editTextLength)).check(matches(withText("")));
    }
}
