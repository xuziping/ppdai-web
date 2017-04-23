package work.touch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import work.touch.enums.RequestURLEnum;

import java.util.Date;

/**
 * Created by Xu ZiPing on 2017/4/13.
 */
@Service
public class PpdaiService {

    private final static Logger logger = LoggerFactory.getLogger(PpdaiService.class);

    public void login(){

    }

    public String autoLogin() throws  Exception{
        String token = null;
        logger.info("Call autoLogin");

        Result result = OpenApiClient.send(RequestURLEnum.AUTO_LOGIN, authInfo.getAccessToken(),
                new PropertyObject("Timestamp", new Date(), ValueTypeEnum.DateTime));
        if (result.isSucess()) {
            logger.info("Context: " + result.getContext());
            JSONObject json = new JSONObject(result.getContext());
            token = json.getString("Token");
            logger.info("Token: " + token);
        } else {
            logger.error("Error Msg: " + result.getErrorMessage());
        }

        return token;
    }

    public void bidding(long listingId, long amount) {
        try {
            Result result = OpenApiClient.send(BIDDING_URL, authInfo.getAccessToken(),
                    new PropertyObject("ListingId", listingId, ValueTypeEnum.Int16),
                    new PropertyObject("Amount", amount, ValueTypeEnum.Int16));
            if (result.isSucess()) {
                JSONObject json = new JSONObject(result.getContext());
                int resultCode = json.getInt("Result");
                if (resultCode != 0) {
                    String msg = "Failed to bidding, listingId: " + listingId;
                    switch (resultCode) {
                        case -1:
                            msg += " 未知异常, code: -1";
                            break;
                        case 1002:
                            msg += " 用户信息不存在, code: 1002";
                            break;
                        case 1001:
                            msg += " 用户编号异常, code: 1001";
                            break;
                        case 2001:
                            msg += " 标的编号异常, code: 2001";
                            break;
                        case 2002:
                            msg += " 标的不存在, code: 2002";
                            break;
                        case 3001:
                            msg += " 单笔投标金额只能是50-10000的整数, code: 3001";
                            break;
                        case 3002:
                            msg += " 累计投标金额不能＞20000元, code: 3002";
                            break;
                        case 3003:
                            msg += " 累计投标金额不能＞标的金额的30%, code: 3003";
                            break;
                        case 3004:
                            msg += " 不能给自己投标, code: 3004";
                            break;
                        case 3005:
                            msg += " 已满标, code: 3005";
                            break;
                        case 4001:
                            msg += " 账户余额不足，请先充值, code: 4001";
                            break;
                    }
                    logger.info(msg);
                    return;
                }
                long aListingId = json.getLong("ListingId");
                int aAmount = json.getInt("ParticipationAmount");
                logger.info("Bidding Successfully!! Actual Bidding ListingId: " + aListingId + ", Participation Amount: "
                        + aAmount);
                GOT_AMOUNT += aAmount;
                GOT_BIDDING_LISTING_IDS.add(aListingId);
            } else {
                logger.error("Error Msg: " + result.getErrorMessage());
            }
        } catch (Exception e) {
            logger.error("Failed", e);
        }
    }
}
