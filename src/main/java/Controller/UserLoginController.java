package main.java.Controller;

import main.java.DAO.UserTableDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id=req.getParameter("id");
        String pw=req.getParameter("pw");
        HttpSession session = req.getSession();

        System.out.println(id + pw);

        UserTableDao dao = new UserTableDao();
        boolean login = dao.logincheck(id,pw);
        System.out.println(login);

        if(login){
            System.out.println("Login OK");
            session.setAttribute("id",id);
            req.getRequestDispatcher("/main.jsp").forward(req,resp);
        }else{
            System.out.println("Login false");
            resp.sendRedirect(req.getContextPath()+"/main.jsp");
        }


    }
}
