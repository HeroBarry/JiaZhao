package com.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by John on 2017/7/6.
 */
public class Jiazhao implements PageProcessor {

    public void process(Page page) {
        String pattern = ".*tiba.[1-9]\\d*";
        List<String> requests = page.getHtml().links().regex(pattern).all();
        page.addTargetRequests(requests);

        Questions questions=new Questions();
        questions.setUrl(page.getUrl().toString());
        questions.setTitle(page.getHtml().xpath("//div[@class='topic-l f-l']//ul/li/text()").toString());
        questions.setAnswer(page.getHtml().xpath("//div[@class='topic-l f-l']//ul/li[@class='answer']/strong/text()").toString());
        questions.setImg(page.getHtml().xpath("//div[@class=topic-t]/div[2]/img/@src").toString());
        if (questions.getImg()==null)
            questions.setImg("非看图作答题");

        page.putField("questions",questions);

    }


    public Site getSite() {
        return Site.me().setDomain("www.jiazhao.com");
    }
    public static void main(String[] args){
        Spider.create(new Jiazhao()).addUrl("http://www.jiazhao.com/tiba/1").thread(5).run();
    }
}
