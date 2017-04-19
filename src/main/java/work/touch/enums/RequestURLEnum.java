package work.touch.enums;

/**
 * Created by Xu ZiPing on 2017/4/13.
 */
public enum RequestURLEnum {
    AUTO_LOGIN("http://gw.open.ppdai.com/auth/LoginService/AutoLogin"),

    BIDDING("http://gw.open.ppdai.com/invest/BidService/Bidding"),

    GET_LOAN_LIST("http://gw.open.ppdai.com/invest/LLoanInfoService/LoanList")
    ;

    private String url;

    RequestURLEnum(String url) {
        this.url =  url;
    }

    public String getUrl() {
        return url;
    }
}
