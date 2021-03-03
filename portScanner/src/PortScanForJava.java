import java.util.Scanner;

public class PortScanForJava {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            Port_Scanner scanner1 = new Port_Scanner();
            System.out.println("+---------------------------------------------------------------------+");
            System.out.println("+---------------------------5329的端口扫描程序：--------------------------+");
            System.out.println("+----------------------------------------------------------------------+");
            System.out.println("+----------------------------1.常用端口扫描------------------------------+");
            System.out.println("+----------------------------2.自定义端口扫描-----------------------------+");
            String type = scanner.nextLine();
            if (type.equals("1")){
                scanner1.CommonPortsScan();
            }else if (type.equals("2")){
                scanner1.SelfMakePortScann();
            }
        }
    }
}
