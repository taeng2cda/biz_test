package main.java.Controller;

import main.java.DAO.UserTableDao;
import main.java.VO.UserTableVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/join")
public class UserJoinController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(req.getContextPath()+"/join.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String email=req.getParameter("email");
        String pw=req.getParameter("pw");
        String name=req.getParameter("name");

        UserTableVo vo = new UserTableVo(0,email,name,pw,null,null);
        UserTableDao dao = new UserTableDao();
        int n = dao.insert(vo);

        if(n>0){
            req.setAttribute("result" , "success");
        }else{
            req.setAttribute("result" , "fail");
        }
        req.getRequestDispatcher(req.getContextPath()+"/result.jsp").forward(req, resp);
    }

}
