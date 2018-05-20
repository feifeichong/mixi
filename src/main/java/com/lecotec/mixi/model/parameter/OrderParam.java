package com.lecotec.mixi.model.parameter;

import com.alibaba.fastjson.JSON;
import com.lecotec.mixi.model.entity.Order;

public class OrderParam extends Order {
    private StationInfo stationInfoJson;
    private CustomerInfo customerInfoJson;
    private CostDetail costDetailJson;
    private GoodsList[] goodsListJsons;
    private ReceiverInfo receiverInfoJson;
    private RiderInfo riderInfoJson;

    public StationInfo getStationInfoJson() {
        return stationInfoJson;
    }

    public void setStationInfoJson(StationInfo stationInfoJson) {
        this.stationInfoJson = stationInfoJson;
        this.setStationInfo(JSON.toJSONString(stationInfoJson));
    }

    public CustomerInfo getCustomerInfoJson() {
        return customerInfoJson;
    }

    public void setCustomerInfoJson(CustomerInfo customerInfoJson) {
        this.customerInfoJson = customerInfoJson;
        this.setCustomerInfo(JSON.toJSONString(customerInfoJson));
    }

    public CostDetail getCostDetailJson() {
        return costDetailJson;
    }

    public void setCostDetailJson(CostDetail costDetailJson) {
        this.costDetailJson = costDetailJson;
        this.setCostDetail(JSON.toJSONString(costDetailJson));
    }

    public GoodsList[] getGoodsListJsons() {
        return goodsListJsons;
    }

    public void setGoodsListJsons(GoodsList[] goodsListJsons) {
        this.goodsListJsons = goodsListJsons;
        this.setGoodsList(JSON.toJSONString(goodsListJsons));
    }

    public ReceiverInfo getReceiverInfoJson() {
        return receiverInfoJson;
    }

    public void setReceiverInfoJson(ReceiverInfo receiverInfoJson) {
        this.receiverInfoJson = receiverInfoJson;
        this.setReceiverInfo(JSON.toJSONString(receiverInfoJson));
    }

    public RiderInfo getRiderInfoJson() {
        return riderInfoJson;
    }

    public void setRiderInfoJson(RiderInfo riderInfoJson) {
        this.riderInfoJson = riderInfoJson;
        this.setRiderInfo(JSON.toJSONString(riderInfoJson));
    }

    private static class StationInfo {
        private long id;
        private String name;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static class CustomerInfo {
        private long id;
        private String phoneNumber;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

    private static class CostDetail {
        private double goodsTotalPrice;
        private double firstOrderReducion;
        private double fullReducion;
        private double onlinePayReducion;
        private double mealBoxPrice;
        private double sendPrice;
        private double totalOrderPrice;
        private double realOrderPrice;

        public double getGoodsTotalPrice() {
            return goodsTotalPrice;
        }

        public void setGoodsTotalPrice(double goodsTotalPrice) {
            this.goodsTotalPrice = goodsTotalPrice;
        }

        public double getFirstOrderReducion() {
            return firstOrderReducion;
        }

        public void setFirstOrderReducion(double firstOrderReducion) {
            this.firstOrderReducion = firstOrderReducion;
        }

        public double getFullReducion() {
            return fullReducion;
        }

        public void setFullReducion(double fullReducion) {
            this.fullReducion = fullReducion;
        }

        public double getOnlinePayReducion() {
            return onlinePayReducion;
        }

        public void setOnlinePayReducion(double onlinePayReducion) {
            this.onlinePayReducion = onlinePayReducion;
        }

        public double getMealBoxPrice() {
            return mealBoxPrice;
        }

        public void setMealBoxPrice(double mealBoxPrice) {
            this.mealBoxPrice = mealBoxPrice;
        }

        public double getSendPrice() {
            return sendPrice;
        }

        public void setSendPrice(double sendPrice) {
            this.sendPrice = sendPrice;
        }

        public double getTotalOrderPrice() {
            return totalOrderPrice;
        }

        public void setTotalOrderPrice(double totalOrderPrice) {
            this.totalOrderPrice = totalOrderPrice;
        }

        public double getRealOrderPrice() {
            return realOrderPrice;
        }

        public void setRealOrderPrice(double realOrderPrice) {
            this.realOrderPrice = realOrderPrice;
        }
    }

    private static class GoodsList {
        private long id;
        private String goodsTypeName;
        private String name;
        private String imagePath;
        private String specsName;
        private int count;
        private String price;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getGoodsTypeName() {
            return goodsTypeName;
        }

        public void setGoodsTypeName(String goodsTypeName) {
            this.goodsTypeName = goodsTypeName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getSpecsName() {
            return specsName;
        }

        public void setSpecsName(String specsName) {
            this.specsName = specsName;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }

    private static class ReceiverInfo {
        private String name;
        private String phoneNumber;
        private String address;
        private String remark;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    private static class RiderInfo {
        private long id;
        private String name;
        private String phoneNumber;
        private String stationName;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }
    }
}
