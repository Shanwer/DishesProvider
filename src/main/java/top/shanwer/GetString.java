package top.shanwer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Scanner;

import static top.shanwer.Main.randomIndex;

public class GetString {
    private final boolean whetherRest;
    //Path weekdayMenu = Paths.get("C:\\Users\\Shanwer\\Documents\\Work\\Code\\DishesProvider\\out\\artifacts\\DishesProvider_jar\\weekdayDishes.txt");//本地idea方便调试用的绝对路径
    //Path weekendMenu = Paths.get("C:\\Users\\Shanwer\\Documents\\Work\\Code\\DishesProvider\\out\\artifacts\\DishesProvider_jar\\weekendDishes.txt");
    //Path weekdayMenu = Paths.get("weekdayDishes.txt");//release使用的
    //Path weekendMenu = Paths.get("weekendDishes.txt");
    private final String[] weekdayDishes;
    private final String[] weekendDishes;
    public GetString(){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        whetherRest = day == 1 || day == 7;
        Path weekdayMenu = Paths.get("Dishes/weekdayDishes.txt");
        Path weekendMenu = Paths.get("Dishes/weekendDishes.txt");
        //用了try-with-resources语句，避免无法正确关闭文件
        try (Scanner weekdayMenuScanner = new Scanner(weekdayMenu, StandardCharsets.UTF_8);//不加StandardCharsets的话Windows会以GBK编码读取，导致输出乱码
             Scanner weekendMenuScanner = new Scanner(weekendMenu, StandardCharsets.UTF_8)) {
            long weekdayLineCount = Files.lines(weekdayMenu).count();
            long weekendLineCount = Files.lines(weekendMenu).count();

            weekdayDishes = new String[(int) weekdayLineCount];
            weekendDishes = new String[(int) weekendLineCount];

            for (int i = 0; i < weekdayLineCount; i++) {
                weekdayDishes[i] = weekdayMenuScanner.nextLine();
            }

            for (int i = 0; i < weekendLineCount; i++) {
                weekendDishes[i] = weekendMenuScanner.nextLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getString() {
        return whetherRest ? weekendDishes[randomIndex(weekendDishes.length)] : weekdayDishes[randomIndex(weekdayDishes.length)];
    }

    public String getWeekdayDishes() {
        return weekdayDishes[randomIndex(weekdayDishes.length)];
    }

    public String getSentence() {
        String weekendSentence = "今天是周末哦，好好休息吧sw~";
        //String weekdaySentence = "今天是工作日，加把劲sw！";
        String[] weekdaySentence = {
                "今天是工作日，加把劲sw！",
                "给老子卷！不许休息！！",
                "你这个年纪怎么睡得着觉的？",
                "不要再卷了啊！",
                "赞美躺平！"
        };

        if (whetherRest) {
            if (randomIndex(5) % 2 != 0)
                //选取动画、文学、诗词与哲学四个分类，返回纯洁文本
                //之所以是5是因为是喜欢的数字&&让抽取weekdaySentence的概率变的等可能
                return HttpGet.sendGet("https://v1.hitokoto.cn", "c=a&c=d&c=i&c=k&encode=text");
            else
                return weekendSentence;
        }else
            if (randomIndex(5) % 2 != 0)
                return HttpGet.sendGet("https://v1.hitokoto.cn", "c=a&c=d&c=i&c=k&encode=text");
            else
                return weekdaySentence[randomIndex(weekdaySentence.length)];
    }
}
