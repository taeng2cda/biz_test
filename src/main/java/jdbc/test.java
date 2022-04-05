package jdbc;

import org.krysalis.barcode4j.BarcodeClassResolver;
import org.krysalis.barcode4j.DefaultBarcodeClassResolver;
import org.krysalis.barcode4j.impl.AbstractBarcodeBean;
import org.krysalis.barcode4j.output.java2d.Java2DCanvasProvider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class test {

    static int width = 456;
    static int height = 110;

    public static void main(String[] args) {

        String randomnumber = "";

        for(int i =0; i < 11; i++){
            int resule = (int)(Math.random()*10+1);
            randomnumber += resule;
        }
        System.out.println(randomnumber);
        init(randomnumber);
    }

    private static void init(String randomnumber) {
        String barcodeType = "code128";

        /* 바코드 데이터 값이 변경되면 바코드 이미지도 바뀜. */
        String barcodeData = randomnumber;

        int x = 3;
        int y = 2;
        int scaleX = 18;
        int scaleY = 7;
        Graphics2D g = null;
        BufferedImage imgCoupon = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g = imgCoupon.createGraphics();
        try{
            /* 이미지 생성 */
            createBarcodeBuf(g, barcodeType, barcodeData, x, y, scaleX, scaleY);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(imgCoupon, "png", baos);
            baos.flush();
            byte[] buffer = baos.toByteArray();
            // 아래 는 버퍼에 제대로 담겼는지 테스트로 찍어봄...
            File f = new File("c:\\barcode\\"+randomnumber+".png");
            FileOutputStream fos =new FileOutputStream(f);
            fos.write(buffer);
            fos.flush();
            fos.close();
        }catch(Exception e) {
            System.out.println("error : "+e.getMessage());
            System.out.println("exception" + e.getMessage());
        }
    }

    private static  void  createBarcodeBuf(Graphics2D g2d, String barcodeType, String barcodeData, int x, int y,  int scaleX, int scaleY) throws Exception {

        AbstractBarcodeBean bean = null;
        BarcodeClassResolver resolver = new DefaultBarcodeClassResolver();
        Class clazz = resolver.resolveBean(barcodeType);
        bean = (AbstractBarcodeBean) clazz.newInstance();
        bean.doQuietZone(true);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.BLACK);
        g2d.translate(x, y);      /* 좌표 지정 */
        g2d.scale(scaleX, scaleY);   /* 크기 지정 */
        Java2DCanvasProvider j2dp = new Java2DCanvasProvider(g2d, 0);
        bean.generateBarcode(j2dp, barcodeData);

    }
}


