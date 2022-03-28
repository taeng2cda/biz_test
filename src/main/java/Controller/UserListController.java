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

        req.setCharacterEncoding("utf-8");
        String spageNum = req.getParameter("pageNum");
        int pageNum = 1;
        if(spageNum != null){
            pageNum = Integer.parseInt(spageNum);
        }

        int startRow = (pageNum-1)*10+1;
        int endRow = startRow + 9;

        UserTableDao dao = new UserTableDao();
        ArrayList<UserTableVo> userlist = dao.userlist(startRow,endRow);

        int count = dao.getCount();  //전체 글의 갯수
        int pageCount =(int)Math.ceil(count/10.0);      //전체 페이지 갯수  4
        int startPageNum = ((pageNum-1)/10*10) +1;   //시작 페이지 번호
        int endPageNum = startPageNum + 9;     //끝페이지 번호
        if(endPageNum > pageCount){
            endPageNum = pageCount;
        }
        req.setAttribute("userlist",userlist);
        req.setAttribute("pageCount",pageCount);
        req.setAttribute("startPage",startPageNum);
        req.setAttribute("endPage",endPageNum);
        req.setAttribute("pageNum",pageNum);

        req.getRequestDispatcher(req.getContextPath()+"/userlist.jsp").forward(req,resp);
    }
}
