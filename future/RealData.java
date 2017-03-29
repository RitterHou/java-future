package future;

/**
 * @author hourui
 */
class RealData implements Data {

    private String data;

    RealData(String data) {
        // 利用sleep方法来表示RealData构造过程是非常缓慢的
        // 表示我们正在调用一个执行很慢的函数，它要很久才能返回
        try {
            System.out.println("RealData生成中...");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
    }

    @Override
    public String getResult() {
        return "RealData: " + data;
    }

}
