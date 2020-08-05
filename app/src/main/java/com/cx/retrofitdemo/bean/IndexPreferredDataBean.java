package com.cx.retrofitdemo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengxiao on 2018/12/13.
 */
public class IndexPreferredDataBean {

    private int ID;
    private String CertificationID;
    private int HouseType; //房源类型
    private double Price;  //价格
    private double UnitPrice; //单价
    private int CountF;  //室
    private int CountT; //厅
    private int CountW;  //卫
    private double ProducingArea;   //面积
    private String Title; //标题
    private String ImageUrl; //标题图
    private String DecorateTypeName;//装修
    private String OrientationName;  //朝向
    private String PurposeTypeName; //用途
    private String CompletionDateStr; //建成年代
    private String ListedTimeStr; //挂牌时间
    private String HasElevator; //电梯
    private String LadderHouseholds;  //梯户情况
    private String LastEditDateStr; //最后更新时间
    private String LouCengStr;  //楼层描述
    private String PriceUnit; //价格单位
    private double Longitude;  //经度
    private double Latitude;   //纬度
    private String XQAddress;//小区地址
    private String Furniture; //电器
    private String Payment; //押金

    private int BuildingID;
    private String BuildingName;
    private String AreaName;
    private String ShangQuanName;
    private String ListedTime;
    private String LastEditDate;
    private List<HouseGroupImgBean> HouseGroupImg;
    private List<MarkNameAndColorBean> MarkNameAndColor;
    private String AvgPriceUnit;
    private boolean IsVrHouse;
    private boolean IsTvHouse;
    private boolean IsFollow;
    public boolean isFollow() {
        return IsFollow;
    }

    public IndexPreferredDataBean setFollow(boolean follow) {
        IsFollow = follow;
        return this;
    }
    public boolean isTvHouse() {
        return IsTvHouse;
    }

    public IndexPreferredDataBean setTvHouse(boolean tvHouse) {
        IsTvHouse = tvHouse;
        return this;
    }

    public int getID() {
        return ID;
    }

    public IndexPreferredDataBean setID(int ID) {
        this.ID = ID;
        return this;
    }

    public String getCertificationID() {
        return CertificationID == null ? "" : CertificationID;
    }

    public IndexPreferredDataBean setCertificationID(String certificationID) {
        CertificationID = certificationID;
        return this;
    }

    public int getHouseType() {
        return HouseType;
    }

    public IndexPreferredDataBean setHouseType(int houseType) {
        HouseType = houseType;
        return this;
    }

    public double getPrice() {
        return Price;
    }

    public IndexPreferredDataBean setPrice(double price) {
        Price = price;
        return this;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public IndexPreferredDataBean setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
        return this;
    }

    public int getCountF() {
        return CountF;
    }

    public IndexPreferredDataBean setCountF(int countF) {
        CountF = countF;
        return this;
    }

    public int getCountT() {
        return CountT;
    }

    public IndexPreferredDataBean setCountT(int countT) {
        CountT = countT;
        return this;
    }

    public int getCountW() {
        return CountW;
    }

    public IndexPreferredDataBean setCountW(int countW) {
        CountW = countW;
        return this;
    }

    public double getProducingArea() {
        return ProducingArea;
    }

    public IndexPreferredDataBean setProducingArea(double producingArea) {
        ProducingArea = producingArea;
        return this;
    }

    public String getTitle() {
        return Title == null ? "" : Title;
    }

    public IndexPreferredDataBean setTitle(String title) {
        Title = title;
        return this;
    }

    public String getImageUrl() {
        return ImageUrl == null ? "" : ImageUrl;
    }

