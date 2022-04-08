package Controller;


import DAO.BarCodeDao;
import VO.BarCodeVo;
import jdbc.BarCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/barcode/detail")
public class BarcodeDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        BarCodeDao dao = new BarCodeDao();
        BarCodeVo vo = dao.SelectBarcode(id);

        if(vo != null){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        req.setAttribute("b_id",vo.getId());
        req.setAttribute("b_barcodekey",vo.getBarcodeKey());
        req.setAttribute("b_title",vo.getTitle());
        req.setAttribute("b_content",vo.getContent());
        req.setAttribute("b_updated_at",vo.getFormat_updatred_at());
        req.setAttribute("b_created_at",vo.getFormat_created_at());

        req.getRequestDispatcher(req.getContextPath()+"/WEB-INF/barcode/barcodedetail.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String b_id = req.getParameter("b_id");
        String barcodekey =req.getParameter("hiddenbarcodekey");
        boolean exist=false;

        System.out.println("barcodeKey : " + barcodekey);

        // 바코드 키값을 넘겨주면 이미지를 생성해줌
        // 경로는 c://barcode/이미지파일명.png
        exist = BarCode.CreateBarcodeImg(barcodekey);
        System.out.println("Utill END");


        resp.sendRedirect( "/barcode/detail?id="+b_id );

    }
}
