package ua.com.vertex.util;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StringUtilTest {

    @Spy
    StringUtil stringUtil;

    @Mock
    StringHelper helper;

    @BeforeClass
    public static void init() {
        System.out.println("in BeforeClass method");
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        System.out.println("In Before method");

        stringUtil = new StringUtil();
        stringUtil.setHelper(helper);
    }

    @Test
    public void revertShouldNotThrowExceptionOnNull() {
        stringUtil.revert(null);
    }

    @Ignore("Does not implemented")
    @Test
    public void revertShouldReturnNullOnNull() {
        String result = stringUtil.revert(null);
        assertNull("Probably implementation was changed.", result);
    }

    @Test
    public void deleteAllShouldNotThrowExceptionOnNull() {
        stringUtil.deleteAll(null, null);
//        stringUtil.deleteAll("", null);
//        stringUtil.deleteAll(null, "f");
    }

    @Test
    public void deleteAllShouldDeleteAllOccurance() {
        when(helper.deleteAll(anyString(), anyString())).thenReturn("tst");

        String result = stringUtil.deleteAll("TEst test teST", "e");
        assertThat("", result, not(containsString("e")));
//        stringUtil.deleteAll("", null);
//        stringUtil.deleteAll(null, "f");
    }

    @Test
    public void deleteAllShouldCallApproptiateMethod() {
        stringUtil.deleteAll("", "test");
        verify(helper).deleteAll("", "test");
    }

    @Test(expected = NullPointerException.class)
    public void deleteAllShouldThrowExceptionOnNullAndNotNull() {
        when(helper.deleteAll(eq(null), anyString()))
                .thenThrow(new NullPointerException());

        stringUtil.deleteAll(null, "111");
//        verify(helper).deleteAll("","test");
        fail("Method behavior has been changed");
    }


    @After
    public void tearDown() throws Exception {
        System.out.println("In After method");
    }

    @AfterClass
    public static void forget() {
        System.out.println("In AfterClass method");
    }

}