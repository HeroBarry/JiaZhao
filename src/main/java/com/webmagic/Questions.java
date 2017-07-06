package com.webmagic;

/**
 * Created by John on 2017/7/6.
 */
public class Questions {
    private String url;
    private String title;
    private String answer;
    private String img;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", answer='" + answer + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
