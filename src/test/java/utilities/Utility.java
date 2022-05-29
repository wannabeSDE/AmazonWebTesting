package utilities;

public class Utility {
    private CommonUtility commonUtility;
    public Utility(){
        commonUtility = new CommonUtility();
    }
    public String getFirefoxDriverPath(){
        String location = commonUtility.readProperty("firefox");
        return location;
    }
    public String getChromeDriverPath(){
        String location = commonUtility.readProperty("chrome");
        return location;
    }
    public String getHomePageLink(){
        String url = commonUtility.readProperty("homePage");
        return url;
    }
}
