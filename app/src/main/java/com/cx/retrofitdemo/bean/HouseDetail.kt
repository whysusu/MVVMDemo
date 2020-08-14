package com.cx.retrofitdemo.bean
import com.google.gson.annotations.SerializedName


/**
 * @ClassName: HouseDetail
 * @Author: CX
 * @Date: 2020/8/14 15:25
 */
data class HouseDetail(
    @SerializedName("Code")
    val code: Int = 0, // 2000
    @SerializedName("Data")
    val `data`: Data = Data(),
    @SerializedName("Errors")
    val errors: String = "",
    @SerializedName("Msg")
    val msg: String = "", // 获取二手房详情成功。
    @SerializedName("Success")
    val success: Boolean = false // true
) {
    data class Data(
        @SerializedName("AgentInfo")
        val agentInfo: AgentInfo = AgentInfo(),
        @SerializedName("BuildInfo")
        val buildInfo: BuildInfo = BuildInfo(),
        @SerializedName("HouseImg")
        val houseImg: List<HouseImg> = listOf(),
        @SerializedName("HouseInfo")
        val houseInfo: HouseInfo = HouseInfo(),
        @SerializedName("IsComparison")
        val isComparison: Boolean = false, // false
        @SerializedName("IsFollow")
        val isFollow: Boolean = false, // false
        @SerializedName("SaleHouseNearClich")
        val saleHouseNearClich: SaleHouseNearClich = SaleHouseNearClich()
    ) {
        data class AgentInfo(
            @SerializedName("AgentName")
            val agentName: String = "", // 丁安澜很长的名字了哦
            @SerializedName("FeedbackInfo")
            val feedbackInfo: String = "", // 这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；这个房评的经纪人没有备案；
            @SerializedName("HouseSeeCount")
            val houseSeeCount: Int = 0, // 2
            @SerializedName("ID")
            val iD: Int = 0, // 0
            @SerializedName("ImageUrl")
            val imageUrl: String = "", // http://jjw-test1.oss-cn-shenzhen.aliyuncs.com/Image/Personnel/20190109/2fEmUwiGddMWt2fwTRQsoX.jpg?x-oss-process=style/w300_h300
            @SerializedName("LastSeeTime")
            val lastSeeTime: String = "", // 2020.01.10
            @SerializedName("SysCode")
            val sysCode: String = "" // 1712291518484A5BAA2D611C4724984D
        )

        data class BuildInfo(
            @SerializedName("AvgPrice")
            val avgPrice: Double = 0.0, // 10545.0
            @SerializedName("AvgPriceUnit")
            val avgPriceUnit: String = "", // 元/m²
            @SerializedName("BeApartFromMetro")
            val beApartFromMetro: Double = 0.0, // 20.0
            @SerializedName("BuildingCode")
            val buildingCode: Int = 0, // 16180
            @SerializedName("BuildingName")
            val buildingName: String = "", // 新新盘二零一九零一零五 经济适用房
            @SerializedName("BusSite")
            val busSite: String = "",
            @SerializedName("BusSiteDistance")
            val busSiteDistance: Double = 0.0, // 0.0
            @SerializedName("EsfNum")
            val esfNum: Int = 0, // 3
            @SerializedName("MetroName")
            val metroName: String = "", // 2号线
            @SerializedName("MetroSiteName")
            val metroSiteName: String = "" // 宝通寺
        )

        data class HouseImg(
            @SerializedName("CollectImageType")
            val collectImageType: Int = 0, // 0
            @SerializedName("GroupCount")
            val groupCount: Int = 0, // 1
            @SerializedName("ImageList")
            val imageList: List<Image> = listOf(),
            @SerializedName("ImageType")
            val imageType: Int = 0, // 11
            @SerializedName("ImageTypeName")
            val imageTypeName: String = "" // VR
        ) {
            data class Image(
                @SerializedName("CreatDate")
                val creatDate: String = "", // 2019-12-11T17:59:13.633
                @SerializedName("ImageUrl")
                val imageUrl: String = "", // http://appapi.t.jjw.com/images/fang_info.png
                @SerializedName("PhotoAddress")
                val photoAddress: String = "",
                @SerializedName("PhotoDevice")
                val photoDevice: String = "",
                @SerializedName("PhotoPerson")
                val photoPerson: String = "",
                @SerializedName("PhotoTime")
                val photoTime: String = ""
            )
        }

        data class HouseInfo(
            @SerializedName("AdvisoryAgentCnt")
            val advisoryAgentCnt: Int = 0, // 3
            @SerializedName("AdvisoryAgentImgList")
            val advisoryAgentImgList: List<AdvisoryAgentImg> = listOf(),
            @SerializedName("AreaName")
            val areaName: String = "", // 武昌
            @SerializedName("CertificationID")
            val certificationID: String = "", // JJWSF00100050163
            @SerializedName("CityID")
            val cityID: Int = 0, // 1
            @SerializedName("CompletionDateStr")
            val completionDateStr: String = "", // 2014 年
            @SerializedName("CountF")
            val countF: Int = 0, // 2
            @SerializedName("CountT")
            val countT: Int = 0, // 2
            @SerializedName("CountW")
            val countW: Int = 0, // 2
            @SerializedName("DecorateTypeName")
            val decorateTypeName: String = "", // 清水
            @SerializedName("FollowNum")
            val followNum: Int = 0, // 0
            @SerializedName("HasElevator")
            val hasElevator: String = "", // 有
            @SerializedName("HasLoan")
            val hasLoan: String = "", // 无贷款
            @SerializedName("HouseState")
            val houseState: Int = 0, // 4
            @SerializedName("HouseVRUrl")
            val houseVRUrl: String = "",
            @SerializedName("ID")
            val iD: Int = 0, // 486187
            @SerializedName("ImageUrl")
            val imageUrl: String = "", // https://img1.jjw.com/Image/House/20191211/3qGpW0F8VeXGfEfpsO4J3T.jpg?x-oss-process=style/w264_h198
            @SerializedName("IsVrHouse")
            val isVrHouse: Boolean = false, // false
            @SerializedName("LadderHouseholds")
            val ladderHouseholds: String = "", // 3梯6户
            @SerializedName("LandTime")
            val landTime: String = "", // 详见业主土地证明材料或相关政府部门登记文件
            @SerializedName("LastDealTimeStr")
            val lastDealTimeStr: String = "", // --
            @SerializedName("LastEditDateStr")
            val lastEditDateStr: String = "", // 2020.01.09
            @SerializedName("Latitude")
            val latitude: Double = 0.0, // 30.5365486
            @SerializedName("ListedTime")
            val listedTime: String = "", // 2019.12.12
            @SerializedName("Longitude")
            val longitude: Double = 0.0, // 114.347496
            @SerializedName("LouCengStr")
            val louCengStr: String = "", // 低/34层
            @SerializedName("MarkNameAndColor")
            val markNameAndColor: List<MarkNameAndColor> = listOf(),
            @SerializedName("OrientationName")
            val orientationName: String = "", // 南
            @SerializedName("Price")
            val price: Double = 0.0, // 66.0
            @SerializedName("PriceUnit")
            val priceUnit: String = "", // 万元
            @SerializedName("ProduceEvidence")
            val produceEvidence: String = "", // --
            @SerializedName("ProducingArea")
            val producingArea: Double = 0.0, // 66.36
            @SerializedName("PropertyRights")
            val propertyRights: String = "", // 房改房
            @SerializedName("PurposeTypeName")
            val purposeTypeName: String = "", // 住宅
            @SerializedName("RoomParts")
            val roomParts: String = "", // 未上传房本备件
            @SerializedName("SeeNum")
            val seeNum: Int = 0, // 5
            @SerializedName("SeeSevenNum")
            val seeSevenNum: Int = 0, // 0
            @SerializedName("ShangQuanID")
            val shangQuanID: Int = 0, // 246
            @SerializedName("ShangQuanName")
            val shangQuanName: String = "", // 徐家棚
            @SerializedName("ShareHouseVRUrl")
            val shareHouseVRUrl: Any = Any(), // null
            @SerializedName("ShareUrl")
            val shareUrl: String = "", // http://m.t.jjw.com/ershoufang/486187.html
            @SerializedName("SumFloor")
            val sumFloor: Int = 0, // 34
            @SerializedName("SysCode")
            val sysCode: String = "", // 1912111727175A792253BBA34D0A8A47
            @SerializedName("Title")
            val title: String = "", // 新新盘二零一九零一零五 经济适用房 2室2厅 随时看房
            @SerializedName("UnitPrice")
            val unitPrice: Double = 0.0, // 9946.0
            @SerializedName("XQAddress")
            val xQAddress: String = "" // 修改地址的哦，很久就是要变的，变了的
        ) {
            data class AdvisoryAgentImg(
                @SerializedName("AgentID")
                val agentID: Int = 0, // 0
                @SerializedName("AgentName")
                val agentName: Any = Any(), // null
                @SerializedName("AgentScore")
                val agentScore: Double = 0.0, // 0.0
                @SerializedName("AgentValidationID")
                val agentValidationID: Any = Any(), // null
                @SerializedName("AgentValidationQRUrl")
                val agentValidationQRUrl: Any = Any(), // null
                @SerializedName("BrandName")
                val brandName: Any = Any(), // null
                @SerializedName("BrandValidationID")
                val brandValidationID: Any = Any(), // null
                @SerializedName("BrandValidationQRUrl")
                val brandValidationQRUrl: Any = Any(), // null
                @SerializedName("CityID")
                val cityID: Int = 0, // 1
                @SerializedName("ClickNum")
                val clickNum: Int = 0, // 0
                @SerializedName("CreatDate")
                val creatDate: String = "", // 2020-08-14T15:24:21.833979+08:00
                @SerializedName("CzfNum")
                val czfNum: Int = 0, // 0
                @SerializedName("EnterprisePhone")
                val enterprisePhone: String = "",
                @SerializedName("EntryTime")
                val entryTime: String = "", // 0001-01-01T00:00:00
                @SerializedName("EsfNum")
                val esfNum: Int = 0, // 0
                @SerializedName("ExtensionNumber")
                val extensionNumber: String = "",
                @SerializedName("FeedbackRate")
                val feedbackRate: Int = 0, // 0
                @SerializedName("ID")
                val iD: Int = 0, // 4867
                @SerializedName("ImageUrl")
                val imageUrl: String = "", // http://jjw-personnel.oss-cn-shenzhen.aliyuncs.com/Image/Personnel/de5ff2bdd0e4a81431c1383661a7f7c0.jpg?x-oss-process=style/w300_h300
                @SerializedName("IsConfinement")
                val isConfinement: Int = 0, // 0
                @SerializedName("IsDel")
                val isDel: Int = 0, // 0
                @SerializedName("IsDel_Time")
                val isDelTime: Any = Any(), // null
                @SerializedName("LastEditDate")
                val lastEditDate: String = "", // 2020-08-14T15:24:21.833979+08:00
                @SerializedName("Mobile")
                val mobile: Any = Any(), // null
                @SerializedName("PromoCode")
                val promoCode: String = "",
                @SerializedName("ServeNum")
                val serveNum: Int = 0, // 0
                @SerializedName("StoreID")
                val storeID: Any = Any(), // null
                @SerializedName("SysCode")
                val sysCode: Any = Any(), // null
                @SerializedName("WeiXinCode")
                val weiXinCode: Any = Any(), // null
                @SerializedName("WeiXinImg")
                val weiXinImg: Any = Any(), // null
                @SerializedName("WeiXinServicesID")
                val weiXinServicesID: Int = 0, // -1
                @SerializedName("WeiXinServicesImg")
                val weiXinServicesImg: String = ""
            )

            data class MarkNameAndColor(
                @SerializedName("BgColor")
                val bgColor: String = "", // #EDF0F2
                @SerializedName("Color")
                val color: String = "", // #4C4C4C
                @SerializedName("Name")
                val name: String = "" // VR房源
            )
        }

        data class SaleHouseNearClich(
            @SerializedName("AreaName")
            val areaName: String = "", // 武昌
            @SerializedName("CountF")
            val countF: Int = 0, // 3
            @SerializedName("CountT")
            val countT: Int = 0, // 1
            @SerializedName("CountW")
            val countW: Int = 0, // 3
            @SerializedName("ImageUrl")
            val imageUrl: String = "", // http://appapi.t.jjw.com/images/fang_list.png
            @SerializedName("Price")
            val price: Double = 0.0, // 12.3
            @SerializedName("PriceUnit")
            val priceUnit: String = "", // 万元
            @SerializedName("ProducingArea")
            val producingArea: Double = 0.0, // 666.0
            @SerializedName("ShangQuanName")
            val shangQuanName: String = "", // 徐家棚
            @SerializedName("SysCode")
            val sysCode: String = "", // 1912161402278832BA03E26C49EFA467
            @SerializedName("Title")
            val title: String = "" // 别墅测试
        )
    }
}