package com.cx.retrofitdemo.bean
import com.google.gson.annotations.SerializedName


/**
 * @ClassName: NewHouseBean
 * @Author: CX
 * @Date: 2020/7/27 12:01
 */
data class NewHouseBean(
    @SerializedName("Code")
    val code: Int = 0, // 2000
    @SerializedName("Data")
    val `data`: Data = Data(),
    @SerializedName("Errors")
    val errors: String = "",
    @SerializedName("Msg")
    val msg: String = "", // 请求成功
    @SerializedName("Success")
    val success: Boolean = false // true
) {
    data class Data(
        @SerializedName("Address")
        val address: String = "", // 安静安静
        @SerializedName("AgentInfo")
        val agentInfo: AgentInfo = AgentInfo(),
        @SerializedName("Agents")
        val agents: List<Agent> = listOf(),
        @SerializedName("Architecture_area")
        val architectureArea: String = "",
        @SerializedName("Area_covered")
        val areaCovered: String = "",
        @SerializedName("Area_ID")
        val areaID: Int = 0, // 167
        @SerializedName("AreaName")
        val areaName: String = "", // 栖贤区
        @SerializedName("AreaPinYin")
        val areaPinYin: String = "", // qixianqu
        @SerializedName("AreaRange")
        val areaRange: String = "", // 暂无
        @SerializedName("BuildingAvgPrice")
        val buildingAvgPrice: String = "", // 价格待定
        @SerializedName("Buildingimage")
        val buildingimage: List<Any> = listOf(),
        @SerializedName("CityID")
        val cityID: Int = 0, // 51
        @SerializedName("CoustomActivities")
        val coustomActivities: Any = Any(), // null
        @SerializedName("Cover_Photo")
        val coverPhoto: String = "", // http://jjw-test.oss-cn-shenzhen.aliyuncs.com/buildingPicture/20200612/20jg6e3qVaTVXMmjzzryaA1591949799290.jpg?x-oss-process=style/w360_h270_s
        @SerializedName("Decoration_standard")
        val decorationStandard: String = "", // 暂无
        @SerializedName("Developer")
        val developer: String = "",
        @SerializedName("FixedActivities")
        val fixedActivities: Any = Any(), // null
        @SerializedName("Floor_condition")
        val floorCondition: String = "",
        @SerializedName("GoodBuildings")
        val goodBuildings: List<GoodBuilding> = listOf(),
        @SerializedName("HXBuildingimage")
        val hXBuildingimage: List<Any> = listOf(),
        @SerializedName("HouseTVUrl")
        val houseTVUrl: Any = Any(), // null
        @SerializedName("HouseVRUrl")
        val houseVRUrl: Any = Any(), // null
        @SerializedName("HuXingStr")
        val huXingStr: String = "", // 暂无
        @SerializedName("HxKindName")
        val hxKindName: String = "",
        @SerializedName("HxNum")
        val hxNum: Int = 0, // 0
        @SerializedName("ID")
        val iD: Int = 0, // 2564
        @SerializedName("ImgTypes")
        val imgTypes: List<Any> = listOf(),
        @SerializedName("Investors")
        val investors: String = "",
        @SerializedName("IsFollow")
        val isFollow: Int = 0, // 0
        @SerializedName("IsNewHouseIM")
        val isNewHouseIM: Int = 0, // 1
        @SerializedName("jijia_start_time")
        val jijiaStartTime: String = "", // 2020-06-12T16:31:03Z
        @SerializedName("Latitude")
        val latitude: Double = 0.0, // 30.789034
        @SerializedName("Longitude")
        val longitude: Double = 0.0, // 115.407204
        @SerializedName("Mark")
        val mark: List<Mark> = listOf(),
        @SerializedName("Mobile")
        val mobile: String = "", // 18696132295
        @SerializedName("MobileMark")
        val mobileMark: String = "", // 电话咨询
        @SerializedName("Name")
        val name: String = "", // 风风火火
        @SerializedName("NewHouseAvgPrice")
        val newHouseAvgPrice: String = "", // 价格待定
        @SerializedName("NewHouseAvgPriceUnit")
        val newHouseAvgPriceUnit: String = "",
        @SerializedName("NewHouseDynamic")
        val newHouseDynamic: NewHouseDynamic = NewHouseDynamic(),
        @SerializedName("Number_Of_Floor")
        val numberOfFloor: String = "",
        @SerializedName("Number_of_parking_spaces")
        val numberOfParkingSpaces: String = "",
        @SerializedName("Parking_ratio")
        val parkingRatio: String = "",
        @SerializedName("Project_Profile")
        val projectProfile: String = "",
        @SerializedName("Project_progress")
        val projectProgress: String = "",
        @SerializedName("Project_StateID")
        val projectStateID: Int = 0, // 1
        @SerializedName("Project_StateName")
        val projectStateName: String = "", // 在售
        @SerializedName("Project_Type")
        val projectType: String = "", // 1
        @SerializedName("Project_TypeName")
        val projectTypeName: String = "", // 住宅
        @SerializedName("Property_Company")
        val propertyCompany: String = "",
        @SerializedName("Property_cost")
        val propertyCost: String = "",
        @SerializedName("ShangQuanName")
        val shangQuanName: String = "", // 育才
        @SerializedName("ShangQuanPinYin")
        val shangQuanPinYin: String = "", // yucai
        @SerializedName("ShareUrl")
        val shareUrl: String = "", // http://m.t.jjw.com/luotian/loupan-share/2564.html
        @SerializedName("Specific_Opening_Time")
        val specificOpeningTime: String = "", // 2020-06-01
        @SerializedName("TotalPrice")
        val totalPrice: String = "", // 价格待定
        @SerializedName("TotalPriceStr")
        val totalPriceStr: String = "", // 价格待定
        @SerializedName("TotalPriceUnit")
        val totalPriceUnit: String = "",
        @SerializedName("ViolationType")
        val violationType: Int = 0, // 0
        @SerializedName("Volumetric_rate")
        val volumetricRate: String = "",
        @SerializedName("Years_of_property_rights")
        val yearsOfPropertyRights: String = "",
        @SerializedName("ZXFViolationType")
        val zXFViolationType: Int = 0 // 0
    ) {
        data class AgentInfo(
            @SerializedName("E_Guid")
            val eGuid: String = "", // 70820970919511e986c000163e12124b
            @SerializedName("E_HeadImg")
            val eHeadImg: String = "", // http://jjw-test.oss-cn-shenzhen.aliyuncs.com/buildingPicture/20200619/2oHiHKZPt3EX62VjZGz5y51592554375100.jpg?x-oss-process=style/w300_h300
            @SerializedName("E_Id")
            val eId: Int = 0, // 180
            @SerializedName("E_Name")
            val eName: String = "", // U+专员
            @SerializedName("IsAgent")
            val isAgent: Int = 0, // 0
            @SerializedName("Mobile")
            val mobile: String = "", // 18696132295
            @SerializedName("MobileMark")
            val mobileMark: String = "", // 电话咨询
            @SerializedName("ServiceTimesMark")
            val serviceTimesMark: String = "" // 带看此项目1次
        )

        data class Agent(
            @SerializedName("E_Guid")
            val eGuid: String = "", // 2005281432334AE4C6FF8B064F7AB9A7
            @SerializedName("E_HeadImg")
            val eHeadImg: String = "", // http://jjw-personnel.oss-cn-shenzhen.aliyuncs.com/Image/Personnel/20200624/3CZnkSO7p5LFhxVWSgByAA.png?x-oss-process=style/w300_h300
            @SerializedName("E_Id")
            val eId: Int = 0, // 49945
            @SerializedName("E_Name")
            val eName: String = "", // 经纪人A1甲
            @SerializedName("IsAgent")
            val isAgent: Int = 0, // 1
            @SerializedName("Mobile")
            val mobile: String = "", // 13345879525
            @SerializedName("MobileMark")
            val mobileMark: String = "", // 13345879525
            @SerializedName("ServiceTimesMark")
            val serviceTimesMark: String = "" // 带看此项目3次
        )

        data class GoodBuilding(
            @SerializedName("AreaName")
            val areaName: String = "", // 栖贤区
            @SerializedName("AreaRange")
            val areaRange: String = "", // 建面80.26-120.73㎡
            @SerializedName("BuildingAvgPrice")
            val buildingAvgPrice: String = "", // 价格待定
            @SerializedName("City_ID")
            val cityID: Int = 0, // 51
            @SerializedName("Cover_Photo")
            val coverPhoto: String = "", // http://jjw-test.oss-cn-shenzhen.aliyuncs.com/buildingPicture/20200612/20jg6e3qVaTVXMmjzzryaA1591949799290.jpg?x-oss-process=style/w360_h270_s
            @SerializedName("FeaturesNameAndColor")
            val featuresNameAndColor: List<FeaturesNameAndColor> = listOf(),
            @SerializedName("HouseTVUrl")
            val houseTVUrl: Any = Any(), // null
            @SerializedName("ID")
            val iD: Int = 0, // 3012
            @SerializedName("IsTvHouse")
            val isTvHouse: Boolean = false, // false
            @SerializedName("Name")
            val name: String = "", // 风风火火
            @SerializedName("NewHouseAvgPrice")
            val newHouseAvgPrice: Double = 0.0, // -1.0
            @SerializedName("ProjectTypeName")
            val projectTypeName: String = "", // 住宅
            @SerializedName("ShangQuanName")
            val shangQuanName: String = "" // 育才
        ) {
            data class FeaturesNameAndColor(
                @SerializedName("BgColor")
                val bgColor: String = "", // #77C964
                @SerializedName("Color")
                val color: String = "", // #FFFFFF
                @SerializedName("Name")
                val name: String = "" // 在售
            )
        }

        data class Mark(
            @SerializedName("BgColor")
            val bgColor: String = "", // #77C964
            @SerializedName("Color")
            val color: String = "", // #FFFFFF
            @SerializedName("Name")
            val name: String = "" // 在售
        )

        data class NewHouseDynamic(
            @SerializedName("List")
            val list: Any = Any(), // null
            @SerializedName("TotalCount")
            val totalCount: Int = 0 // 0
        )
    }
}

