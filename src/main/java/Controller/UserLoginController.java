package Controller;

import VO.UserTableVo;
import jdbc.MD5;
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

        req.setCharacterEncoding("utf-8");
        String email=req.getParameter("email");
        String pw = req.getParameter("pw");
        HttpSession session = req.getSession();

        String password = MD5.MD5(pw);

        UserTableDao dao = new UserTableDao();
        boolean login = dao.logincheck(email,password);
        System.out.println(login);

        if(login){
            System.out.println("Login OK");

            //아이디로 셀렉해서 pk,name,cre,up 세션에 담기
            UserTableVo vo = new UserTableVo();

            vo = dao.Idselect(email);

            session.setAttribute("email",email);
            session.setAttribute("user_id",vo.getId());
            session.setAttribute("name",vo.getName());
            session.setAttribute("created_at",vo.getCreated_at());
            session.setAttribute("updated_at",vo.getUpdated_at());

            req.getRequestDispatcher("/main.jsp").forward(req,resp);
        }else{
            System.out.println("Login false");
            resp.sendRedirect(req.getContextPath()+"/main.jsp");
        }


    }
}
