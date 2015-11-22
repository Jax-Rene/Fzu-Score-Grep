package login;

import utils.*;

import javax.mail.MessagingException;


/**
 * Created by zhuangjy on 2015/11/18.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("======================首先登陆会收到302重定向提取重定向URL======================");
        String url = "http://59.77.226.32/logincheck.asp";
        String body = "muser=031202338&passwd=123123&x=42&y=19";
        HttpRequest request = new HttpRequest();
        //设置Header模拟浏览器
        request.addHeader("Content-Type", "application/x-www-form-urlencoded");
        request.addHeader("Connection", "keep-alive");
        request.addHeader("Cache-Control","private");
        request.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        request.addHeader("Upgrade-Insecure-Requests","1");
        request.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
        request.addHeader("Referer","http://jwch.fzu.edu.cn/");
        request.addHeader("Accept-Encoding","gzip, deflate, sdch");
        request.addHeader("Accept-Language","zh-CN,zh;q=0.8,en;q=0.6");
        request.addHeader("Cookie", "ASP.NET_SessionId=ajo0vavbnibugcrvlbrwp1ki");

        request.setBody(body);
        HttpResponse httpResponse = HttpClientUtil.doRequestWithNoRetry(url, HttpMethodEnum.POST, request,
                MediaTypes.TEXT_PLAIN_UTF_8);
        int status = httpResponse.getStatus();
        String responseBody = httpResponse.getBody();
//        System.out.println("返回代码:" + status);
//        System.out.println("返回body:");
//        System.out.println(responseBody);


        System.out.println("======================再次重定向，并且获取新的ID======================");
        url = httpResponse.getHeaders().get("Location");
        httpResponse = HttpClientUtil.doRequestWithNoRetry(url, HttpMethodEnum.GET, request, MediaTypes.TEXT_PLAIN_UTF_8);
        status = httpResponse.getStatus();
        responseBody = httpResponse.getBody();
//        System.out.println(status);
//        System.out.println(responseBody);

        Integer index = responseBody.indexOf("id=") + 3;
        Integer last = responseBody.indexOf("\"", index);
        String id = responseBody.substring(index, last);

        System.out.println("======================下面是AJAX获取成绩======================");
        url = "http://59.77.226.35/student/jscp/TeaList.aspx?id=" + id + "&bj=score";
        httpResponse = HttpClientUtil.doRequestWithNoRetry(url, HttpMethodEnum.GET, request, MediaTypes.TEXT_PLAIN);
        status = httpResponse.getStatus();
        responseBody = httpResponse.getBody();
//        System.out.println(status);
        System.out.println(responseBody);

        String target = "计算机网络体系结构";
        readScore(responseBody,target);
    }

    public static void readScore(String body,String target) throws MessagingException {
        String[] t = body.split("\\n");
        for(int i=0;i<t.length;i++){
            //找到了目标学科的成绩
            if(t[i].indexOf(target)!=-1){
                //判断成绩是不是出来了
                if(t[i+2].indexOf("成绩尚未录入")==-1){
                    System.out.println("成绩出来了,正在准备发送邮件");
                    //成绩出来了发送邮件通知
                    SimpleMailSender sms = new SimpleMailSender("249602015@qq.com","joy-zhuang");
                    String message = "扬哥，您的<font color='red'>" + target + "</font>成绩终于出来啦!您获得了" + t[i+2] + "分!恭喜您通过考试!";
                    sms.send("249602015@qq.com","成绩出来了!",message);
                    break;
                }else{
                    System.out.println("成绩没有出来!");
                    break;
                }
            }
        }
    }
}