    public IndexPreferredDataBean setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
        return this;
    }

    public String getDecorateTypeName() {
        return DecorateTypeName == null ? "" : DecorateTypeName;
    }

    public IndexPreferredDataBean setDecorateTypeName(String decorateTypeName) {
        DecorateTypeName = decorateTypeName;
        return this;
    }

    public String getOrientationName() {
        return OrientationName == null ? "" : OrientationName;
    }

    public IndexPreferredDataBean setOrientationName(String orientationName) {
        OrientationName = orientationName;
        return this;
    }

    public String getPurposeTypeName() {
        return PurposeTypeName == null ? "" : PurposeTypeName;
    }

    public IndexPreferredDataBean setPurposeTypeName(String purposeTypeName) {
        PurposeTypeName = purposeTypeName;
        return this;
    }

    public String getCompletionDateStr() {
        return CompletionDateStr == null ? "" : CompletionDateStr;
    }

    public IndexPreferredDataBean setCompletionDateStr(String completionDateStr) {
        CompletionDateStr = completionDateStr;
        return this;
    }

    public String getListedTimeStr() {
        return ListedTimeStr == null ? "" : ListedTimeStr;
    }

    public IndexPreferredDataBean setListedTimeStr(String listedTimeStr) {
        ListedTimeStr = listedTimeStr;
        return this;
    }

    public String getHasElevator() {
        return HasElevator == null ? "" : HasElevator;
    }

    public IndexPreferredDataBean setHasElevator(String hasElevator) {
        HasElevator = hasElevator;
        return this;
    }

    public String getLadderHouseholds() {
        return LadderHouseholds == null ? "" : LadderHouseholds;
    }

    public IndexPreferredDataBean setLadderHouseholds(String ladderHouseholds) {
        LadderHouseholds = ladderHouseholds;
        return this;
    }

    public String getLastEditDateStr() {
        return LastEditDateStr == null ? "" : LastEditDateStr;
    }

    public IndexPreferredDataBean setLastEditDateStr(String lastEditDateStr) {
        LastEditDateStr = lastEditDateStr;
        return this;
    }

    public String getLouCengStr() {
        return LouCengStr == null ? "" : LouCengStr;
    }

    public IndexPreferredDataBean setLouCengStr(String louCengStr) {
        LouCengStr = louCengStr;
        return this;
    }

    public String getPriceUnit() {
        return PriceUnit == null ? "" : PriceUnit;
    }

    public IndexPreferredDataBean setPriceUnit(String priceUnit) {
        PriceUnit = priceUnit;
        return this;
    }

    public double getLongitude() {
        return Longitude;
    }

    public IndexPreferredDataBean setLongitude(double longitude) {
        Longitude = longitude;
        return this;
    }

    public double getLatitude() {
        return Latitude;
    }

    public IndexPreferredDataBean setLatitude(double latitude) {
        Latitude = latitude;
        return this;
    }

    public String getXQAddress() {
        return XQAddress == null ? "" : XQAddress;
    }

    public IndexPreferredDataBean setXQAddress(String XQAddress) {
        this.XQAddress = XQAddress;
        return this;
    }

    public String getFurniture() {
        return Furniture == null ? "" : Furniture;
    }

    public IndexPreferredDataBean setFurniture(String furniture) {
        Furniture = furniture;
        return this;
    }

    public String getPayment() {
        return Payment == null ? "" : Payment;
    }

    public IndexPreferredDataBean setPayment(String payment) {
        Payment = payment;
        return this;
    }

    public int getBuildingID() {
        return BuildingID;
    }

    public IndexPreferredDataBean setBuildingID(int buildingID) {
        BuildingID = buildingID;
        return this;
    }

    public String getBuildingName() {
        return BuildingName == null ? "" : BuildingName;
    }

    public IndexPreferredDataBean setBuildingName(String buildingName) {
        BuildingName = buildingName;
        return this;
    }

    public String getAreaName() {
        return AreaName == null ? "" : AreaName;
    }

    public IndexPreferredDataBean setAreaName(String areaName) {
        AreaName = areaName;
        return this;
    }

    public String getShangQuanName() {
        return ShangQuanName == null ? "" : ShangQuanName;
    }

    public IndexPreferredDataBean setShangQuanName(String shangQuanName) {
        ShangQuanName = shangQuanName;
        return this;
    }

    public String getListedTime() {
        return ListedTime == null ? "" : ListedTime;
    }

    public IndexPreferredDataBean setListedTime(String listedTime) {
        ListedTime = listedTime;
        return this;
    }

    public String getLastEditDate() {
        return LastEditDate == null ? "" : LastEditDate;
    }

    public IndexPreferredDataBean setLastEditDate(String lastEditDate) {
        LastEditDate = lastEditDate;
        return this;
    }

    public List<HouseGroupImgBean> getHouseGroupImg() {
        if (HouseGroupImg == null) {
            return new ArrayList<>();
        }
        return HouseGroupImg;
    }

    public IndexPreferredDataBean setHouseGroupImg(List<HouseGroupImgBean> houseGroupImg) {
        HouseGroupImg = houseGroupImg;
        return this;
    }

    public List<MarkNameAndColorBean> getMarkNameAndColor() {
        if (MarkNameAndColor == null) {
            return new ArrayList<>();
        }
        return MarkNameAndColor;
    }

    public IndexPreferredDataBean setMarkNameAndColor(List<MarkNameAndColorBean> markNameAndColor) {
        MarkNameAndColor = markNameAndColor;
        return this;
    }

    public String getAvgPriceUnit() {
        return AvgPriceUnit == null ? "" : AvgPriceUnit;
    }

    public IndexPreferredDataBean setAvgPriceUnit(String avgPriceUnit) {
        AvgPriceUnit = avgPriceUnit;
        return this;
    }

    public boolean isVrHouse() {
        return IsVrHouse;
    }

    public IndexPreferredDataBean setVrHouse(boolean vrHouse) {
        IsVrHouse = vrHouse;
        return this;
    }


    public static class MarkNameAndColorBean {
        /**
         * Name : 螃蟹岬
         * BgColor : #E7F7ED
         * Color : #12b04d
         */

        private String Name;
        private String BgColor;
        private String Color;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getBgColor() {
            return BgColor;
        }

        public void setBgColor(String BgColor) {
            this.BgColor = BgColor;
        }

        public String getColor() {
            return Color;
        }

        public void setColor(String Color) {
            this.Color = Color;
        }
    }

    public static class HouseGroupImgBean {
        /**
         * ImageTypeName :
         * GroupCount : 6
         * ImageUrlList : ["http://192.168.1.112:8011/display/f0c248f890dd78d049aa3e9912ced747.jpg","http://192.168.1.112:8011/display/0c3d0b3a09168b0fec9ca007aae8bcb7.jpg","http://192.168.1.112:8011/display/927e0bf69feb3428fde142e7e3fd1f3a.jpg","http://192.168.1.112:8011/display/f7e8959d6755c36d787f0a8075d97359.jpg","http://192.168.1.112:8011/display/536241406369e95403fb4421d076cb14.jpg","http://192.168.1.112:8011/display/40d15b2128492ce52d66148b5dbcce85.jpg"]
         */

        private String ImageTypeName;
        private int GroupCount;
        private List<String> ImageUrlList;

        public String getImageTypeName() {
            return ImageTypeName;
        }

        public void setImageTypeName(String ImageTypeName) {
            this.ImageTypeName = ImageTypeName;
        }

        public int getGroupCount() {
            return GroupCount;
        }

        public void setGroupCount(int GroupCount) {
            this.GroupCount = GroupCount;
        }

        public List<String> getImageUrlList() {
            return ImageUrlList;
        }

        public void setImageUrlList(List<String> ImageUrlList) {
            this.ImageUrlList = ImageUrlList;
        }
    }

    /**
     * ID : 2109
     * BuildingName : C端强推的楼盘
     * BuildingPrice : 10025元/平
     * Cover_Photo : http://img1.jjdc.net/display/9b7af6348d5e0d3e31e8ef5f5105aa0a.jpg
     * AreaName : 汉阳1
     * ShangQuanName : 五里墩
     * FeaturesNameAndColor : [{"Name":"在售","BgColor":"#77C964","Color":"#FFFFFF"},{"Name":"公园周边","BgColor":"#EDEFF2","Color":"#91A2A2"},{"Name":"低密居所","BgColor":"#EDEFF2","Color":"#91A2A2"},{"Name":"生态地产","BgColor":"#EDEFF2","Color":"#91A2A2"}]
     */

