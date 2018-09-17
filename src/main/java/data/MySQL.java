package data;

import java.io.*;
import java.sql.*;
import java.util.Properties;


public class MySQL {
    private static Connection conn;
    // JDBC 驱动名及数据库 URL
    static final String driverName = "com.mysql.jdbc.Driver";
    static final String IpPort = "jdbc:mysql://172.26.40.18:3306/test?useSSL=false";
    //jdbc:mysql://172.26.40.18:3306 or jdbc:mysql://localhost:3306/RUNOOB
    // 数据库的用户名与密码，需要根据自己的设置
    static final String userName = "gqs";
    static final String passwd = "Gqs@2018";

    //连接数据库
    static {
        initConnection();
    }

    public static void initConnection() {
        try {
            Class.forName(driverName);//加载（注册）数据库。表示用sql server数据库
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //定义数据库账号信息（地址，库名，账号，密码），并进行 数据库连接
        try {
            //连接数据库
            conn = DriverManager.getConnection(IpPort, userName, passwd);
            //建立Statement对象PreparedStatement对象。
            //Statement stmt=conn.createStatement();
            System.out.println("-------------数据库连接成功-----------");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("-------------数据库连接失败-----------");
        }
    }

    //关闭数据库连接
    public void closeconn() {
        try {
            conn.close();
            conn = null;
            System.out.println("-------------关闭数据库成功-----------");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            conn = null;
            System.out.println("-------------关闭数据库失败-----------");
        }
    }

    //根据SQL取某字段值。如果读取SQL中的值,返回有多个值时，取最后一个
    public static String getColumnValues(String sql, String key) {
        String getkey = "";
        try {
            if (conn == null) {
                initConnection();
            }
            PreparedStatement pstmt = conn.prepareStatement(sql);//执行sql语句，并将数据保存在数据集中
            ResultSet rs = pstmt.executeQuery();//executeQuery方法用于产生单个结果集的语句
            //读取数据集某字段信息
            while (rs.next()) {
                ;
                getkey = rs.getString(key);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getkey;
    }

    //插入/修改/删除 数据（调用时，直接传入新增的SQl语句）
    public boolean sqlSignle(String sql) {
        boolean flag = true;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            int i = ps.executeUpdate();//executeUpdate方法用于执行Insert,Update,Delete 语句。返回值是一个整数，指受影响的行数
            if (i == 0) {
                flag = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    //读取配置文件里的值。
    public static String getValueFromConf(String key) throws IOException {
        //生成一个Properties对象。Properties是一种配置文件  文件的内容是格式是"键=值"的格式
        Properties properties = new Properties();
        // 加载配置文件
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("conf/environment"));
        //取配置文件里的值。
        String Value = properties.getProperty(key);
        return Value;
    }

    //确保11位的手机号
    public static String getRealPhone(String phone) {
        //startsWith方法  表示86开头字符串。
        if ((phone.length() == 13) && (phone.startsWith("86"))) {
            return phone.substring(2, 13);
        }
        return phone;
    }

    //读取文件
    public static byte[] getBytes(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            //他们一件文件读取对象。并传入参数。
            FileInputStream fis = new FileInputStream(file);
            //创建字节输入流
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            //创建一个长度为1000的字节串
            byte[] b = new byte[1000];
            int n;
            //从fis对象中读取，写入bos对象中
            //while会自动+1进行循环。把b读到的第一个数据写赋到n中，然后再马上写到bos中。
            while ((n = fis.read(b)) != -1) { //取到的值是二进制，所以n定义成int型。
                bos.write(b, 0, n);
            }
            //关闭文件输入流
            fis.close();
            bos.close();
            //将bos转换成字节数组。
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
