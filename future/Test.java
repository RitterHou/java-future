package future;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Data data = Client.request("真实的结果");
        System.out.println("后台已经开始异步处理数据了，这个时候干点什么好呢，不如果傻傻的等2s钟吧ʅ（´◔౪◔）ʃ");
        System.out.println("查看真实数据返回（如果还没有返回堵塞等待）= " + data.getResult());
    }
}
