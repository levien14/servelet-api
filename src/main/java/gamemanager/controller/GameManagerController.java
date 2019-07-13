package gamemanager.controller;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import gamemanager.entity.GameInfor;
import gamemanager.jsonObject.JsonObjectHandle;
import uitl.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class GameManagerController extends HttpServlet {

    {
        ObjectifyService.register(GameInfor.class);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);

        List<GameInfor> gameInfors  =  ofy().load().type(GameInfor.class).list();
//        if (gameInfors.size() == 0){
//            gameInfors = new List;
//        }

        JsonObjectHandle jsonObjectHandle = new JsonObjectHandle();
        jsonObjectHandle.setValues(resp.getStatus(),resp.getStatus() + " OK", gameInfors);

        System.out.println(new Gson().toJson(gameInfors));
        resp.getWriter().println(new Gson().toJson(jsonObjectHandle));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String content = StringUtil.convertInputStreamToString(req.getInputStream());
        GameInfor gameInfor = new Gson().fromJson(content, GameInfor.class);

        Key<GameInfor> gameInforKey = ofy().save().entity(gameInfor).now();
        resp.setStatus(HttpServletResponse.SC_CREATED);

        JsonObjectHandle jsonObjectHandle = new JsonObjectHandle();
        jsonObjectHandle.setValues(resp.getStatus(),resp.getStatus() + " Created",gameInfor);

        resp.getWriter().print(new Gson().toJson(jsonObjectHandle));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String content = StringUtil.convertInputStreamToString(req.getInputStream());
        GameInfor updateGame = new Gson().fromJson(content, GameInfor.class);
        updateGame.getId();
        GameInfor existGame = ofy().load().type(GameInfor.class).id(updateGame.getId()).now();
        if (existGame == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy game.");
            return;
        }
        existGame.setName(updateGame.getName());
        existGame.setKind(updateGame.getKind());
        existGame.setPrice(updateGame.getPrice());
        existGame.setRelease(updateGame.getRelease());
        existGame.setDescription(updateGame.getDescription());
        existGame.setUpdatedAT(Calendar.getInstance().getTimeInMillis());
        ofy().save().entity(existGame).now();
        resp.setStatus(HttpServletResponse.SC_OK);

        JsonObjectHandle jsonObjectHandle = new JsonObjectHandle();
        jsonObjectHandle.setValues(resp.getStatus(),resp.getStatus() + " Ok",existGame);

        resp.getWriter().print(new Gson().toJson(jsonObjectHandle));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Long gameId = Long.parseLong(req.getParameter("gameID"));
        System.out.println(gameId);
        GameInfor existGame = ofy().load().type(GameInfor.class).id(gameId).now();
        if (existGame == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy Game");
            return;
        }
        existGame.setStatus(GameInfor.Status.DEACTIVE);
        existGame.setDeletedAT(Calendar.getInstance().getTimeInMillis());
        Key<GameInfor> key = ofy().save().entity(existGame).now();
        resp.setStatus(HttpServletResponse.SC_OK);

        JsonObjectHandle jsonObjectHandle = new JsonObjectHandle();
        jsonObjectHandle.setValues(resp.getStatus(),resp.getStatus() + " OK",existGame);
        System.out.println(new Gson().toJson(key));
        System.out.println(new Gson().toJson(jsonObjectHandle));
        resp.getWriter().print(new Gson().toJson(jsonObjectHandle));
    }
}
