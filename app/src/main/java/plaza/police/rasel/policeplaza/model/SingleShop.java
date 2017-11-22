package plaza.police.rasel.policeplaza.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jacosrasel on 11/21/2017.
 */

public class SingleShop  implements Parcelable {

    String RealOwner;
    String TenantsName;
    String ShopNO;
    String FloorNo;
    String FloorIconName;
    String ShopName;
    String ItemsofShop;
    String catIconName;
    String marginLeft;
    String marginRight;
    String shopImageOneName;
    String shopImageTwoName;
    String shopImageThreeName;
    String ShopStatus;

    public SingleShop(String realOwner, String tenantsName, String shopNO, String floorNo, String floorIconName, String shopName, String itemsofShop, String catIconName, String marginLeft, String marginRight, String shopImageOneName, String shopImageTwoName, String shopImageThreeName, String shopStatus) {
        RealOwner = realOwner;
        TenantsName = tenantsName;
        ShopNO = shopNO;
        FloorNo = floorNo;
        FloorIconName = floorIconName;
        ShopName = shopName;
        ItemsofShop = itemsofShop;
        this.catIconName = catIconName;
        this.marginLeft = marginLeft;
        this.marginRight = marginRight;
        this.shopImageOneName = shopImageOneName;
        this.shopImageTwoName = shopImageTwoName;
        this.shopImageThreeName = shopImageThreeName;
        ShopStatus = shopStatus;
    }

    protected SingleShop(Parcel in) {
        RealOwner = in.readString();
        TenantsName = in.readString();
        ShopNO = in.readString();
        FloorNo = in.readString();
        FloorIconName = in.readString();
        ShopName = in.readString();
        ItemsofShop = in.readString();
        catIconName = in.readString();
        marginLeft = in.readString();
        marginRight = in.readString();
        shopImageOneName = in.readString();
        shopImageTwoName = in.readString();
        shopImageThreeName = in.readString();
        ShopStatus = in.readString();
    }

    public static final Creator<SingleShop> CREATOR = new Creator<SingleShop>() {
        @Override
        public SingleShop createFromParcel(Parcel in) {
            return new SingleShop(in);
        }

        @Override
        public SingleShop[] newArray(int size) {
            return new SingleShop[size];
        }
    };

    public String getRealOwner() {
        return RealOwner;
    }

    public void setRealOwner(String realOwner) {
        RealOwner = realOwner;
    }

    public String getTenantsName() {
        return TenantsName;
    }

    public void setTenantsName(String tenantsName) {
        TenantsName = tenantsName;
    }

    public String getShopNO() {
        return ShopNO;
    }

    public void setShopNO(String shopNO) {
        ShopNO = shopNO;
    }

    public String getFloorNo() {
        return FloorNo;
    }

    public void setFloorNo(String floorNo) {
        FloorNo = floorNo;
    }

    public String getFloorIconName() {
        return FloorIconName;
    }

    public void setFloorIconName(String floorIconName) {
        FloorIconName = floorIconName;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getItemsofShop() {
        return ItemsofShop;
    }

    public void setItemsofShop(String itemsofShop) {
        ItemsofShop = itemsofShop;
    }

    public String getCatIconName() {
        return catIconName;
    }

    public void setCatIconName(String catIconName) {
        this.catIconName = catIconName;
    }

    public String getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(String marginLeft) {
        this.marginLeft = marginLeft;
    }

    public String getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(String marginRight) {
        this.marginRight = marginRight;
    }

    public String getShopImageOneName() {
        return shopImageOneName;
    }

    public void setShopImageOneName(String shopImageOneName) {
        this.shopImageOneName = shopImageOneName;
    }

    public String getShopImageTwoName() {
        return shopImageTwoName;
    }

    public void setShopImageTwoName(String shopImageTwoName) {
        this.shopImageTwoName = shopImageTwoName;
    }

    public String getShopImageThreeName() {
        return shopImageThreeName;
    }

    public void setShopImageThreeName(String shopImageThreeName) {
        this.shopImageThreeName = shopImageThreeName;
    }

    public String getShopStatus() {
        return ShopStatus;
    }

    public void setShopStatus(String shopStatus) {
        ShopStatus = shopStatus;
    }

    @Override
    public String toString() {
        return "SingleShop{" +
                "RealOwner='" + RealOwner + '\'' +
                ", TenantsName='" + TenantsName + '\'' +
                ", ShopNO='" + ShopNO + '\'' +
                ", FloorNo='" + FloorNo + '\'' +
                ", FloorIconName='" + FloorIconName + '\'' +
                ", ShopName='" + ShopName + '\'' +
                ", ItemsofShop='" + ItemsofShop + '\'' +
                ", catIconName='" + catIconName + '\'' +
                ", marginLeft='" + marginLeft + '\'' +
                ", marginRight='" + marginRight + '\'' +
                ", shopImageOneName='" + shopImageOneName + '\'' +
                ", shopImageTwoName='" + shopImageTwoName + '\'' +
                ", shopImageThreeName='" + shopImageThreeName + '\'' +
                ", ShopStatus='" + ShopStatus + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(RealOwner);
        dest.writeString(TenantsName);
        dest.writeString(ShopNO);
        dest.writeString(FloorNo);
        dest.writeString(FloorIconName);
        dest.writeString(ShopName);
        dest.writeString(ItemsofShop);
        dest.writeString(catIconName);
        dest.writeString(marginLeft);
        dest.writeString(marginRight);
        dest.writeString(shopImageOneName);
        dest.writeString(shopImageTwoName);
        dest.writeString(shopImageThreeName);
        dest.writeString(ShopStatus);
    }
}