//    private int ID;
    private String Name;
    private String BuildingAvgPrice;
    private String Cover_Photo;
    //    private String AreaName;
//    private String ShangQuanName;
    private String ImgMark;
    private String ProjectTypeName;
    private String AreaRange;
    public String getAreaRange() {
        return AreaRange == null ? "" : AreaRange;
    }

    public IndexPreferredDataBean setAreaRange(String areaRange) {
        AreaRange = areaRange;
        return this;
    }
    public String getProjectTypeName() {
        return ProjectTypeName == null ? "" : ProjectTypeName;
    }

    public IndexPreferredDataBean setProjectTypeName(String projectTypeName) {
        ProjectTypeName = projectTypeName;
        return this;
    }
    private List<FeaturesNameAndColorBean> FeaturesNameAndColor;

    public String getImgMark() {
        return ImgMark == null ? "" : ImgMark;
    }

    public IndexPreferredDataBean setImgMark(String imgMark) {
        ImgMark = imgMark;
        return this;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBuildingAvgPrice() {
        return BuildingAvgPrice;
    }

    public void setBuildingAvgPrice(String BuildingAvgPrice) {
        this.BuildingAvgPrice = BuildingAvgPrice;
    }

    public String getCover_Photo() {
        return Cover_Photo == null ? "" : Cover_Photo;
    }

    public void setCover_Photo(String Cover_Photo) {
        this.Cover_Photo = Cover_Photo;
    }

//    public String getAreaName() {
//        return AreaName;
//    }
//
//    public void setAreaName(String AreaName) {
//        this.AreaName = AreaName;
//    }
//
//    public String getShangQuanName() {
//        return ShangQuanName;
//    }
//
//    public void setShangQuanName(String ShangQuanName) {
//        this.ShangQuanName = ShangQuanName;
//    }

    public List<FeaturesNameAndColorBean> getFeaturesNameAndColor() {
        return FeaturesNameAndColor;
    }

    public void setFeaturesNameAndColor(List<FeaturesNameAndColorBean> FeaturesNameAndColor) {
        this.FeaturesNameAndColor = FeaturesNameAndColor;
    }

    public static class FeaturesNameAndColorBean {
        /**
         * Name : 在售
         * BgColor : #77C964
         * Color : #FFFFFF
         */

        private String Name;
        private String BgColor;
        private String Color;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getBgColor() {
            return BgColor;
        }

        public void setBgColor(String BgColor) {
            this.BgColor = BgColor;
        }

        public String getColor() {
            return Color;
        }

        public void setColor(String Color) {
            this.Color = Color;
        }
    }

    @Override
    public String toString() {
        return "IndexPreferredDataBean{" +
                "ID=" + ID +
                ", CertificationID='" + CertificationID + '\'' +
                ", HouseType=" + HouseType +
                ", Price=" + Price +
                ", UnitPrice=" + UnitPrice +
                ", CountF=" + CountF +
                ", CountT=" + CountT +
                ", CountW=" + CountW +
                ", ProducingArea=" + ProducingArea +
                ", Title='" + Title + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", DecorateTypeName='" + DecorateTypeName + '\'' +
                ", OrientationName='" + OrientationName + '\'' +
                ", PurposeTypeName='" + PurposeTypeName + '\'' +
                ", CompletionDateStr='" + CompletionDateStr + '\'' +
                ", ListedTimeStr='" + ListedTimeStr + '\'' +
                ", HasElevator='" + HasElevator + '\'' +
                ", LadderHouseholds='" + LadderHouseholds + '\'' +
                ", LastEditDateStr='" + LastEditDateStr + '\'' +
                ", LouCengStr='" + LouCengStr + '\'' +
                ", PriceUnit='" + PriceUnit + '\'' +
                ", Longitude=" + Longitude +
                ", Latitude=" + Latitude +
                ", XQAddress='" + XQAddress + '\'' +
                ", Furniture='" + Furniture + '\'' +
                ", Payment='" + Payment + '\'' +
                ", BuildingID=" + BuildingID +
                ", BuildingName='" + BuildingName + '\'' +
                ", AreaName='" + AreaName + '\'' +
                ", ShangQuanName='" + ShangQuanName + '\'' +
                ", ListedTime='" + ListedTime + '\'' +
                ", LastEditDate='" + LastEditDate + '\'' +
                ", HouseGroupImg=" + HouseGroupImg +
                ", MarkNameAndColor=" + MarkNameAndColor +
                ", AvgPriceUnit='" + AvgPriceUnit + '\'' +
                ", IsVrHouse=" + IsVrHouse +
                ", IsTvHouse=" + IsTvHouse +
                ", Name='" + Name + '\'' +
                ", BuildingAvgPrice='" + BuildingAvgPrice + '\'' +
                ", Cover_Photo='" + Cover_Photo + '\'' +
                ", ImgMark='" + ImgMark + '\'' +
                ", ProjectTypeName='" + ProjectTypeName + '\'' +
                ", AreaRange='" + AreaRange + '\'' +
                ", FeaturesNameAndColor=" + FeaturesNameAndColor +
                '}';
    }
}
