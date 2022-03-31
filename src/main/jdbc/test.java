package main.jdbc;

public class test {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------------------------");

        String result1 ="p.title";      //7
        String result2 ="p.content";    //9
        String result3 ="p.title-p.content"; //17


        //컨트롤러 시작
        String column = result2;

        System.out.println(column.length());


        String search = "내용검색";
        String sql="";
        sql = "select p.id , p.title , p.content , u.email , p.updated_at , p.created_at \n" +
                "from posts p inner join users u \n" +
                "on u.id = p.user_id \n" +
                //조건문
                "where "+ column +" like '%"+ search +"%' \n" +
                "order by created_at desc \n" +
                "limit 10 offset 0 ";

        System.out.println(sql);

        /*
        if(column.length() > 9){

            String sql1 = column.substring(0, 7);
            String sql2 = column.substring(8, 17);

            System.out.println(sql1);
            System.out.println(sql2);
        }else{



        }
         */


        System.out.println("-------------------------------------------------------------------------------");
    }

}
