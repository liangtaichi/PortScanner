import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Port_Scanner {
    public void CommonPortsScan(){
        int[] port = new int[]{
                21, 22, 23, 80, 8080, 88, 8888, 3306, 3389, 3312, 445, 443, 1433
        };//设置需要扫描的端口
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入需要扫描的IP：");
        String url = scan.next();

        try {//将域名转换成IP的格式进行扫描
            InetAddress[] addresses = InetAddress.getAllByName(url);
            for (int i = 0; i < addresses.length; i++) {
                System.out.println("[正在给IP:" + addresses[i].getHostAddress()+"端口扫描]");
            }
        } catch (UnknownHostException uhe) {
            System.out.println("找不到该端口！");
        }

        try {
            InetAddress getname = InetAddress.getByName(url);
        } catch (UnknownHostException var10) {
            System.out.println("无法找到 " + url);//判断url是否正确
            return;
        }

        for(int nport:port){//使用foreach语句循环端口扫描
            try {
                System.out.print("[+]" + nport);
                Socket sock = new Socket(url, nport);
                System.out.println(" : open");
                switch(nport) { //出现常见端口记录下来
                    case 21:
                        System.out.println("此IP疑似开启了FTP服务");
                        break;
                    case 22:
                        System.out.println("此IP疑似开启了SSH服务");
                        break;
                    case 23:
                        System.out.println("此IP疑似开启了Telnet 服务 ");
                        break;
                    case 80:
                        System.out.println("此IP疑似开启了WEB服务");
                        break;
                    case 88:
                        System.out.println("此IP疑似开启了Kerberos 网络验证系统服务");
                        break;
                    case 443:
                        System.out.println("此IP疑似开启了HTTPS服务");
                        break;
                    case 445:
                        System.out.println("此IP疑似开启了SMB服务");
                        break;
                    case 1433:
                        System.out.println("此IP疑似开启了SQL server服务");
                        break;
                    case 3306:
                        System.out.println("此IP疑似开启了MySQL服务");
                        break;
                    case 3312:
                        System.out.println("此IP疑似开启了Kangle服务");
                        break;
                    case 3389:
                        System.out.println("此IP疑似开启了RDP服务");
                        break;
                    case 8080:
                        System.out.println("此IP疑似开启了万维网（WWW）缓存服务 ");
                }
            } catch (IOException var9) {
                System.out.println("：close");
            }
        }

        System.out.println("---------------------");
        System.out.println("扫描完成。");
    }
    public void SelfMakePortScann(){
        System.out.println("请输入你要扫描的ip地址：");
        Scanner scan = new Scanner(System.in);
        String url = scan.next();
        System.out.println("请输入要扫描的端口号（用‘,’隔开，例子1,655）：");
        System.out.println("备注：端口的有效范围是1~65535");
        String[] portRage = scan.next().split(",");
        int low = Integer.parseInt(portRage[0]);
        int high = Integer.parseInt(portRage[1]);
        int[] port = new int[high-low];
        for (int i = 0; i < high-low-1; i++) {
            port[i] = low + i;
        }
        try {//将域名转换成IP的格式进行扫描
            InetAddress[] addresses = InetAddress.getAllByName(url);
            for (int i = 0; i < addresses.length; i++) {
                System.out.println("[正在给IP:" + addresses[i].getHostAddress()+"端口扫描]");
                System.out.println("扫描范围："+low+"到"+high+" ,一共"+(high-low)+"个");
            }
        } catch (UnknownHostException uhe) {
            System.out.println("找不到该端口！");
        }
        try {
            InetAddress getname = InetAddress.getByName(url);
        } catch (UnknownHostException var10) {
            System.out.println("无法找到 " + url);//判断url是否正确
            return;
        }

        for(int i = 0; i < high-low+1;i++){
            try {
                System.out.print("[+]" + (low+i));
                Socket sock = new Socket(url, low+i);
                System.out.println(" : open");
            } catch (IOException var9) {
                System.out.println("：close");
            }
        }
        System.out.println("---------------------");
        System.out.println("扫描完成。");
    }
}

