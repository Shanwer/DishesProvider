package top.shanwer;

import com.alibaba.fastjson.JSONObject;

public class GetJson {
    String getLunch = new GetString().getString();
    String getDinner = new GetString().getString();
    public Object getOnce() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1",new GetString().getSentence());
        jsonObject.put("2",getLunch);
        jsonObject.put("3",getDinner);
        return jsonObject;
    }
    public Object getAll() {
        JSONObject jsonObject = new JSONObject();
        this.getLunch = new GetString().getString();
        this.getDinner = new GetString().getString();
        jsonObject.put("1",new GetString().getSentence());
        jsonObject.put("2",getLunch);
        jsonObject.put("3",getDinner);
        return jsonObject;
    }
    public Object getWeekday() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1", "接收到特殊参数请求，呈现weekDay食物");
        jsonObject.put("2",new GetString().getWeekdayDishes());
        jsonObject.put("3",new GetString().getWeekdayDishes());
        return jsonObject;
    }
    /*public Object getLunch() {
        JSONObject jsonObject = new JSONObject();
        this.getLunch = new getString().getLunch();
        jsonObject.put("1",new getString().getLunch());
        return jsonObject;
    }
    public Object getDinner() {
        JSONObject jsonObject = new JSONObject();
        this.getDinner = new getString().getDinner();
        jsonObject.put("1",new getString().getDinner());
        return jsonObject;
    }*/
}
