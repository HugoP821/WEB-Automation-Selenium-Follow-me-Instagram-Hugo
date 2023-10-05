package pages;

public class InstagramPage extends basepage{
    private String BTN_USER = "(//*[@class='_aa4a'])[1]";
    private String BTN_PASS = "(//*[@class='_aa4a'])[2]";
    private String BTN_LOGIN = "//*[class='_acan _acap _acas _aj1-']";
    private String BTN_ZOOM = "(//div[@class='x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1n2onr6 x1plvlek xryxfnj x1c4vz4f x2lah0s xdt5ytf xqjyukv x1qjc9v5 x1oa3qoh x1nhvcw1'])[3]";
    private String BTN_SEARCH = "//*[contains(text(),'Buscar')]";
    private String USER = "(//div[@class='x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1uhb9sk x1plvlek xryxfnj x1iyjqo2 x2lwn1j xeuugli xdt5ytf xqjyukv x1cy8zhl x1oa3qoh x1nhvcw1'])[1]";
    private String FOLLOW = "//*[contains(text(),'Seguir')]";
    private String FOLLOW_MESSAGE = "//*[contains(text(),'Pendiente')]";

    public InstagramPage(){
        super(driver);
    }
    public void navigateToInstagram(){
        navigateTo("https://www.instagram.com/");
    }
    public void enterUser(String user){
        write(BTN_USER, user);
    }
    public void enterPassword(String password){
        write(BTN_PASS, password);
    }
    public void login(){
        clickElement(BTN_LOGIN);
    }
    public void selectSearchUser(){
        clickElement(BTN_ZOOM);
    }
    public void enterUserInstagram(String HugoUSer){
        write(BTN_SEARCH, HugoUSer);
    }
    public void selectUser(){
        clickElement(USER);
    }
    public void followUserInstagram(){
        clickElement(FOLLOW);
    }
    public String followedRequestMessage(){
        return textFromElement(FOLLOW_MESSAGE);
    }
}