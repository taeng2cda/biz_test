package Controller;

import DAO.PostsDao;
import VO.PostsVo;

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
        req.getRequestDispatcher(req.getContextPath()+"/WEB-INF/posts/postscreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String user_id = req.getParameter("user_id");
        int result = Integer.parseInt(user_id);

        PostsVo vo = new PostsVo(0,title,content,result,null,null);
        PostsDao dao = new PostsDao();
        int n = dao.insert(vo);

        if(n>0){
            req.setAttribute("resultcreate" , "success");
            resp.sendRedirect(req.getContextPath()+"/WEB-INF/posts/list?pageNum=1");
        }else{
            req.setAttribute("resultcreate" , "fail");
            req.getRequestDispatcher(req.getContextPath()+"/WEB-INF/posts/postslist.jsp").forward(req, resp);
        }

    }
}
