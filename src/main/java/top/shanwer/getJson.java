package top.shanwer;

import com.alibaba.fastjson.JSONObject;

public class getJson {
    public Object getJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1",new getString().getSentence());
        jsonObject.put("2",new getString().getLunch());
        jsonObject.put("3",new getString().getDinner());
        return jsonObject;
    }
}
