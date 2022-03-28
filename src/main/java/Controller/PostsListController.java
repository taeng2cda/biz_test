package main.java.Controller;

import main.java.DAO.PostsDao;
import main.java.VO.PostsVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/posts/list")
public class PostsListController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String spageNum = req.getParameter("pageNum");

        // 페이지값이 없으면 1로 담아준다
        int pageNum = 1;
        if(spageNum != null){
            pageNum = Integer.parseInt(spageNum);
        }

        int startRow = (pageNum-1)*10+1;
        int endRow = startRow + 9;

        PostsDao dao = new PostsDao();
        ArrayList<PostsVo> list = dao.PostsList(startRow,endRow);



        int count = dao.getCount();  //전체 글의 갯수
        int pageCount =(int)Math.ceil(count/10.0);      //전체 페이지 갯수  4
        int startPageNum = ((pageNum-1)*10) +1;   //시작 페이지 번호
        int endPageNum = startPageNum + 9;     //끝페이지 번호
        if(endPageNum > pageCount){
            endPageNum = pageCount;
        }
        req.setAttribute("list",list);
        req.setAttribute("pageCount",pageCount);
        req.setAttribute("startPage",startPageNum);
        req.setAttribute("endPage",endPageNum);
        req.setAttribute("pageNum",pageNum);
        req.getRequestDispatcher(req.getContextPath()+"/posts/postslist.jsp").forward(req, resp);
    }
}
