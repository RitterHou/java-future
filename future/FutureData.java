package future;

/**
 * @author hourui
 */
class FutureData implements Data {

    private RealData realData;

    // 是否已经设置了realData
    private boolean isReady = false;

    synchronized void setRealData(RealData realData) {
        if (isReady) // 如果已经设置了RealData，那么直接返回就可以了
            return;
        System.out.println("开始在FutureData中设置RealData的数据...");
        this.realData = realData;
        isReady = true;
        System.out.println("FutureData中已经设置好了RealData数据了");
        notifyAll();
    }

    @Override
    public synchronized String getResult() throws InterruptedException {
        if (!isReady) {
            System.out.println("FutureData中的RealData还没有设置好，等待ing");
            wait(); // 一直等到RealData注入到FutureData中
            System.out.println("RealData已经被设置到FutureData中了");
        }
        return realData.getResult();
    }

}
