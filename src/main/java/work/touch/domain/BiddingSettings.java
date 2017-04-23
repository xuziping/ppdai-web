package work.touch.domain;

/**
 * Created by Kxu on 2017/4/22.
 */
public class BiddingSettings {

    private Integer totalAmount;

    private Integer eachAmount1;

    private Integer targetRate1;

    private Integer eachAmount2;

    private Integer targetRate2;

    private Integer sleepTime;

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getEachAmount1() {
        return eachAmount1;
    }

    public void setEachAmount1(Integer eachAmount1) {
        this.eachAmount1 = eachAmount1;
    }

    public Integer getTargetRate1() {
        return targetRate1;
    }

    public void setTargetRate1(Integer targetRate1) {
        this.targetRate1 = targetRate1;
    }

    public Integer getEachAmount2() {
        return eachAmount2;
    }

    public void setEachAmount2(Integer eachAmount2) {
        this.eachAmount2 = eachAmount2;
    }

    public Integer getTargetRate2() {
        return targetRate2;
    }

    public void setTargetRate2(Integer targetRate2) {
        this.targetRate2 = targetRate2;
    }

    public Integer getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Integer sleepTime) {
        this.sleepTime = sleepTime;
    }
}
