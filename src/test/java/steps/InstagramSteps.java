package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.InstagramPage;

public class InstagramSteps {
    InstagramPage instagram = new InstagramPage();
    @Given("^the user navigates to www.instagram.com$")
    public void navigateToInstagram(){
        instagram.navigateToInstagram();
    }
    @And("^login with your user (.+)$")
    public void enterUser(String user){
        instagram.enterUser(user);
    }
    @And("^login with your password (.+)$")
    public void enterPassword(String password){
        instagram.enterPassword(password);
    }
    @And("^selects the login button$")
    public void selectLoginButton(){
        instagram.login();
    }
    @And("^search hugo user (.+)$")
    public void searchUserInstagram(String userInstagram){
        instagram.selectSearchUser();
        instagram.enterUserInstagram(userInstagram);
        instagram.selectUser();
    }
     @And("^click in follow user$")
    public void followUser(){
        instagram.followUserInstagram();
     }
     @Then("^the user is followed$")
    public void validationUserFollowed(){
         Assert.assertEquals("Pendiente", instagram.followedRequestMessage());
     }
}