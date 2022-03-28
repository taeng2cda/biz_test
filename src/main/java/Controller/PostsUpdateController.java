package main.java.Controller;

import main.java.DAO.PostsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/posts/update")
public class PostsUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        req.setAttribute("postsid",id);
        req.getRequestDispatcher("/posts/postsupdate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int id1 = Integer.parseInt(id);

        System.out.println("id : "+ id1);
        System.out.println("title : "+ title);
        System.out.println("contnet : "+ content);

        //dao에 id값을 넘겨서 업데이트 후 반응
        PostsDao dao = new PostsDao();

        int n = dao.PostsUpdate(id1,title,content);

        if(n>0){
            req.setAttribute("resultupdate","success");
            resp.sendRedirect(req.getContextPath()+"/posts/list?pageNum=1");
        }else{
            req.setAttribute("resultupdate","fail");
            req.getRequestDispatcher(req.getContextPath()+"/posts/result.jsp").forward(req,resp);
        }


    }
}
