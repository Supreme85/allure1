package ru.yandex.qatools.allure.storages;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.qatools.allure.model.Step;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 14.12.13
 */
public class StepStorageTest {
    private StepStorage stepStorage;

    @Before
    public void setUp() throws Exception {
        stepStorage = new StepStorage();
    }

    @Test
    public void getLastTest() throws Exception {
        Step step = stepStorage.getLast();
        assertNotNull(step);
        assertTrue(step == stepStorage.getLast());
    }

    @Test
    public void putTest() throws Exception {
        Step step = new Step();
        stepStorage.put(step);
        assertTrue(step == stepStorage.getLast());
    }

    @Test
    public void pollLastTest() throws Exception {
        Step step = stepStorage.getLast();
        assertTrue(step == stepStorage.pollLast());
        assertThat(stepStorage.get(), hasSize(1));
    }
}
