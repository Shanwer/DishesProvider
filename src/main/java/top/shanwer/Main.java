package top.shanwer;

import io.javalin.Javalin;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        double startTime = System.nanoTime();
        //TODO：
        //      1.判断是不是周末吃大餐 完成 √
        //      2.scanner读文件不太好用，下次可以试试 yaml（下次一定）
        //      3.每天必须吃一顿有蔬菜的，那样子的话得处理 plain text到多维数组了吧（
        //      4.写个日志？省得吃的东西重复（或者用堆栈，再来个数组，不写日志，那就得直接生成一周）,或者消耗他们，抽一个一个就变成 null，抽到null就catch exception然后throw然后继续抽！然后过一周再重新更新数组
        //      5.做到网页上，更泛用，比如叫 Shanwer Start，和4.一起做的话感觉会好一点，嗯，那还得学一些东西 (非常好的完成了！！ √）
        //      6.再来点每日金句做鸡汤鼓励可怜的sw（ （大概完成了） √
        //Scanner menu = new Scanner(Path.of("menu.txt"), StandardCharsets.UTF_8); //不用Path.of()，有Paths.get()了，虽然不知道区别


        final int mode = 2; //开控制台还是后端服务器模式
        switch (mode) {
            case 0:
                String[] Dishes = new String[2];
                Dishes[0] = new GetString().getString();
                Dishes[1] = new GetString().getString();
                System.out.println(new GetString().getSentence());
                System.out.println("中饭吃:" + Dishes[0]);
                System.out.println("晚饭吃:" + Dishes[1]);
                double cmdEndTime = System.nanoTime();
                System.out.println("执行命令行程序所用时间:" + (cmdEndTime - startTime) / 1000000000 + "秒");
                break;

            case 1:
                Javalin returnHtmlApp = Javalin.create(/*config*/)
                        .before(ctx -> ctx.header("Content-Type", "text/html;charset=utf-8"))
                        .get("/", ctx -> ctx.result(new GetString().getSentence() + "<br/>" + new GetString().getString() + "<br/>" + new GetString().getString()))
                        .start(8080);
                double htmlEndTime = System.nanoTime();
                System.out.println("开启服务端后所用时间:" + (htmlEndTime - startTime) / 1000000000 + "秒");
                break;

            case 2:
                GetJson obj = new GetJson();//得到一个静态的getJson对象
                Javalin returnJsonApp = Javalin.create(/*config*/)
                        .before(ctx -> ctx.header("Access-Control-Allow-Origin", "*"))//后端还需要加上跨域，否则无法调用API
                        .get("/normalRequest", ctx -> ctx.json(obj.getOnce()))
                        .get("/refreshAll/{pathParam}", ctx -> {
                            if(ctx.pathParam("pathParam").equals("default")){
                                ctx.json(obj.getAll());
                            }else{
                                ctx.json(obj.getWeekday());
                            }
                            })
                        //.get("/refreshLunch", ctx -> ctx.json(obj.getLunch()))
                        //.get("/refreshDinner", ctx -> ctx.json(obj.getDinner()))
                        .start(8080);
                double jsonEndTime = System.nanoTime();
                System.out.println("开启服务端后所用时间:" + (jsonEndTime - startTime) / 1000000000 + "秒");
                break;
        }
    }
    public static int randomIndex(int i) {
        Random randomNumber = new Random();
        //randomNumber.setSeed(); 如果使用确定的种子会生成一样的结果
        i = randomNumber.nextInt(i);
        return i;
    }
}