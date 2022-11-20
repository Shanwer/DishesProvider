package top.shanwer;

import com.alibaba.fastjson.JSONObject;

public class getJson {
    String getLunch = new getString().getLunch();
    String getDinner = new getString().getDinner();
    public Object getOnce() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1",new getString().getSentence());
        jsonObject.put("2",getLunch);
        jsonObject.put("3",getDinner);
        return jsonObject;
    }
    public Object getAll() {
        JSONObject jsonObject = new JSONObject();
        this.getLunch = new getString().getLunch();
        this.getDinner = new getString().getDinner();
        jsonObject.put("1",new getString().getSentence());
        jsonObject.put("2",getLunch);
        jsonObject.put("3",getDinner);
        return jsonObject;
    }
    public Object getLunch() {
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
    }
}
