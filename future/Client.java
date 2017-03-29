package future;

/**
 * @author hourui
 */
class Client {

    // 创建一个 Data
    static Data request(final String string) {
        System.out.println("试图构建一个RealData...");
        final FutureData futureData = new FutureData();

        new Thread(() -> {
            // RealData的构建很慢，所以放在单独的线程中运行
            RealData realData = new RealData(string);
            futureData.setRealData(realData);
        }).start();

        System.out.println("立即返回futureData");
        return futureData;
    }

}

