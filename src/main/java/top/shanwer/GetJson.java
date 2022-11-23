package top.shanwer;

import com.alibaba.fastjson.JSONObject;

public class GetJson {
    String getLunch = new GetString().getString();
    String getDinner = new GetString().getString();
    public Object getOnce() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sentence",new GetString().getSentence());
        jsonObject.put("lunch",getLunch);
        jsonObject.put("dinner",getDinner);
        return jsonObject;
    }
    public Object getAll() {
        JSONObject jsonObject = new JSONObject();
        this.getLunch = new GetString().getString();
        this.getDinner = new GetString().getString();
        jsonObject.put("sentence",new GetString().getSentence());
        jsonObject.put("lunch",getLunch);
        jsonObject.put("dinner",getDinner);
        return jsonObject;
    }
    public Object getWeekday() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sentence", "接收到特殊参数请求，呈现weekDay食物");
        jsonObject.put("lunch",new GetString().getWeekdayDishes());
        jsonObject.put("dinner",new GetString().getWeekdayDishes());
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
