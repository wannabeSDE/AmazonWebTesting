package utilities;

public class Validator{
    public void checkIfEquals(String expectedValue, String actualValue){
        Logs.getInfoLogs("The expected value is: {"+expectedValue+"}");
        Logs.getInfoLogs("The actual value is: {"+actualValue+"}");
        if(expectedValue.equalsIgnoreCase(actualValue)){
            Logs.getInfoLogs("The expected value and actual value are same");
        }else{
            Logs.getErrorLogs("There is a mismatch in actual value and expected value");
            Throwable throwable = new Throwable("There is a mismatch in actual value and expected value");
            throwable.printStackTrace();
        }
    }
}
