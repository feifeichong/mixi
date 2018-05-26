package com.lecotec.mixi.model.parameter;

import com.lecotec.mixi.model.entity.Merchant;
import com.lecotec.mixi.model.entity.Station;

public class StationParam extends Station {
    private long merchantId;

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
        super.setMerchant(new Merchant() {{
            this.setId(merchantId);
        }});
    }
}
