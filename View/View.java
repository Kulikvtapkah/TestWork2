package TestWork2.View;

import java.util.ArrayList;

public interface View {
    public String getStringData(String message);

    public int getNumber(String message);

    public void userInfo(String message);

    public void showOptions(ArrayList<String> optiontable);

    String getOption(ArrayList<String> optiontable);
}
