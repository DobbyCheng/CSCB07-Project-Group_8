package com.example.b07project;

import static com.google.firebase.database.InternalHelpers.createDataSnapshot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;


import android.text.Editable;
import android.widget.EditText;


import com.example.b07project.loginandregister.loginModel;
import com.example.b07project.loginandregister.loginPresenter;
import com.example.b07project.loginandregister.login;
import com.google.firebase.database.DataSnapshot;
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


    @Mock
    EditText user;
    @Mock
    Editable usernm;

    @Mock
    EditText pass;
    @Mock
    Editable passwd;

    @Captor
    public ArgumentCaptor<ValueEventListener> valueEventListenerCaptor;

    @Test
    public void testNoEntry(){
        when(mockview.getUsername()).thenReturn("");
        when(mockview.getPassword()).thenReturn("");
        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);
        mockpresenter.studentlogin();
        verify(mockview).getUsername();
        verify(mockview).getPassword();
        verify(mockview).SetOutputText("You have not put anything");
        verifyNoMoreInteractions(mockview, mockmodel);
    }

    @Test
    public void testNoUsername(){
        when(mockview.getUsername()).thenReturn("");
        when(mockview.getPassword()).thenReturn("000000");
        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);
        mockpresenter.studentlogin();
        verify(mockview).getUsername();
        verify(mockview).getPassword();
        verify(mockview).SetOutputText("You have not put anything");
        verifyNoMoreInteractions(mockview, mockmodel);
    }

    @Test
    public void testNoPassword(){
        when(mockview.getUsername()).thenReturn("000");
        when(mockview.getPassword()).thenReturn("");
        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);
        mockpresenter.studentlogin();
        verify(mockview).getUsername();
        verify(mockview).getPassword();
        verify(mockview).SetOutputText("You have not put anything");
        verifyNoMoreInteractions(mockview, mockmodel);
    }


//    @Test
//    public void testSuccessLogin(){
//        when(mockview.getUsername()).thenReturn("validUsername");
//        when(mockview.getPassword()).thenReturn("validPassword");
//
//
//        // Mock the snapshot to simulate existing user
//        DataSnapshot mockSnapshot = mock(DataSnapshot.class);
//        DataSnapshot mockChildSnapshot = mock(DataSnapshot.class);
//
//        when(mockSnapshot.hasChild("validUsername")).thenReturn(true);
//        when(mockSnapshot.child("validUsername")).thenReturn(mockChildSnapshot);
//        when(mockChildSnapshot.child("password").getValue()).thenReturn("validPassword");
//
//        loginPresenter presenter = new loginPresenter(mockview, mockmodel);
//        // Call the login method
//        presenter.studentlogin();
//
//        verify(mockmodel).studentlogin(eq("validUsername"), eq("validPassword"), any(ValueEventListener.class));
//
//        // Capture the ValueEventLister for further verification
//        ArgumentCaptor<ValueEventListener> valueEventListenerCaptor = ArgumentCaptor.forClass(ValueEventListener.class);
//        verify(mockmodel).studentlogin(eq("validUsername"), eq("validPassword"), valueEventListenerCaptor.capture());
//        valueEventListenerCaptor.getValue().onDataChange(mockSnapshot);
//
//        // Simulate onDataChange with the mockSnapshot
//        verify(mockview).openstudentpage();
//
//        // Verify that SetOutputText, saveinformation, and openstudentpage are called
//        verify(mockview).SetOutputText("Successfully Logged in");


//        when(mockview.getUsername()).thenReturn("000");
//        when(mockview.getPassword()).thenReturn("000000");
//
//        DataSnapshot mockSnapshot = mock(DataSnapshot.class);
//        when(mockSnapshot.hasChild("000")).thenReturn(true);
//        when(mockSnapshot.child("000").child("password").getValue()).thenReturn("000000");
//        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);
//        mockpresenter.studentlogin();
//        verify(mockmodel).studentlogin(eq("000"), eq("000000"), any(ValueEventListener.class));
//        ArgumentCaptor<ValueEventListener> valueEventListenerCaptor = ArgumentCaptor.forClass(ValueEventListener.class);
//        verify(mockmodel).studentlogin(eq("000"), eq("000000"), valueEventListenerCaptor.capture());
//        valueEventListenerCaptor.getValue().onDataChange(mockSnapshot);
//
//        // Verify that SetOutputText, saveinformation, and openstudentpage are called
//        verify(mockview).SetOutputText("Successfully Logged in");
//        verify(mockview).openstudentpage();




//
    @Test
    public void testWrongPassword(){
        when(mockview.getUsername()).thenReturn("000");
        when(mockview.getPassword()).thenReturn("0000000");
        DataSnapshot mockSnapshot = mock(DataSnapshot.class);
        DataSnapshot mockChildSnapshot = mock(DataSnapshot.class);

        when(mockSnapshot.hasChild("000")).thenReturn(true);
        when(mockSnapshot.child("000")).thenReturn(mockChildSnapshot);
        when(mockChildSnapshot.child("password").getValue()).thenReturn("000000");
        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);
        mockpresenter.studentlogin();
        verify(mockmodel).studentlogin(eq("000"), eq("0000000"), any(ValueEventListener.class));

        ArgumentCaptor<ValueEventListener> valueEventListenerCaptor = ArgumentCaptor.forClass(ValueEventListener.class);
        verify(mockmodel).studentlogin(eq("000"), eq("0000000"), valueEventListenerCaptor.capture());
        valueEventListenerCaptor.getValue().onDataChange(mockSnapshot);
        verify(mockview).SetOutputText("Wrong Password");
    }
//
//    @Test
//    public void testWrongUsername(){
//        when(mockview.getUsername()).thenReturn("000");
//        when(mockview.getPassword()).thenReturn("000000");
//        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);
//        mockpresenter.studentlogin();
//        verify(mockmodel).studentlogin(eq("000"), eq("000000"), valueEventListenerCaptor.capture());
//        valueEventListenerCaptor.getValue().onDataChange(createEmptyDataSnapshot());
//        verify(mockview).SetOutputText("Wrong Password or Username");
//    }

    public DataSnapshot createEmptyDataSnapshot() {
        return mock(DataSnapshot.class);
    }
}