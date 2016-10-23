package ua.com.vertex.util;

/**
 * Created by sweet_home on 22.10.16.
 */
public class StringUtil implements StringUtilInf {

    private StringHelper helper;

    @Override
    public String revert(String toRevert) {
        System.out.println("In revert");
        return "";
    }

    @Override
    public String deleteAll(String from, String toDelete) {
        System.out.println("In deleteAll");
        return helper.deleteAll(from, toDelete);
    }

    public void setHelper(StringHelper helper) {
        this.helper = helper;
    }
}
