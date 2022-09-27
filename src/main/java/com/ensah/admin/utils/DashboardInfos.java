package com.ensah.admin.utils;



public class DashboardInfos {

    private int usersNumber;
    private int adminsNumber;



    public DashboardInfos(int usersNumber, int adminsNumber) {
        this.usersNumber = usersNumber;
        this.adminsNumber = adminsNumber;
    }


    public DashboardInfos() {
    }

    public int getUsersNumber() {
        return usersNumber;
    }

    public void setUsersNumber(int usersNumber) {
        this.usersNumber = usersNumber;
    }

    public int getAdminsNumber() {
        return adminsNumber;
    }

    public void setAdminsNumber(int adminsNumber) {
        this.adminsNumber = adminsNumber;
    }


}
