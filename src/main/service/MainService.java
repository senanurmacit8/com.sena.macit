package src.main.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import src.main.dao.MainDAO;
import src.main.model.*;

import src.main.util.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
public class MainService {

    @Autowired
    private MainDAO mainDAO;

//---------------------------------------------------------------------------------------------------------------------

    public JSONObject loadUser() {
        List<User> userLists = mainDAO.loadUser();

        JsonConfig jsonConfig = new JsonConfig();
        DateJSONValueProcessor dateProc = new DateJSONValueProcessor("dd/MM/yyyy");
        jsonConfig.registerJsonValueProcessor(Date.class, dateProc);

        JSONArray jsonArray = JSONArray.fromObject(userLists, jsonConfig);

        for (int i = 0; i < jsonArray.size(); i++) {
            User user = userLists.get(i);
            JSONObject json = jsonArray.getJSONObject(i);

            ToDoList toDoList = user.getToDoList();
            json.put("toDoListId", toDoList.getToDoListId());

        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", jsonArray);
        jsonObject.put("success", true);
        jsonObject.put("totalCount", jsonArray.size());
        return jsonObject;
    }

    public JSONObject loadToDoList() {
        List<ToDoList> toDoLists = mainDAO.loadToDoList();
        JSONArray jsonArray = JSONArray.fromObject(toDoLists);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);


            ToDoList toDoList = toDoLists.get(i);
            jsonObject.put("toDoListName", toDoList.getToDoListName());
        }

        JSONObject retJSONObject = new JSONObject();
        retJSONObject.put("data", jsonArray);
        retJSONObject.put("totalCount", jsonArray.size());
        retJSONObject.put("success", true);

        return retJSONObject;
    }

    public JSONObject loadToDoListItem() {
        List<ToDoListItem> toDoListItems = mainDAO.loadToDoListItem();
        JSONArray jsonArray = JSONArray.fromObject(toDoListItems);

        JSONObject retJSONObject = new JSONObject();
        retJSONObject.put("data", jsonArray);
        retJSONObject.put("totalCount", jsonArray.size());
        retJSONObject.put("success", true);

        return retJSONObject;
    }

//---------------------------------------------------------------------------------------------------------------------

    @Transactional(readOnly = false)
    public JSONObject saveOrUpdateUser(JSONObject jsonObject) throws ParseException {
        User user = null;

        Long userId = null;
        if (jsonObject.has("userId") && jsonObject.get("userId") != null && !jsonObject.getString("userId").equals(""))
            userId = jsonObject.getLong("userId");
        if (userId != null) {
            user = (User) mainDAO.loadObject(User.class, userId);
        } else {
            user = new User();
        }

        String userNo = jsonObject.getString("userNo");
        String username = jsonObject.getString("username");
        String userLastname = jsonObject.getString("userlastname");
        String userPassword = jsonObject.getString("userPassword");

        Long toDoListId = jsonObject.getLong("toDoList");
        ToDoList toDoList = (ToDoList) mainDAO.loadObject(ToDoList.class, toDoListId);

        user.setUserNo(userNo);
        user.setUsername(username);
        user.setUserLastname(userLastname);
        user.setToDoList(toDoList);
        user.setUserPassword(userPassword);

        boolean success = mainDAO.saveOrUpdateObject(user);

        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("success", success);
        return jsonReturn;
    }

    @Transactional(readOnly = false)
    public JSONObject deleteUser(Long userId) {
        User user = (User) mainDAO.loadObject(User.class, userId);
        boolean success = mainDAO.removeObject(user);

        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("success", success);
        return jsonReturn;
    }

}
