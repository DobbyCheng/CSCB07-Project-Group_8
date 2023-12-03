package com.example.b07project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import android.widget.EditText;

import com.example.b07project.loginandregister.loginModel;
import com.example.b07project.loginandregister.loginPresenter;
import com.example.b07project.loginandregister.login;
import com.google.firebase.database.ValueEventListener;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {
//    @Test
//    public void addition_isCorrect() {
//        assertEquals(4, 2 + 2);
//    }

    @Mock
    public loginModel mockmodel;

    @Mock
    public login mockview;

    @Captor
    public ArgumentCaptor<ValueEventListener> valueEventListenerArgumentCaptor;

    @Test
    public void testNoInput(){
        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);
        mockpresenter.studentlogin("", "");
        verify(mockview).SetOutputText("You have not put anything");
        verifyNoMoreInteractions(mockview, mockmodel);
    }

    @Test
    public void testNoUsername(){
        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);
        mockpresenter.studentlogin("aaa", "");
        verify(mockview).SetOutputText("You have not put anything");
        verifyNoMoreInteractions(mockview, mockmodel);
    }

    @Test
    public void testSuccessLogin(){
        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);
        mockpresenter.studentlogin("000", "000000");
        verify(mockmodel).studentlogin(mockpresenter, "000", "0000000", valueEventListenerArgumentCaptor.capture());
        verify(mockview).SetOutputText("Successfully Logged in");
        verifyNoMoreInteractions(mockview);
    }

    @Test
    public void testWrongPassword(){
        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);
        mockpresenter.studentlogin("000", "00000");
        verify(mockview).SetOutputText("Wrong Password");
        verifyNoMoreInteractions(mockview);
    }

    @Test
    public void testWrongUsername(){
        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);
        mockpresenter.studentlogin("0000", "000000");
        verify(mockview).SetOutputText("Wrong Password or Username");
        verifyNoMoreInteractions(mockview, mockmodel);
    }


}