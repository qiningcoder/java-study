package spring.bean;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shiqining on 11/17/16.
 */
public class DatePropertyEditor extends PropertyEditorSupport {
    public void setAsText(String arg0) {
        System.out.println("arg0=" + arg0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = sdf.parse(arg0);
            setValue(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
