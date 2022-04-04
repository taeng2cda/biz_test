package Controller;

import DAO.PostsDao;
import VO.PostsVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/posts/update")
public class PostsUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        int id1 = Integer.parseInt(id);
        PostsDao dao = new PostsDao();
        PostsVo vo = dao.oneselect(id1);

        req.setAttribute("postsid",id1);
        req.setAttribute("title",vo.getTitle());
        req.setAttribute("content",vo.getContent());
        req.setAttribute("posts_created_at",vo.getFormat_created_at() );
        req.setAttribute("posts_updated_at",vo.getFormat_updatred_at() );
        //fk값을 세션에 담은 이유는 유저글을 수정할때 조건문을 줌.  (posts/postsupdate.jsp)
        req.setAttribute("postsfk",vo.getUser_id());

        System.out.println(vo.toString());

        req.getRequestDispatcher("/posts/postsupdate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String posts_id = req.getParameter("posts_id");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int id1 = Integer.parseInt(posts_id);

        System.out.println("id : "+ id1);
        System.out.println("title : "+ title);
        System.out.println("contnet : "+ content);

        //dao에 id값을 넘겨서 업데이트 후 반응
        PostsDao dao = new PostsDao();

        int n = dao.PostsUpdate(id1,title,content);

        if(n>0){
            req.setAttribute("resultupdate","success");
            req.getRequestDispatcher(req.getContextPath()+"/index.jsp").forward(req,resp);
        }else{
            req.setAttribute("resultupdate","fail");
            req.getRequestDispatcher(req.getContextPath()+"/posts/result.jsp").forward(req,resp);
        }


    }
}
