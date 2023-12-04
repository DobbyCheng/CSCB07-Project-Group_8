package com.example.b07project;

import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.example.b07project.loginandregister.adminloginModel;
import com.example.b07project.loginandregister.adminloginPresenter;
import com.example.b07project.loginandregister.adminloginView;
import com.example.b07project.loginandregister.loginModel;
import com.example.b07project.loginandregister.loginPresenter;
import com.example.b07project.loginandregister.loginView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterUnitTest {
//    @Test
//    public void addition_isCorrect() {
//        assertEquals(4, 2 + 2);
//    }

    @Mock
    public loginModel mockmodel;

    @Mock
    public loginView mockview;

    @Mock
    public adminloginView admin_mockview;

    @Mock
    public adminloginModel admin_mockmodel;

    @Captor
    public ArgumentCaptor<ValueEventListener> valueEventListenerCaptor;

    @Test
    public void testNoEntrystudent(){
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
    public void testNoUsernamestudent(){
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
    public void testNoPasswordstudent(){
        when(mockview.getUsername()).thenReturn("000");
        when(mockview.getPassword()).thenReturn("");
        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);
        mockpresenter.studentlogin();
        verify(mockview).getUsername();
        verify(mockview).getPassword();
        verify(mockview).SetOutputText("You have not put anything");
        verifyNoMoreInteractions(mockview, mockmodel);
    }

    @Test
    public void testNonemptystudent() {
        when(mockview.getUsername()).thenReturn("validUsername");
        when(mockview.getPassword()).thenReturn("validPassword");
        loginPresenter presenter = new loginPresenter(mockview, mockmodel);
        // Call the login method
        presenter.studentlogin();
        verify(mockmodel).studentlogin(eq("validUsername"), eq("validPassword"), eq(presenter));
    }

    @Test
    public void testSuccessLoginstudent() {
        loginPresenter presenter = new loginPresenter(mockview, mockmodel);

        DataSnapshot mockSnapshot = mock(DataSnapshot.class);
        DataSnapshot mockChildSnapshot = mock(DataSnapshot.class);
        DataSnapshot mockGrandChildSnapshot = mock(DataSnapshot.class);

        when(mockSnapshot.hasChild("11")).thenReturn(true);
        when(mockSnapshot.child("11")).thenReturn(mockChildSnapshot);
        when(mockChildSnapshot.child("password")).thenReturn(mockGrandChildSnapshot);
        when(mockGrandChildSnapshot.getValue()).thenReturn("123");

        presenter.userStuff("11", "123", mockSnapshot);

        verify(mockview).SetOutputText("Successfully Logged in");
        ArgumentCaptor<String> valueEventListenerCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockmodel).saveinformation(eq("11"), valueEventListenerCaptor.capture());
        verify(mockview).openstudentpage();
    }

    @Test
    public void testWrongUsernamestudent(){
        DataSnapshot mockSnapshot = mock(DataSnapshot.class);
        when(mockSnapshot.hasChild("11")).thenReturn(false);

        loginPresenter presenter = new loginPresenter(mockview, mockmodel);
        presenter.userStuff("11", "123", mockSnapshot);
        verify(mockview).SetOutputText("Wrong Password or Username");
        verifyNoMoreInteractions(mockview, mockmodel);
    }

    @Test
    public void testWrongPasswordstudent() {
        DataSnapshot mockSnapshot = mock(DataSnapshot.class);
        DataSnapshot mockChildSnapshot = mock(DataSnapshot.class);
        DataSnapshot mockGrandChildSnapshot = mock(DataSnapshot.class);

        when(mockSnapshot.hasChild("11")).thenReturn(true);
        when(mockSnapshot.child("11")).thenReturn(mockChildSnapshot);
        when(mockChildSnapshot.child("password")).thenReturn(mockGrandChildSnapshot);
        when(mockGrandChildSnapshot.getValue()).thenReturn("123");

        loginPresenter mockpresenter = new loginPresenter(mockview, mockmodel);

        mockpresenter.userStuff("11", "12", mockSnapshot);

        verify(mockview).SetOutputText("Wrong Password");
        verifyNoMoreInteractions(mockview, mockmodel);
    }

    @Test
    public void testNoEntryadmin(){
        when(admin_mockview.getUsername()).thenReturn("");
        when(admin_mockview.getPassword()).thenReturn("");
        adminloginPresenter admin_mockpresenter = new adminloginPresenter(admin_mockview, admin_mockmodel);
        admin_mockpresenter.adminlogin();
        verify(admin_mockview).getUsername();
        verify(admin_mockview).getPassword();
        verify(admin_mockview).SetOutputText("You have not put anything");
        verifyNoMoreInteractions(admin_mockview, admin_mockview);
    }

    @Test
    public void testNoUsernameadmin(){
        when(admin_mockview.getUsername()).thenReturn("");
        when(admin_mockview.getPassword()).thenReturn("000000");
        adminloginPresenter admin_mockpresenter = new adminloginPresenter(admin_mockview, admin_mockmodel);
        admin_mockpresenter.adminlogin();
        verify(admin_mockview).getUsername();
        verify(admin_mockview).getPassword();
        verify(admin_mockview).SetOutputText("You have not put anything");
        verifyNoMoreInteractions(admin_mockview, admin_mockmodel);
    }

    @Test
    public void testNoPasswordadmin(){
        when(admin_mockview.getUsername()).thenReturn("000");
        when(admin_mockview.getPassword()).thenReturn("");
        adminloginPresenter admin_mockpresenter = new adminloginPresenter(admin_mockview, admin_mockmodel);
        admin_mockpresenter.adminlogin();
        verify(admin_mockview).getUsername();
        verify(admin_mockview).getPassword();
        verify(admin_mockview).SetOutputText("You have not put anything");
        verifyNoMoreInteractions(admin_mockview, admin_mockmodel);
    }

    @Test
    public void testNonemptyadmin() {
        when(admin_mockview.getUsername()).thenReturn("validUsername");
        when(admin_mockview.getPassword()).thenReturn("validPassword");
        adminloginPresenter admin_mockpresenter = new adminloginPresenter(admin_mockview, admin_mockmodel);
        admin_mockpresenter.adminlogin();
        verify(admin_mockmodel).adminlogin(eq("validUsername"), eq("validPassword"), eq(admin_mockpresenter));
    }

    @Test
    public void testSuccessLoginadmin() {
        adminloginPresenter admin_mockpresenter = new adminloginPresenter(admin_mockview, admin_mockmodel);

        DataSnapshot mockSnapshot = mock(DataSnapshot.class);
        DataSnapshot mockChildSnapshot = mock(DataSnapshot.class);
        DataSnapshot mockGrandChildSnapshot = mock(DataSnapshot.class);

        when(mockSnapshot.hasChild("11")).thenReturn(true);
        when(mockSnapshot.child("11")).thenReturn(mockChildSnapshot);
        when(mockChildSnapshot.child("password")).thenReturn(mockGrandChildSnapshot);
        when(mockGrandChildSnapshot.getValue()).thenReturn("123");

        admin_mockpresenter.userStuff("11", "123", mockSnapshot);

        verify(admin_mockview).SetOutputText("Successfully Logged in");
        ArgumentCaptor<String> valueEventListenerCaptor = ArgumentCaptor.forClass(String.class);
        verify(admin_mockmodel).saveinformation(eq("11"), valueEventListenerCaptor.capture());
        verify(admin_mockview).openadminpage();
    }

    @Test
    public void testWrongUsernameadmin(){
        DataSnapshot mockSnapshot = mock(DataSnapshot.class);
        when(mockSnapshot.hasChild("11")).thenReturn(false);

        adminloginPresenter admin_mockpresenter = new adminloginPresenter(admin_mockview, admin_mockmodel);
        admin_mockpresenter.userStuff("11", "123", mockSnapshot);
        verify(admin_mockview).SetOutputText("Wrong Password or Username");
        verifyNoMoreInteractions(admin_mockview, admin_mockmodel);
    }

    @Test
    public void testWrongPasswordadmin() {
        DataSnapshot mockSnapshot = mock(DataSnapshot.class);
        DataSnapshot mockChildSnapshot = mock(DataSnapshot.class);
        DataSnapshot mockGrandChildSnapshot = mock(DataSnapshot.class);

        when(mockSnapshot.hasChild("11")).thenReturn(true);
        when(mockSnapshot.child("11")).thenReturn(mockChildSnapshot);
        when(mockChildSnapshot.child("password")).thenReturn(mockGrandChildSnapshot);
        when(mockGrandChildSnapshot.getValue()).thenReturn("123");

        adminloginPresenter admin_mockpresenter = new adminloginPresenter(admin_mockview, admin_mockmodel);

        admin_mockpresenter.userStuff("11", "12", mockSnapshot);

        verify(admin_mockview).SetOutputText("Wrong Password");
        verifyNoMoreInteractions(admin_mockview, admin_mockmodel);
    }

}