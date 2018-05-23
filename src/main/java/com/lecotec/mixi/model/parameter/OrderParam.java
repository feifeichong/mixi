package com.lecotec.mixi.model.parameter;

import com.alibaba.fastjson.JSON;
import com.lecotec.mixi.model.entity.Customer;
import com.lecotec.mixi.model.entity.Order;
import com.lecotec.mixi.model.entity.Rider;
import com.lecotec.mixi.model.entity.Station;

public class OrderParam extends Order {
    private GoodsList[] goodsList;
    private long customerId;
    private long stationId;
    private long riderId;

    public GoodsList[] getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(GoodsList[] goodsList) {
        this.goodsList = goodsList;
        super.setGoodsJsonList(JSON.toJSONString(this.goodsList));
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
        super.setCustomer(new Customer() {
            {
                setId(customerId);
            }
        });
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
        super.setStation(new Station() {
            {
                setId(stationId);
            }
        });
    }

    public long getRiderId() {
        return riderId;
    }

    public void setRiderId(long riderId) {
        this.riderId = riderId;
        super.setRider(new Rider() {
            {
                setId(riderId);
            }
        });
    }

    private static class GoodsList {
        private long goodsId;
        private int count;
        private double price;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public long getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(long goodsId) {
            this.goodsId = goodsId;
        }
    }
}
