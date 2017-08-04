package jums;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author PCUser
 */
//フォームから受け取ったデータ自体を格納できるJavaBeans
//これを利用して表示や分岐などをさせる
public class UserDataBeans {

    private String name;
    private String yaer;
    private String month;
    private String day;
    private String tell;
    private int type;
    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYaer() {
        return yaer;
    }

    public void setYear(String year) {
        this.yaer = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
