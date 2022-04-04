package Controller;

import DAO.PostsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/posts/delete")
public class PostsDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String posts_id = req.getParameter("posts_id");
        PostsDao dao = new PostsDao();
        int id1 = Integer.parseInt(posts_id);

        // dao delete문에 id값 넣기
        int n = dao.PostsDelete(id1);
        if( n > 0){
            System.out.println("seccuss");
            req.getRequestDispatcher(req.getContextPath()+"/index.jsp").forward(req,resp);
        }else{
            System.out.println("fail");
            req.setAttribute("resultdelete","fail");
            req.getRequestDispatcher(req.getContextPath()+"/posts/result.jsp").forward(req,resp);
        }

    }

}
