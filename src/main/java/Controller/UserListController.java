package main.java.Controller;

import main.java.DAO.PostsDao;
import main.java.DAO.UserTableDao;
import main.java.VO.UserTableVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/userlist")
public class UserListController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 파라미터로 받아온 값을 utf-8로 인코딩해줌 post방식은 인코딩을 해줘야함
        req.setCharacterEncoding("utf-8");


        //페이징처리 연습

        //페이지 번호를 받는다
        String spageNum = req.getParameter("pageNum");
        int pageNum = 1;

        // 페이지번호를 받으면 형변환 하여 pagdNum 변수에 담는다
        if(spageNum != null){
            pageNum = Integer.parseInt(spageNum);
        }

        int startRow = (pageNum-1)*10+1;
        int endRow = startRow+9;

        PostsDao pdao = new PostsDao();
        //dao.PostsList(startRow,endRow);



        UserTableVo vo = new UserTableVo();
        UserTableDao dao = new UserTableDao();

        ArrayList<UserTableVo> list = dao.userlist();
        req.setAttribute("list",list);

        req.getRequestDispatcher(req.getContextPath()+"/userlist.jsp").forward(req,resp);
    }
}
