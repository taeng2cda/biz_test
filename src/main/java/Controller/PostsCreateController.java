package main.java.Controller;

import main.java.DAO.PostsDao;
import main.java.VO.PostsVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/posts/create")
public class PostsCreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(req.getContextPath()+"/posts/postscreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String user_id = req.getParameter("user_id");

        PostsVo vo = new PostsVo(id,title,content,user_id,null,null);
        PostsDao dao = new PostsDao();

        int n = dao.insert(vo);

        if(n>0){
            req.setAttribute("presult" , "success");
        }else{
            req.setAttribute("presult" , "success");
        }
        req.getRequestDispatcher(req.getContextPath()+"/posts/postscreate.jsp").forward(req, resp);
    }
}
