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
    Calendar cal = Calendar.getInstance();
    int day = cal.get(Calendar.DAY_OF_WEEK);
    boolean whetherRest = day == 1 || day == 7;
    Path weekdayMenu = Paths.get("Dishes/weekdayDishes.txt");//服务器上的(
    Path weekendMenu = Paths.get("Dishes/weekendDishes.txt");
    //Path weekdayMenu = Paths.get("C:\\Users\\Shanwer\\Documents\\Work\\Code\\DishesProvider\\out\\artifacts\\DishesProvider_jar\\weekdayDishes.txt");//本地idea方便调试用的绝对路径
    //Path weekendMenu = Paths.get("C:\\Users\\Shanwer\\Documents\\Work\\Code\\DishesProvider\\out\\artifacts\\DishesProvider_jar\\weekendDishes.txt");
    //Path weekdayMenu = Paths.get("weekdayDishes.txt");//release使用的
    //Path weekendMenu = Paths.get("weekendDishes.txt");
    long weekdayLineCount;//Warning的意思是这个方法没有使用'try'-with-resources语句，后果就是在读取文件的时候对文件进行操作就会寄
    long weekendLineCount;
    Scanner weekdayMenuScanner;//不加StandardCharsets的话Windows会以GBK编码读取，导致输出乱码
    Scanner weekendMenuScanner;
    {
        try {
            weekdayLineCount = Files.lines(weekdayMenu).count();
            weekendLineCount = Files.lines(weekendMenu).count();
            weekdayMenuScanner = new Scanner(weekdayMenu, StandardCharsets.UTF_8);
            weekendMenuScanner = new Scanner(weekendMenu, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//try之后不是和嵌套那样结束内部嵌套外部数据就无了，不用担心
    String[] weekdayDishes = new String[(int) weekdayLineCount];
    String[] weekendDishes = new String[(int) weekendLineCount];
    public String getString(){
        for (int weekdayCount = 0; weekdayMenuScanner.hasNextLine(); weekdayCount++) {
            this.weekdayDishes[weekdayCount] = weekdayMenuScanner.nextLine();
            //System.out.println(weekdayCount + weekdayDishes[weekdayCount]);
        }
        for (int weekendCount = 0; weekendMenuScanner.hasNextLine(); weekendCount++) {
            weekendDishes[weekendCount] = weekendMenuScanner.nextLine();
            //System.out.println(weekendCount + weekdayDishes[weekendCount]);
        }
        //按照调试结果判断，结束了一个for循环Scanner就得重新nextLine()了，折磨自己干啥，两个文件就好了
        return whetherRest ? weekendDishes[randomIndex(weekendDishes.length)] : weekdayDishes[randomIndex(weekdayDishes.length)];
    }
    public String getWeekdayDishes(){
        for (int weekdayCount = 0; weekdayMenuScanner.hasNextLine(); weekdayCount++) {
            weekdayDishes[weekdayCount] = weekdayMenuScanner.nextLine();
        }
        return weekdayDishes[randomIndex(weekdayDishes.length)];
    }
    public String getSentence(){
        String weekendSentence = "今天是周末哦，好好休息吧sw~";
        //String weekdaySentence = "今天是工作日，加把劲sw！";
        String[] weekdaySentence = {
                "今天是工作日，加把劲sw！",
                "给老子卷！不许休息！！",
                "你这个年纪怎么睡得着觉的？",
                "不要再卷了啊！",
                "赞美躺平！"
        };
        return whetherRest ? weekendSentence : weekdaySentence[randomIndex(weekdaySentence.length)];
    }
}
